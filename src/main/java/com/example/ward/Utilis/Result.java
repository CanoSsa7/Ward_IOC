package com.example.ward.Utilis;

import lombok.Data;

@Data
public class Result {
    private int code;
    private String msg;
    private Object data;

    // 构造方法
    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Object data) {
        this.data = data;
    }

    public static Result success(){
        return new Result(1, "success", null);
    }
    public static Result fail(){
        return new Result(0, "fail", null);
    }
    public static Result success(Object o){
        return new Result(1, "success", o);
    }
    public static Result fail(Object o){
        return new Result(0, "fail", o);
    }
}

