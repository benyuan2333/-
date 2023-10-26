package com.ssix.project02.dto;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResultMessage implements  java.io.Serializable {

    private final static Integer EX_SUCCESS=200;//成功
    private final static Integer EX_ERROR=400;//错误
    private final static Integer EX_FAIL=300;//失败

    private PageInfo pageInfo;
    private Integer status;//状态码
    private String message;//消息
    private Object data;//数据

    public ResultMessage(Integer status,String message,Object data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static ResultMessage BY_SUCCESS(String msg,Object data){
        return new ResultMessage(ResultMessage.EX_SUCCESS,msg,data);
    }

    public static ResultMessage BY_FAIL(String msg,Object data){
        return new ResultMessage(ResultMessage.EX_FAIL,msg,data);
    }

}