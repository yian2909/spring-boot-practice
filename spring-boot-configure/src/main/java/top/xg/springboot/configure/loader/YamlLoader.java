package top.xg.springboot.configure.loader;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @author Lenovo
 */
public class YamlLoader extends DefaultPropertySourceFactory {
    public PropertySource<?> createPropertySource(@Nullable String name, @Nullable EncodedResource resource) throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if (sourceName != null && (sourceName.endsWith(".yaml") ||  sourceName.endsWith(".yml"))) {
            Properties properties = loadYml(resource);
            return new PropertiesPropertySource(sourceName, properties);
        }else {
            return super.createPropertySource(name,resource);
        }
    }

    private Properties loadYml(EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
