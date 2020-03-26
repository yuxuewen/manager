package com.macro.mall.tiny.service;

import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.dto.SearchTeacher;
import com.macro.mall.tiny.mbg.model.ScTeacher;

import java.util.List;

public interface TeaherService {
    int createTeacher(ScTeacher scTeacher);
    int updateTeacher (ScTeacher scTeacher);
    ScTeacher getScTeacherById(int id);
    int deleteTeacher(int  id);
    PageInfo getTeacherPage(SearchTeacher searchTeacher);
    int insertTeacherSubject(int teacherId,String subIds);

}
