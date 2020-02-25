package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class ChangePassword {
    @ApiModelProperty(value = "用户名", required = true)
    @NotNull(message = "用户名不能为空")
    @NotEmpty(message = "用户名不能为空")
    private String userName;
    @ApiModelProperty(value = "旧密码", required = true)
    @NotEmpty(message = "旧密码不能为空")
    private String oldPassword;
    @ApiModelProperty(value = "旧密码", required = true)
    @NotEmpty(message = "旧密码不能为空")
    private String newPassword;

    public ChangePassword(@NotEmpty(message = "用户名不能为空") String userName, @NotEmpty(message = "旧密码不能为空") String oldPassword, @NotEmpty(message = "旧密码不能为空") String newPassword) {
        this.userName = userName;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
