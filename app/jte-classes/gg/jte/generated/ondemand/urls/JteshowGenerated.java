package gg.jte.generated.ondemand.urls;
import hexlet.code.dto.urls.UrlPage;
import hexlet.code.dto.BasePage;
public final class JteshowGenerated {
	public static final String JTE_NAME = "urls/show.jte";
	public static final int[] JTE_LINE_INFO = {0,0,1,2,2,2,4,4,7,7,10,10,10,16,16,16,20,20,20,30,30,30,31,31,31,2,2,2,2};
	public static void render(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, UrlPage page) {
		jteOutput.writeContent("\n");
		gg.jte.generated.ondemand.layout.JtepageGenerated.render(jteOutput, jteHtmlInterceptor, new gg.jte.html.HtmlContent() {
			public void writeTo(gg.jte.html.HtmlTemplateOutput jteOutput) {
				jteOutput.writeContent("\n        <section>\n                <div class=\"container-lg mt-5\">\n                        <h1>Сайт: ");
				jteOutput.setContext("h1", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</h1>\n\n                        <table class=\"table table-bordered table-hover mt-3\">\n                                <tbody>\n                                <tr>\n                                        <td>ID</td>\n                                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getId());
				jteOutput.writeContent("</td>\n                                </tr>\n                                <tr>\n                                        <td>Имя</td>\n                                        <td>");
				jteOutput.setContext("td", null);
				jteOutput.writeUserContent(page.getUrl().getName());
				jteOutput.writeContent("</td>\n                                </tr>\n                                <tr>\n                                        <td>Дата создания</td>\n                                        <td></td>\n                                </tr>\n                                </tbody>\n                        </table>\n                </div>\n        </section>\n    ");
			}
		}, new BasePage());
		jteOutput.writeContent("\n");
	}
	public static void renderMap(gg.jte.html.HtmlTemplateOutput jteOutput, gg.jte.html.HtmlInterceptor jteHtmlInterceptor, java.util.Map<String, Object> params) {
		UrlPage page = (UrlPage)params.get("page");
		render(jteOutput, jteHtmlInterceptor, page);
	}
}
