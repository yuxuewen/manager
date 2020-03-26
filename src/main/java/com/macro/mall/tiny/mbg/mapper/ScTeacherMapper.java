package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.bean.TeacherSubject;
import com.macro.mall.tiny.dto.SearchTeacher;
import com.macro.mall.tiny.mbg.model.ScTeacher;
import com.macro.mall.tiny.mbg.model.ScTeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScTeacherMapper {
    int countByExample(ScTeacherExample example);

    int deleteByExample(ScTeacherExample example);

    int deleteByPrimaryKey(@Param("id") Integer id);

    int insert(ScTeacher record);

    int insertSelective(ScTeacher record);

    List<ScTeacher> selectByExample(ScTeacherExample example);

    List<ScTeacher> selectTeacher(SearchTeacher params);

    ScTeacher selectByPrimaryKey(@Param("id") Integer id);

    int updateByExampleSelective(@Param("record") ScTeacher record, @Param("example") ScTeacherExample example);

    int updateByExample(@Param("record") ScTeacher record, @Param("example") ScTeacherExample example);

    int updateByPrimaryKeySelective(ScTeacher record);

    int updateByPrimaryKey(ScTeacher record);

    int insertTeacherSubject(List<TeacherSubject> list);

    int deleteTeacherSubject(int teacherId);
}