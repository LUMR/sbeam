package com.lumr.sbeam.vo.resp;

import com.lumr.sbeam.vo.ResponseCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by work on 2018/2/24.
 *
 * @author lumr
 */
@Getter
@Setter
public class BaseResp {
    private String code;
    private String message;

}
