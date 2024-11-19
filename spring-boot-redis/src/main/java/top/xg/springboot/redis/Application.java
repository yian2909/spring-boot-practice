package top.xg.springboot.redis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author gx
 * @date 2024/9/2
 * @description Application
 **/
@SpringBootApplication
@MapperScan(basePackages = {"top.xg.springboot.redis.mapper"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
