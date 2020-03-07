package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SysDictType;
import com.macro.mall.tiny.mbg.model.SysDictTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictTypeMapper {
    int countByExample(SysDictTypeExample example);

    int deleteByExample(SysDictTypeExample example);

    int deleteByPrimaryKey(Long dictId);

    int insert(SysDictType record);

    int insertSelective(SysDictType record);

    List<SysDictType> selectByExample(SysDictTypeExample example);

    SysDictType selectByPrimaryKey(Long dictId);

    int updateByExampleSelective(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByExample(@Param("record") SysDictType record, @Param("example") SysDictTypeExample example);

    int updateByPrimaryKeySelective(SysDictType record);

    int updateByPrimaryKey(SysDictType record);
}