package com.pxd.common.result.result;

import com.pxd.common.result.enums.ErrorCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 响应数据
 */
@ApiModel(value = "响应")
@Data
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 编码：0表示成功，其他值表示失败
     */
    @ApiModelProperty(value = "编码：0表示成功，其他值表示失败")
    private int code = 0;
    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容")
    private String msg = "success";
    /**
     * 响应数据
     */
    @ApiModelProperty(value = "响应数据")
    private T data;

    public static <T> Result<T> ok() {
        Result<T> result = new Result<>();
        return result;
    }

    public static <T> Result<T> ok(T data) {
        Result<T> result = new Result<>();
        result.setData(data);
        return result;
    }

    public static <T> Result<T> fail() {
        Result<T> result = new Result<>();
        result.setCode(ErrorCodeEnum.FAIL.getCode());
        result.setMsg(ErrorCodeEnum.FAIL.getDesc());
        return result;
    }

    public static <T> Result<T> error(int code) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg("error");
        return result;
    }

    public static <T> Result<T> error(int code, String msg) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.setCode(ErrorCodeEnum.FAIL.getCode());
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> result(ErrorCodeEnum errorCodeEnum) {
        Result<T> result = new Result<>();
        result.setCode(errorCodeEnum.getCode());
        result.setMsg(errorCodeEnum.getDesc());
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
