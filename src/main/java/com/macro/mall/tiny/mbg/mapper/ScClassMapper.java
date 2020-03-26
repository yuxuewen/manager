package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.ScClass;
import com.macro.mall.tiny.mbg.model.ScClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ScClassMapper {
    int countByExample(ScClassExample example);

    int deleteByExample(ScClassExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ScClass record);

    int insertSelective(ScClass record);

    List<ScClass> selectByExample(ScClassExample example);

    ScClass selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ScClass record, @Param("example") ScClassExample example);

    int updateByExample(@Param("record") ScClass record, @Param("example") ScClassExample example);

    int updateByPrimaryKeySelective(ScClass record);

    int updateByPrimaryKey(ScClass record);
}