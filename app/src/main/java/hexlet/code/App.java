package hexlet.code;

import hexlet.code.controller.RootController;
import hexlet.code.controller.URLController;
import hexlet.code.utils.DatabaseConfig;
import hexlet.code.utils.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import gg.jte.ContentType;
import gg.jte.TemplateEngine;
import gg.jte.resolve.ResourceCodeResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private static final DataSource DATA_SOURCE = DatabaseConfig.getDataSource();

    public static void main(String[] args) {
        initializeDatabase();
        var app = getApp();
        app.start(getPort());
    }

    private static int getPort() {
        String port = System.getenv().getOrDefault("PORT", "7070");
        return Integer.parseInt(port);
    }

    public static Javalin getApp()  {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte(createTemplateEngine()));
        });

        app.before(ctx -> ctx.contentType("text/html; charset=utf-8"));

        app.get(NamedRoutes.mainPath(), RootController::index);

        app.post(NamedRoutes.urlsPath(), URLController::create);
        app.get(NamedRoutes.urlsPath(), URLController::index);
        app.get(NamedRoutes.urlPath(), URLController::show);

        return app;
    }

    static void initializeDatabase() {
        try (Connection conn = DATA_SOURCE.getConnection();
             Statement stmt = conn.createStatement();
             var resourceStream = App.class.getResourceAsStream("/schema.sql")) {

            if (resourceStream == null) {
                throw new IOException("Resource /schema.sql not found");
            }
            String sql = new String(resourceStream.readAllBytes());
            stmt.execute(sql);

        } catch (SQLException | IOException e) {
            LOGGER.error("Error initializing the database", e);
        }
    }

    private static TemplateEngine createTemplateEngine() {
        ClassLoader classLoader = App.class.getClassLoader();
        ResourceCodeResolver codeResolver = new ResourceCodeResolver("templates", classLoader);
        return TemplateEngine.create(codeResolver, ContentType.Html);
    }
}
