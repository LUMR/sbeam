package com.lumr.sbeam.vo.resp;

import com.lumr.sbeam.vo.ResponseCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by work on 2018/2/24.
 *
 * @author lumr
 */
@ApiModel(description = "响应公共类")
public class BaseResp {
    @ApiModelProperty(notes = "状态码")
    private String code;
    @ApiModelProperty(notes = "提示信息")
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
