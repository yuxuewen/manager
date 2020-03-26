package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.ScSubject;
import com.macro.mall.tiny.mbg.model.ScSubjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScSubjectMapper {
    int countByExample(ScSubjectExample example);

    int deleteByExample(ScSubjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScSubject record);

    int insertSelective(ScSubject record);

    List<ScSubject> selectByExampleWithBLOBs(ScSubjectExample example);

    List<ScSubject> selectByExample(ScSubjectExample example);

    ScSubject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScSubject record, @Param("example") ScSubjectExample example);

    int updateByExampleWithBLOBs(@Param("record") ScSubject record, @Param("example") ScSubjectExample example);

    int updateByExample(@Param("record") ScSubject record, @Param("example") ScSubjectExample example);

    int updateByPrimaryKeySelective(ScSubject record);

    int updateByPrimaryKeyWithBLOBs(ScSubject record);

    int updateByPrimaryKey(ScSubject record);
}