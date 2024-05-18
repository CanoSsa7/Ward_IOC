package com.example.ward.Interceptor;

import com.alibaba.fastjson.JSON;
import com.aliyun.oss.common.utils.StringUtils;
import com.example.ward.Utilis.JwtUtils;
import com.example.ward.Utilis.Result;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    // 暂未启用，未注册
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        String url = req.getRequestURL().toString();
        log.info("URL：{}", url);
        String jwt = req.getHeader("jwt"); //从请求头中获取JWT
        if(StringUtils.isNullOrEmpty(jwt)){ //请求携带的JWT为空，未登录
            System.out.println("令牌信息为空");
            String json = JSON.toJSONString(Result.fail("NULL JWT"));
            resp.getWriter().write(json);
            return false;
        }
        try {
            JwtUtils.parseJWT(jwt);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("令牌信息有误");
            String json = JSON.toJSONString(Result.fail("WRONG JWT"));
            resp.getWriter().write(json);
            return false;
        }
        //令牌解析成功
        System.out.println("令牌解析成功");
        return true;

    }
}
