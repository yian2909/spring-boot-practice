package top.xg.springboot.filter.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import top.xg.springboot.filter.interceptor.AuthInterceptor;
import top.xg.springboot.filter.interceptor.CORSInterceptor;
import top.xg.springboot.filter.interceptor.LoggingInterceptor;
import top.xg.springboot.filter.interceptor.PhotoUploadInterceptor;

/**
 * @author Lenovo
 */
@Configuration
@AllArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final LoggingInterceptor loggingInterceptor;
    private final AuthInterceptor authInterceptor;
    private final PhotoUploadInterceptor photoUploadInterceptor;
    private final CORSInterceptor corsInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loggingInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(authInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(photoUploadInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");
    }
}
