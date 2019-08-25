package com.philcoding.blog.exception;

import com.philcoding.blog.enums.ResultCodeEnum;

public class DeteleFailureException extends CURDException {
    private static final long serialVersionUID = -2669056378294428319L;

    public DeteleFailureException() {
        super(ResultCodeEnum.LOGIC_DELETE_ERROR.code(), ResultCodeEnum.LOGIC_DELETE_ERROR.message());
    }

    public DeteleFailureException(ResultCodeEnum resultCode) {
        super(resultCode.code(), resultCode.message());
    }
}
