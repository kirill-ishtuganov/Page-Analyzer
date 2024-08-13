package hexlet.code.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UrlCheck {

    private Long id;
    private LocalDateTime createdAt;
    private int statusCode;
    private String title;
    private String h1;
    private String description;
    private Long urlId;

    public UrlCheck(Long urlId, int statusCode, String h1, String title, String description) {
        this.urlId = urlId;
        this.statusCode = statusCode;
        this.h1 = h1;
        this.title = title;
        this.description = description;
    }
}
