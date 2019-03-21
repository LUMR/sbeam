package com.lumr.sbeam.vo.resp;

import com.lumr.sbeam.vo.ResponseCode;

/**
 * Created by work on 2018/2/24.
 *
 * @author lumr
 */
public class BaseResp {
    private String code;
    private String message;

    public String getCode() {
        return code;
    }

    public void setCode(ResponseCode code) {
        this.code = code.getCode();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
