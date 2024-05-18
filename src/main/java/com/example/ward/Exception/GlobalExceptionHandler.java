package com.example.ward.Exception;

import com.example.ward.Utilis.Result;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public Result handler(Exception e){
        e.printStackTrace();
        return Result.fail("Wrong Server Response");
    }
    @ExceptionHandler(PatientNotFoundException.class) //未查询到指定病人
    public Result handler(PatientNotFoundException e){
        e.printStackTrace();
        return Result.fail("未查询到病人信息");
    }
    @ExceptionHandler(NurseNotFoundException.class) //未查询到指定护士
    public Result handler(NurseNotFoundException e){
        e.printStackTrace();
        return Result.fail("未查询到护士信息");
    }
    @ExceptionHandler(OrderNotFoundException.class)//未查询到指定医嘱信息
    public Result handler(OrderNotFoundException e){
        e.printStackTrace();
        return Result.fail("未查询到医嘱信息");
    }
    //处理请求参数缺失问题
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Result handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();  // 获取缺失的参数名
        String type = ex.getParameterType();  // 获取缺失的参数类型
        // 返回一个错误信息给前端
        String errorMsg = "请求缺少参数：" + name+ "，类型为：" + type;
        return Result.fail(errorMsg);
    }

}
