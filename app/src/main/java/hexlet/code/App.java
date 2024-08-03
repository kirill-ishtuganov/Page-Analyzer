package hexlet.code;

import hexlet.code.controllers.RootController;
import hexlet.code.utils.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

public class App {

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });
        return app;
    }

    public static void main(String[] args) {
        var app = getApp();

        app.get(NamedRoutes.mainPath(), RootController::index);

        app.start(7070);
    }
}
