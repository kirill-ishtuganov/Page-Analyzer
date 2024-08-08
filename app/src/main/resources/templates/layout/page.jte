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

        <nav class="navbar navbar-expand navbar-dark bg-dark" aria-label="Second navbar example">
            <div class="container-fluid">
                <div class="collapse navbar-collapse" id="navbarsExample02">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${NamedRoutes.mainPath()}">Главная</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="${NamedRoutes.urlsPath()}">Сайты</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <main class="flex-grow-1">

            @if(page != null && page.getFlash() != null)
                <div class="alert alert-${page.getFlashType()}" role="alert">
                    <p>${page.getFlash()}</p>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>
        @endif

            <section>
                ${content}
            </section>
        </main>

            <footer class="footer border-top py-3 mt-5 bg-light">
                <div class="container-xl">
                    <div class="text-center">
                        Ссылка на мой GitHub
                        <a href="https://github.com/kirill-ishtuganov" target="_blank">kirill-ishtuganov</a>
                    </div>
                </div>
            </footer>
    </body>
</html>
