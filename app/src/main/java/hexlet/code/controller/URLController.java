package hexlet.code.controller;

import hexlet.code.dto.urls.UrlPage;
import hexlet.code.dto.urls.UrlsPage;
import hexlet.code.model.Url;
import hexlet.code.repository.UrlRepository;
import hexlet.code.utils.NamedRoutes;
import io.javalin.http.Context;

import java.net.URI;
import java.sql.SQLException;

import static io.javalin.rendering.template.TemplateUtil.model;

public class URLController {

    public static void create(Context ctx) {

        try {
            var term = ctx.formParamAsClass("url", String.class).get();
            var url = new URI(term).toURL().toExternalForm();
            var duplicate = UrlRepository.search(url);
            if (duplicate.isPresent()) {
                ctx.sessionAttribute("flashType", "info");
                ctx.sessionAttribute("flash", "Страница уже существует");
                ctx.redirect(NamedRoutes.mainPath());
            }

            UrlRepository.save(new Url(url));
            ctx.sessionAttribute("flashType", "success");
            ctx.sessionAttribute("flash", "Страница успешно добавлена");
            ctx.redirect(NamedRoutes.urlsPath());
        } catch (Exception e) {
            ctx.sessionAttribute("flashType", "danger");
            ctx.sessionAttribute("flash", "Некорректный URL");
            ctx.redirect(NamedRoutes.mainPath());
        }
    }

    public static void index(Context ctx) throws SQLException {

        var page = new UrlsPage(UrlRepository.getEntities());
        page.setFlashType(ctx.consumeSessionAttribute("flashType"));
        page.setFlash(ctx.consumeSessionAttribute("flash"));
        ctx.render("urls/index.jte", model("page", page));
    }

    public static void show(Context ctx) {
        try {
            var id = ctx.pathParamAsClass("id", Long.class).get();
            var url = UrlRepository.find(id);
            var page = new UrlPage(url);
            ctx.render("courses/show.jte", model("page", page));
        } catch (SQLException e) {
            ctx.sessionAttribute("flashType", "danger");
            ctx.sessionAttribute("flash", "Некорректный id");
            ctx.redirect(NamedRoutes.urlsPath());
        }
    }
}
