package com.example.ward.AOP;

import com.alibaba.fastjson.JSONObject;
import com.example.ward.Dao.OperateLogMapper;
import com.example.ward.Entity.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class LogAspect {
//    @Autowired
//    HttpServletRequest request;
    @Autowired
    OperateLogMapper operateLogMapper;
    @Around("@annotation(com.example.ward.AOP.Mylog)")
    Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // TODO: 2024/5/17 jwt校验获取操作用户名？
//        从jwt中获取操作人的id
//        String jwt = request.getHeader("jwt");
//        Claims claims = JwtUtils.parseJWT(jwt);
//        String operateUser = (String) claims.get("username");

        String operateUser = "admin"; //先把操作用户写死为admin
        //获取操作的执行时间
        LocalDateTime operateTime = LocalDateTime.now();

        //获取操作类名
        String className = joinPoint.getTarget().getClass().toString();

        //获取方法名
        String methodName = joinPoint.getSignature().getName();

        //获取方法的参数
        String methodParams = Arrays.toString(joinPoint.getArgs());

        //记录开始时间
        long start = System.currentTimeMillis();
        //执行原函数
        Object obj = joinPoint.proceed();
        //记录结束时间
        long end = System.currentTimeMillis();
        //计算操作耗时
        Long costTime = end - start;
        //获取返回值，
        String returnValue = JSONObject.toJSONString(obj);

        OperateLog operateLog = new OperateLog(null, operateUser, operateTime,
                className, methodName, methodParams, returnValue, costTime);
        operateLogMapper.insert(operateLog); //记录操作日志

        System.out.println(operateLog.toString());
        return obj;
    }
}
