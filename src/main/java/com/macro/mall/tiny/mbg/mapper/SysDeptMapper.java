package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SysDept;
import com.macro.mall.tiny.mbg.model.SysDeptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDeptMapper {
    int countByExample(SysDeptExample example);

    int deleteByExample(SysDeptExample example);

    int deleteByPrimaryKey(Long deptId);

    int insert(SysDept record);

    int insertSelective(SysDept record);

    List<SysDept> selectByExample(SysDeptExample example);

    SysDept selectByPrimaryKey(Long deptId);

    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    int updateByPrimaryKeySelective(SysDept record);

    int updateByPrimaryKey(SysDept record);

    List<SysDept> selectByParentId(long parendId);
}