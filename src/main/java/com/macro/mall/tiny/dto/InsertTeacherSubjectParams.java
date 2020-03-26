package com.macro.mall.tiny.dto;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class InsertTeacherSubjectParams {
    @ApiModelProperty(value = "教师Id", required = true)
    @NotNull(message = "teacherId不能为空")
    private int teacherId;
    @ApiModelProperty(value = "学科Id，逗号分隔", required = true)
    @NotEmpty(message = "subIDs不能为空")
    private String subIDs;

    public int getTeacherId() {
        return teacherId;
    }

    public String getSubIDs() {
        return subIDs;
    }
}
