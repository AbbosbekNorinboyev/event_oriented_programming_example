package uz.pdp.flyway.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BlogCreateDTO {
    private String title;
    private String description;
}
