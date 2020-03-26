package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ScClass implements Serializable {
    @ApiModelProperty(value = "分类id")
    private Integer id;

    @ApiModelProperty(value = "隶属年级")
    private Integer deptId;

    @ApiModelProperty(value = "名称")
    private String className;

    @ApiModelProperty(value = "班级类型 如 0：普通 1：实验班 2：强化班")
    private Byte classType;

    @ApiModelProperty(value = "班主任")
    private Integer headmaster;

    @ApiModelProperty(value = "教室ID")
    private Integer room;

    @ApiModelProperty(value = "是否启用（0否，1是）")
    private Boolean isEnable;

    @ApiModelProperty(value = "顺序")
    private Byte sort;

    @ApiModelProperty(value = "添加时间")
    private Integer createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "简介（不超过255 字符）")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Byte getClassType() {
        return classType;
    }

    public void setClassType(Byte classType) {
        this.classType = classType;
    }

    public Integer getHeadmaster() {
        return headmaster;
    }

    public void setHeadmaster(Integer headmaster) {
        this.headmaster = headmaster;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", deptId=").append(deptId);
        sb.append(", className=").append(className);
        sb.append(", classType=").append(classType);
        sb.append(", headmaster=").append(headmaster);
        sb.append(", room=").append(room);
        sb.append(", isEnable=").append(isEnable);
        sb.append(", sort=").append(sort);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}