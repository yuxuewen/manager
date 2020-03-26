package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

public class SearchTeacher extends PageSearch {
    //用户工号
    @ApiModelProperty(value = "工号")
    private String workerNum;
    //用户姓名
    @ApiModelProperty(value = "用户姓名")
    private String userName;
    @ApiModelProperty(value = "角色id")
    private String roleId;
    @ApiModelProperty(value = "组织机构id")
    private String orgId;

    public String getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(String workerNum) {
        this.workerNum = workerNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
