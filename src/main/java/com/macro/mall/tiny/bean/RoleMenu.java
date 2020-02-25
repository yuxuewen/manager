package com.macro.mall.tiny.bean;

import java.io.Serializable;

public class RoleMenu implements Serializable {
    public long roleId;
    public long menuId;


    public RoleMenu(long roleId, long menuId) {
        this.roleId = roleId;
        this.menuId = menuId;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getMenuId() {
        return menuId;
    }

    public void setMenuId(long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "roleId=" + roleId +
                ", menuId=" + menuId +
                '}';
    }
}
