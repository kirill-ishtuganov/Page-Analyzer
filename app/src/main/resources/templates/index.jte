@import hexlet.code.dto.MainPage
@param MainPage page

@template.layout.page(
    content = @`
        <a>${page.getMessage()}</a>
    `
)