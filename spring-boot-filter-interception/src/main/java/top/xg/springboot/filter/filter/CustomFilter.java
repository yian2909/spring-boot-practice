package top.xg.springboot.filter.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Lenovo
 */
@Slf4j
public class CustomFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //过滤器初始化时调用,可以配置一些初始化参数
        log.info("CustomFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //在请求处理之前执行的逻辑
        log.info("请求处理中");
        //将请求传递给下一个过滤器或目标资源
        chain.doFilter(request, response);
        //
        log.info("响应后处理中");
    }

    @Override
    public void destroy() {
        //过滤器被移除时调用
        log.info("CustomFilter 销毁");
    }
}
