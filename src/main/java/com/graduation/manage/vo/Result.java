package com.graduation.manage.vo;

public class Result {

    private Boolean flag;

    private String msg;

    public static Result success(){
        Result res = new Result();
        res.setFlag(true);
        return res;
    }

    public static Result error(String msg){
        Result res = new Result();
        res.setFlag(false);
        res.setMsg(msg);
        return res;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
