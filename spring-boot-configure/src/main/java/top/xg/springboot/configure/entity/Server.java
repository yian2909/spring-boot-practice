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
public class Server {
    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private int port;

    @Value("${server.context-path}")
    private String path;
}
=======
package top.xg.springboot.configure.entity;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

>>>>>>> 3a445c108c2cb986de68ce29000d3e6bf4ca24b3
