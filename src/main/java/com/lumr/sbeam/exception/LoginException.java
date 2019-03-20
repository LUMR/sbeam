package com.lumr.sbeam.exception;

/**
 * Created by lumr on 2017/5/9.
 */
public class LoginException extends RuntimeException {
    private static final long serialVersionUID = -3167917798774184988L;

    public LoginException() {
        super();
    }

    public LoginException(String message) {
        super(message);
    }

    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginException(Throwable cause) {
        super(cause);
    }

    protected LoginException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
