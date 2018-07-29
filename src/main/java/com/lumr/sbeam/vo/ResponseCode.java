package com.lumr.sbeam.vo;

/**
 * 返回代码
 *
 * @author lumr
 */
public enum ResponseCode {
    /**
     * 0是正常返回
     */
    SUCCESS("0"),
    /**
     * -1表示处理失败
     */
    FAIL("-1"),
    /**
     * -2表示账号或密码错误
     */
    PASSORACCOUNTERR("-2"),
    /**
     * -3表示未登录
     */
    NOTLOGIN("-3"),
    /**
     * -4表示输入参数有误
     */
    PARAMETERERR("-4"),

    NONE_DATAS("-5"),
    /**
     * -6激活码已用完
     */
    NONE_MACHINE("-6"),
    /**
     * -7激活码不存在
     */
    NONE_MACHINE_ESITS("-7"),
    /**
     * -8已激活
     */
    MACHINE_ESITS("-8"),
    /**
     * -99表示服务器异常
     */
    SERVERERR("-99");

    private String code;

    public String getCode() {
        return this.code;
    }

    ResponseCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }


}

