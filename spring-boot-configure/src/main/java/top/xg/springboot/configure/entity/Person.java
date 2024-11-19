<<<<<<< HEAD
package top.xg.springboot.configure.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
@Component
@ConfigurationProperties(prefix = "person")

public class Person {
    private String firstName;
    private String lastName;
    private Integer age;
    private UUID id;
    private Integer phone;
}
=======
package top.xg.springboot.configure.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.UUID;

>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
