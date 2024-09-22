package uz.pdp.flyway.dto;

import lombok.*;

import java.time.Instant;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserCreateDTO {
    private String name;
    private Integer age;
    private Instant createdAt;
    private Instant updatedAt;
}