@import hexlet.code.dto.urls.UrlPage
@param UrlPage page

@template.layout.page(
content = @`
        <a>${page.getUrl().getId()}</a>
        <a>${page.getUrl().getName()}</a>
        <a>${page.getUrl().getCreatedAt().toString()}</a>
    `
)
