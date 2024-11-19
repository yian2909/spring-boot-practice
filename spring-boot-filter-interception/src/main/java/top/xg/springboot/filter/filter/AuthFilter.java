package top.xg.springboot.filter.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Lenovo
 */
@Slf4j
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("AuthFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String authToken = req.getHeader("Authorization");
        //是匹配的授权令牌
        if("hello".equals(authToken)) {
            //执行
            chain.doFilter(request, response);
        }else {
            //401错误
            res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            res.getWriter().write("UNAUTHORIZED");
        }
    }

    @Override
    public void destroy() {
        log.info("AuthFilter 销毁");
    }
}
