package top.xg.springboot.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.time.LocalDateTime;

/**
 * @author Lenovo
 */
@Slf4j
public class LoggingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("LoggingFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest re = (HttpServletRequest) request;
        //请求路径
        String path = re.getRequestURI();
        String clientIp = re.getRemoteAddr();
        LocalDateTime beginTime = LocalDateTime.now();
        log.info("请求已到达过滤器:path:{},clientIp:{},beginTime:{}",path,clientIp,beginTime);
        chain.doFilter(request, response);
        log.info("过滤器响应处理完毕:path:{},endTime:{}",path,LocalDateTime.now());
    }

    @Override
    public void destroy() {
        log.info("LoggingFilter 销毁");
    }
}
