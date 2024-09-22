package uz.pdp.flyway.dto;

import lombok.*;
import uz.pdp.flyway.entity.Blog;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CommentCreateDTO {
    private String author;
    private String message;
    private Blog blog;

}
