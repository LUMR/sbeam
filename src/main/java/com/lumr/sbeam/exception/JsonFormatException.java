package com.lumr.sbeam.exception;

/**
 * json化时出现的异常
 * Created by work on 2017/11/2.
 *
 * @author lumr
 */
public class JsonFormatException extends RuntimeException{
    private static final long serialVersionUID = 4750380651437339760L;

    public JsonFormatException() {
        super();
    }

    public JsonFormatException(String message) {
        super(message);
    }

    public JsonFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public JsonFormatException(Throwable cause) {
        super(cause);
    }

    protected JsonFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
