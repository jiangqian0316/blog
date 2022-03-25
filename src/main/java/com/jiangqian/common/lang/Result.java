package com.jiangqian.common.lang;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jiangqian.entity.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private int code; //200是正常 非200数据异常
    private String msg;
    private Object data;

    public static Result succ(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }
    public static Result succ(Object data){
        return Result.succ(200,"操作成功",data);
    }
    public static Result fail(int code, String msg, Object data){
        Result r = new Result();
        r.setCode(code);
        r.setData(data);
        r.setMsg(msg);
        return r;
    }

    public static Result fail(String msg,Object data){

        return fail(400,msg,data);
    }

}
