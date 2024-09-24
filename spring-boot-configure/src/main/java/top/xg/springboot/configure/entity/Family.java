package top.xg.springboot.configure.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import top.xg.springboot.configure.loader.YamlLoader;

/**
 * @author Lenovo
 */
@Data
@Component
@ConfigurationProperties(prefix = "family")
//@PropertySource(value = {"classpath:family.properties"})
@PropertySource(value = {"classpath:family.yml"},factory = YamlLoader.class)
@Validated
public class Family {
    @Length(min = 5, max = 10,message = "家庭名称长度必须在5-10之间")
    private String familyName;
    private String father;
    private String mother;
    private String child;
}
