<<<<<<< HEAD
package top.xg.springboot.configure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mail {
    private String to;
    private String subject;
    private String content;
}
=======
package top.xg.springboot.configure.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
