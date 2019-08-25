package com.philcoding.blog.exception;

import com.philcoding.blog.enums.ResultCodeEnum;

public class CreateFailureException extends CURDException {
    private static final long serialVersionUID = 7629980039493241439L;

    public CreateFailureException() {
        super(ResultCodeEnum.LOGIC_CREATE_ERROR.code(), ResultCodeEnum.LOGIC_CREATE_ERROR.message());
    }

    public CreateFailureException(ResultCodeEnum resultCode) {
        super(resultCode.code(), resultCode.message());
    }
}
