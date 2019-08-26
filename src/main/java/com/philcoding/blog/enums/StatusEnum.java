package com.philcoding.blog.enums;

public enum StatusEnum {
    DRAFT(0, "草稿"),
    PUBLISHED(1, "已发布"),
    DELETED(2, "已删除");

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
