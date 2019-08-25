package com.philcoding.blog.enums;

public enum StatusEnum {
    UNPUBLISHED(0, "未发布"),
    PUBLISHED(1, "已发布"),
    LOCKED(2, "已锁定");

    private final int code;

    private final String desc;

    StatusEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int code() {
        return code;
    }

    public String desc() {
        return desc;
    }
}
