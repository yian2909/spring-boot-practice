package top.ssy.share.app;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Lenovo
 */
@SpringBootApplication
@MapperScan(basePackages = {"top.ssy.share.app.mapper"})
public class ShareAppApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareAppApiApplication.class, args);
    }

}
