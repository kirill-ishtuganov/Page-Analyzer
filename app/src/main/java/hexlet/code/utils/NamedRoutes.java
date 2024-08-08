package hexlet.code.utils;

public class NamedRoutes {

    public static String mainPath() {
        return "/";
    }

    public static String urlsPath() {
        return "/urls";
    }

    public static String urlPath(Long id) {
        return "/urls/" + id;
    }

    public static String urlPath() {
        return "/urls/{id}";
    }
}
