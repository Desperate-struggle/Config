package com.zhangzhipeng.dc.vo;


public class ResponseVO<T> {//泛型类

    private int code;
    private String msg;
    private T data;

    public static <T> ResponseVO success(T data){//泛型方法
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(data);
        responseVO.setMsg(CodeMsg.SUCCESS.getMsg());
        responseVO.setCode(CodeMsg.SUCCESS.getCode());
        return responseVO;
    }

    public static <T> ResponseVO error(CodeMsg codeMsg){//泛型方法
        ResponseVO responseVO = new ResponseVO();
        responseVO.setCode(codeMsg.getCode());
        responseVO.setMsg(codeMsg.getMsg());
        return responseVO;
    }

    @Override
    public String toString() {
        return "ResponseVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
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
