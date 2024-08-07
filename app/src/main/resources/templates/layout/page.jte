@import hexlet.code.utils.NamedRoutes
@import gg.jte.Content
@import hexlet.code.dto.BasePage
@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
              rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
              crossorigin="anonymous">
        <title>Анализатор страниц</title>
    </head>
    <body>
        <div class="b-example-divider"></div>

        <div class="container">
            <header class="d-flex justify-content-center py-3">
                <ul class="nav nav-pills">
                    <li class="nav-item"><a href="${NamedRoutes.mainPath()}" class="nav-link active">Главная</a></li>
                </ul>
            </header>
        </div>
        @if(page != null && page.getFlash() != null)
            <p>${page.getFlash()}</p>
        @endif
        <div>
            ${content}
        </div>

        <div class="container">
            <footer class="d-flex flex-wrap justify-content-between align-items-center py-3 my-4 border-top">
                <div class="col-md-4 d-flex align-items-center">
                    <a href="/" class="mb-3 me-2 mb-md-0 text-muted text-decoration-none lh-1">
                        <svg class="bi" width="30" height="24"><use xlink:href="#bootstrap"/></svg>
                    </a>
                    <a href="https://github.com/kirill-ishtuganov" class="text-muted">My GitHub</a>
                </div>
            </footer>
        </div>
    </body>
</html>
