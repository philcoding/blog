package com.philcoding.blog.exception;

import com.philcoding.blog.enums.ResultCodeEnum;

public class UpdateFailureException extends CURDException {
    private static final long serialVersionUID = 1618471843948048104L;

    public UpdateFailureException() {
        super(ResultCodeEnum.LOGIC_UPDATE_ERROR.code(), ResultCodeEnum.LOGIC_UPDATE_ERROR.message());
    }

    public UpdateFailureException(ResultCodeEnum resultCode) {
        super(resultCode.code(), resultCode.message());
    }
}
