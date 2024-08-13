package hexlet.code.dto.urls;

import hexlet.code.dto.BasePage;
import hexlet.code.model.Url;
import hexlet.code.model.UrlCheck;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class UrlPage extends BasePage {
    private Url url;
    private List<UrlCheck> checkList;

    public UrlPage(Url url, List<UrlCheck> checkLis) {
        this.url = url;
        this.checkList = checkLis;
    }

    public UrlPage(Url url) {
        this.url = url;
    }

}
