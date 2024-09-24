package top.xg.springboot.configure.entity;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NonNull;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;

/**
 * @author Lenovo
 */
@Data
public class User {
    @NotNull
    @Size(min = 3, max = 8)
    private String userName;
    @NotBlank
    private String password;
    @Email
    private String email;
    @Min(18)
    @Max(100)
    private int age;
    @Pattern(regexp = "^[0-9]{11}$")
    private String phone;
    @Future
    private LocalDate date;
    @Positive
    private int score;
    @URL
    private String website;
}
