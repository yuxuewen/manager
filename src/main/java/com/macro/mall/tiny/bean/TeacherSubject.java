package com.macro.mall.tiny.bean;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class TeacherSubject implements Serializable {
    private int teacherId;
    private int subjectId;

    public TeacherSubject(int teacherId, int subjectId) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }
}
