package hexlet.code.controllers;

import io.javalin.http.Context;

public class RootController {

    public static void index(Context ctx) {
        ctx.result("Hello World");
    }
}
