package io.github.pj.cattletraceabilitybackendsss.interceptors;

import io.github.pj.cattletraceabilitybackendsss.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);
            Integer userId = jwtUtils.getUserIdFromToken(token);
            if (userId != null) {
                // 将用户ID存储在请求属性中
                request.setAttribute("userId", userId);
                return true;
            }
        }
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
//这是一个登录拦截器,用于验证请求中的JWT令牌。如果令牌有效,它会将用户ID存储在请求属性中,以供后续使用。如果令牌无效或缺失,它会返回401未授权状态码。
// WebMvcConfig.java
