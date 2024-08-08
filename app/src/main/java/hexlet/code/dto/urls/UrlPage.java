package hexlet.code.dto.urls;

import hexlet.code.model.Url;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UrlPage {
    private Url url;
    public UrlPage(Url url) {
        this.url = url;
    }
}
