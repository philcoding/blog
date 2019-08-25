package com.philcoding.blog.enums;

public enum ResultCodeEnum {

    SUCCESS(200, "SUCCESS", "成功"),
    FAIL(400, "请求无效", "请求无效"),
    UNAUTHORIZED(401, "授权校验失败", "未认证（用户身份验证错误）"),
    FORBIDDEN(403, "无权限访问", "拒绝访问"),
    NOT_FOUND(404, "请求资源无效", "无法找到文件"),
    INTERNAL_SERVER_ERROR(500, "服务器内部错误", "服务器内部错误"),

    LOGIC_CREATE_ERROR(400010, "新增失败", "新增业务逻辑错误"),
    BLOG_TITLE_EXIST_CREATE_ERROR(400011, "博文标题已存在，请确认", "新增博文业务逻辑错误"),

    LOGIC_UPDATE_ERROR(400020, "更新失败", "更新业务逻辑错误"),
    BLOG_TITLE_EXIST_UPDATE_ERROR(400021, "博文标题已存在，请确认", "更新博文业务逻辑错误"),
    BLOG_PUBLISH_UPDATE_ERROR(400022, "博文发布失败", "更新博文业务逻辑错误"),
    BLOG_UNPUBLISH_UPDATE_ERROR(400023, "博文取消发布失败", "更新博文业务逻辑错误"),

    LOGIC_DELETE_ERROR(400030, "删除失败", "删除业务逻辑错误");

    private final int code;
    private final String message;
    private final String desc;

    ResultCodeEnum(int code, String message, String desc) {
        this.code = code;
        this.message = message;
        this.desc = desc;
    }

    public int code() {
        return code;
    }

    public String message() {
        return message;
    }
}
