<<<<<<< HEAD
package top.xg.springboot.configure.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 */
@Data
@Component
public class Dog {
    @Value("${student.dog.name}")
    private String name;
    @Value("${student.dog.age}")
    private Integer age;
}
=======
package top.xg.springboot.configure.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
