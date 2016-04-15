package com.me.sys.entity;

import java.util.Date;

public class UserPo {
    private Integer id;

    private String loginName;

    private String showName;

    private Date dt;

    private String password;

    private String email;

    private String mobile;

    private String qq;

    private Integer defaultShowMenu;

    private String generalVerificationCode;

    private String remark;

    private Byte state;

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName == null ? null : showName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Integer getDefaultShowMenu() {
        return defaultShowMenu;
    }

    public void setDefaultShowMenu(Integer defaultShowMenu) {
        this.defaultShowMenu = defaultShowMenu;
    }

    public String getGeneralVerificationCode() {
        return generalVerificationCode;
    }

    public void setGeneralVerificationCode(String generalVerificationCode) {
        this.generalVerificationCode = generalVerificationCode == null ? null : generalVerificationCode.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}