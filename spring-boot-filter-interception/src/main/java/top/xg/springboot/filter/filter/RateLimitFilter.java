package top.xg.springboot.filter.filter;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Lenovo
 */
@Slf4j
public class RateLimitFilter implements Filter {
    private static final int LIMIT = 5;
    private static final int TIME_WINDOW = 60 * 1000;
    private static final ConcurrentHashMap<String,UserRequest> USER_REQUEST = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String,String> CAPTCHA_STORE = new ConcurrentHashMap<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("RateLimitFilter 初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String clientIp = httpRequest.getRemoteAddr();
        UserRequest userRequest = USER_REQUEST.compute(clientIp,(key,value) -> {
            if (value == null || System.currentTimeMillis() - value.timestamp > TIME_WINDOW) {
                return new UserRequest(1,System.currentTimeMillis());
            }else{
                value.count++;
                return value;
            }
        });

        if (userRequest.count > LIMIT) {
            LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200,100);
            String code = lineCaptcha.getCode();
            CAPTCHA_STORE.put(clientIp,code);
            response.setContentType("image/png");
            ServletOutputStream out = response.getOutputStream();
            lineCaptcha.write(out);
            out.flush();
            out.close();
            return;
        }

        chain.doFilter(request, response);

    }

    @Override
    public void destroy() {
        log.info("RateLimitFilter 销毁");
    }

    private static class UserRequest {
        int count;
        long timestamp;

        public UserRequest(int count, long timestamp) {
            this.count = count;
            this.timestamp = timestamp;
        }
    }
}
