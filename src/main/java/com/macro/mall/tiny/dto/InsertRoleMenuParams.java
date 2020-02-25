package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

public class InsertRoleMenuParams {

    @ApiModelProperty(value = "角色Id", required = true)
    @NotEmpty(message = "roleId不能为空")
    private long roleId;
    @ApiModelProperty(value = "菜单Id，逗号分隔", required = true)
    @NotEmpty(message = "menusId不能为空")
    private String menusId;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getMenusId() {
        return menusId;
    }

    public void setMenusId(String menusId) {
        this.menusId = menusId;
    }

    public InsertRoleMenuParams(@NotEmpty(message = "roleId不能为空") long roleId, @NotEmpty(message = "menusId不能为空") String menusId) {
        this.roleId = roleId;
        this.menusId = menusId;
    }


}
