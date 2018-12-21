package com.walker.user.exception;

/**
 * @author walker
 * @date 2018/12/21
 */
public class UserLoginException extends RuntimeException {
    public UserLoginException(String message) {
        super(message);
    }

    public UserLoginException(Throwable cause) {
        super(cause);
    }
}
