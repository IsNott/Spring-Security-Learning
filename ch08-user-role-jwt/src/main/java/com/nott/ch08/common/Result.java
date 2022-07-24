package com.nott.ch08.common;

import lombok.Data;

@Data
public class Result {
    private String code;
    private String msg;
    private Object data;

    public Result(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Result success(String msg) {
        Result result = new Result("200", msg);
        return result;
    }

    public static Result fail(String msg) {
        Result result = new Result("-999", msg);
        return result;
    }


    public static Result successData(Object data) {
        Result result = new Result("200", "success", data);
        return result;
    }

}
