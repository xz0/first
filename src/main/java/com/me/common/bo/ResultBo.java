package com.me.common.bo;

/**
 * Created by C167 on 2016/4/10.
 */
public class ResultBo {
    public static final int BOOLEAN_TRUE = 1;
    public static final int BOOLEAN_FAIL = 0;

    private int state =BOOLEAN_TRUE;
    private String msg;

    public ResultBo(int state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
