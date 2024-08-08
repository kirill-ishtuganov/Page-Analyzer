package gg.jte.generated.ondemand.layout;
import hexlet.code.utils.NamedRoutes;
import gg.jte.Content;
import hexlet.code.dto.BasePage;
public final class JtepageGenerated {
	public static final String JTE_NAME = "layout/page.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,3,3,3,23,23,23,23,23,23,23,23,23,23,26,26,26,26,26,26,26,26,26,35,35,36,36,36,36,37,37,37,40,40,43,43,43,57,57,57,3,4,4,4,4};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, Content content, BasePage page) {
		jteOutput.writeContent("\n<!doctype html>\n<html lang=\"en\">\n    <head>\n        <meta charset=\"utf-8\" />\n        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" />\n        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\n              rel=\"stylesheet\" integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\n              crossorigin=\"anonymous\">\n        <title>Анализатор страниц</title>\n    </head>\n    <body>\n\n        <nav class=\"navbar navbar-expand navbar-dark bg-dark\" aria-label=\"Second navbar example\">\n            <div class=\"container-fluid\">\n                <div class=\"collapse navbar-collapse\" id=\"navbarsExample02\">\n                    <ul class=\"navbar-nav me-auto\">\n                        <li class=\"nav-item\">\n                            <a class=\"nav-link active\" aria-current=\"page\"");
		var __jte_html_attribute_0 = NamedRoutes.mainPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_0)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_0);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Главная</a>\n                        </li>\n                        <li class=\"nav-item\">\n                            <a class=\"nav-link active\" aria-current=\"page\"");
		var __jte_html_attribute_1 = NamedRoutes.urlsPath();
		if (gg.jte.runtime.TemplateUtils.isAttributeRendered(__jte_html_attribute_1)) {
			jteOutput.writeContent(" href=\"");
			jteOutput.setContext("a", "href");
			jteOutput.writeUserContent(__jte_html_attribute_1);
			jteOutput.setContext("a", null);
			jteOutput.writeContent("\"");
		}
		jteOutput.writeContent(">Сайты</a>\n                        </li>\n                    </ul>\n                </div>\n            </div>\n        </nav>\n\n        <main class=\"flex-grow-1\">\n\n            ");
		if (page != null && page.getFlash() != null) {
			jteOutput.writeContent("\n                <div class=\"alert alert-");
			jteOutput.setContext("div", "class");
			jteOutput.writeUserContent(page.getFlashType());
			jteOutput.setContext("div", null);
			jteOutput.writeContent("\" role=\"alert\">\n                    <p>");
			jteOutput.setContext("p", null);
			jteOutput.writeUserContent(page.getFlash());
			jteOutput.writeContent("</p>\n                <button type=\"button\" class=\"btn-close\" data-bs-dismiss=\"alert\" aria-label=\"Close\"></button>\n            </div>\n        ");
		}
		jteOutput.writeContent("\n\n            <section>\n                ");
		jteOutput.setContext("section", null);
		jteOutput.writeUserContent(content);
		jteOutput.writeContent("\n            </section>\n        </main>\n\n            <footer class=\"footer border-top py-3 mt-5 bg-light\">\n                <div class=\"container-xl\">\n                    <div class=\"text-center\">\n                        Ссылка на мой GitHub\n                        <a href=\"https://github.com/kirill-ishtuganov\" target=\"_blank\">kirill-ishtuganov</a>\n                    </div>\n                </div>\n            </footer>\n    </body>\n</html>\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		Content content = (Content)params.get("content");
		BasePage page = (BasePage)params.getOrDefault("page", null);
		render(jteOutput, jteHtmlInterceptor, content, page);
	}
}
