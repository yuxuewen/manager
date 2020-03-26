package com.macro.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

public class ScTeacher implements Serializable {
    @ApiModelProperty(value = "学生id")
    private Integer id;
    @NotNull(message = "工号不能为空")
    @NotEmpty(message = "工号不能为空")
    @ApiModelProperty(value = "工号")
    private String workerNum;

    @NotNull(message = "身份证号码不能为空")
    @NotEmpty(message = "身份证号码工号不能为空")
    @ApiModelProperty(value = "身份证号码")
    private String idCard;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String username;

    @ApiModelProperty(value = "所属机构")
    private String orgIds;

    @ApiModelProperty(value = "角色")
    private String roleIds;

    @ApiModelProperty(value = "性别（0保密，1女，2男）")
    private Boolean gender;

    @ApiModelProperty(value = "生日")
    private Integer birthday;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "联系方式（手机或座机）")
    private String tel;

//    @Pattern(regexp = "\\^1(3|4|5|7|8)\\d{9}$")
    @ApiModelProperty(value = "手机号码")
    private String mobile;

    @ApiModelProperty(value = "电子邮箱（最大长度60个字符）")
    private String email;

    @ApiModelProperty(value = "教师状态（0待报道, 1在职, 2已离职, 3已退休, 4已开除）")
    private Byte state;

    private Date createTime;

    private Date updateTime;

    private Byte deleteFlag;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkerNum() {
        return workerNum;
    }

    public void setWorkerNum(String workerNum) {
        this.workerNum = workerNum;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOrgIds() {
        return orgIds;
    }

    public void setOrgIds(String orgIds) {
        this.orgIds = orgIds;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
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

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", workerNum=").append(workerNum);
        sb.append(", idCard=").append(idCard);
        sb.append(", password=").append(password);
        sb.append(", username=").append(username);
        sb.append(", orgIds=").append(orgIds);
        sb.append(", roleIds=").append(roleIds);
        sb.append(", gender=").append(gender);
        sb.append(", birthday=").append(birthday);
        sb.append(", address=").append(address);
        sb.append(", tel=").append(tel);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", state=").append(state);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}