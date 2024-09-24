package top.xg.springboot.configure.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 */
@Data
@Component
public class Server {
    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private int port;

    @Value("${server.context-path}")
    private String path;
}
