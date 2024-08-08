@import hexlet.code.dto.urls.UrlsPage
@import hexlet.code.utils.NamedRoutes
@param UrlsPage page

@template.layout.page(
content = @`
    <table class="table table-striped">
        @for(var url : page.getUrls())
            <tr>
                <td>
                    <a>${url.getId()}</a>
                </td>
                <td>
                    <a href="${NamedRoutes.urlPath(url.getId())}">${url.getName()}</a>
                </td>
                <td>
                    <a>${url.getCreatedAt().toString()}</a>
                </td>
            </tr>
        @endfor
    </table>
    `
)
