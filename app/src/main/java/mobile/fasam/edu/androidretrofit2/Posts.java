package mobile.fasam.edu.androidretrofit2;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Posts {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
