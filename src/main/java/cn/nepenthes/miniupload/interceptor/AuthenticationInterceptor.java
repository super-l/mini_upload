package cn.nepenthes.miniupload.interceptor;

import cn.nepenthes.miniupload.annotation.PassToken;
import cn.nepenthes.miniupload.annotation.UserLoginToken;
import cn.nepenthes.miniupload.utils.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

public class AuthenticationInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        String token = httpServletRequest.getHeader("Authorization");// 从 http 请求头中取出 token

        // 如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod)object;
        Method method = handlerMethod.getMethod();

        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {

                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无权限!");
                }

                List<String> userData = JwtUtil.getUserData(token);
                if (userData == null || userData.size() < 2){
                    throw new RuntimeException("无权限,秘钥错误!");
                }

                if ( userData.get(0) == null){
                    throw new RuntimeException("无权限,秘钥错误(id)!");
                }

                if ( userData.get(1) == null){
                    throw new RuntimeException("无权限,秘钥错误(userName)!");
                }

                // 验证 token
                if ( !JwtUtil.checkSign(token)){
                    throw new RuntimeException("秘钥失效,请重新获取!");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
