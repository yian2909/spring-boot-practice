package top.xg.springboot.redis.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("gx 的 API")
                        .contact(new Contact().name("gx").email("915826506@qq.com"))
                        .version("1.0")
                        .description("gx 的 API 接口文档")
                        .license(new License().name("Apache 2.0").url("https://doc.xiaominfo.com"))
                );
    }
}
