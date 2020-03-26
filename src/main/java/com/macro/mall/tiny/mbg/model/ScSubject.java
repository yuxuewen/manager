package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class ScSubject implements Serializable {
    @ApiModelProperty(value = "分类id")
    private Integer id;

    @ApiModelProperty(value = "学科编号")
    @NotEmpty(message = "subjectCode 不能为空")
    private String subjectCode;

    @ApiModelProperty(value = "科目名称")
    @NotEmpty(message = "subjectName 不能为空")
    private String subjectName;

    @ApiModelProperty(value = "所属组织机构 （例如七年级的课）")
    @NotEmpty(message = "deptId 不能为空")
    private String deptId;

    @ApiModelProperty(value = "是否启用（0否，1是）")

    private Integer isEnable;
    @ApiModelProperty(value = "顺序")
    private Byte sort;

    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "备注")
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    public Byte getSort() {
        return sort;
    }

    public void setSort(Byte sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
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
        sb.append(", subjectCode=").append(subjectCode);
        sb.append(", subjectName=").append(subjectName);
        sb.append(", deptId=").append(deptId);
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