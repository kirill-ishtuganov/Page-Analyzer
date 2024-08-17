@import hexlet.code.dto.urls.UrlsPage
@import hexlet.code.utils.Formatter
@import hexlet.code.utils.NamedRoutes
@param UrlsPage page

@template.layout.page(
    page = page,
    content = @`
        <div class="container-lg mt 5">
                <h1>Сайты</h1>
                <table class="table table-bordered table-hover mt-3">
                        <thead>
                        <tr>
                                <th class="col-1">ID</th>
                                <th>Имя</th>
                                <th class="col-2">Последняя проверка</th>
                                <th class="col-1">Код ответа</th>
                        </tr>
                        </thead>
                        <tbody>
                                @for(var url : page.getUrls())
                                        <tr>
                                                <td>
                                                        <a>${url.getId()}</a>
                                                </td>
                                                <td>
                                                        <a href="${NamedRoutes.urlPath(url.getId())}">
                                                                ${url.getName()}
                                                        </a>
                                                </td>
                                                <td>
                                                        <a>${page.getLastUrlChecks().get(url.getId()) == null ? "" :
                                                            Formatter.dateToString(
                                                                    page.getLastUrlChecks().get(url.getId())
                                                                    .getCreatedAt())}
                                                        </a>
                                                </td>
                                                <td>
                                                        <a>${page.getLastUrlChecks().get(url.getId()) == null ? "" :
                                                            String.valueOf(
                                                                    page.getLastUrlChecks().get(url.getId())
                                                                    .getStatusCode())}
                                                        </a>
                                                </td>
                                        </tr>
                                @endfor
                        </tbody>
                </table>
        </div>
    `
)
