package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SysDictData;
import com.macro.mall.tiny.mbg.model.SysDictDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictDataMapper {
    int countByExample(SysDictDataExample example);

    int deleteByExample(SysDictDataExample example);

    int deleteByPrimaryKey(Long dictCode);

    int insert(SysDictData record);

    int insertSelective(SysDictData record);

    List<SysDictData> selectByExample(SysDictDataExample example);

    SysDictData selectByPrimaryKey(Long dictCode);

    int updateByExampleSelective(@Param("record") SysDictData record, @Param("example") SysDictDataExample example);

    int updateByExample(@Param("record") SysDictData record, @Param("example") SysDictDataExample example);

    int updateByPrimaryKeySelective(SysDictData record);

    int updateByPrimaryKey(SysDictData record);
}