package com.macro.mall.tiny.mbg.mapper;

import com.macro.mall.tiny.mbg.model.SysMenu;
import com.macro.mall.tiny.mbg.model.SysMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import sun.util.resources.ga.LocaleNames_ga;

public interface SysMenuMapper {
    int countByExample(SysMenuExample example);

    int deleteByExample(SysMenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysMenu record);

    int insertSelective(SysMenu record);

    List<SysMenu> selectByExample(SysMenuExample example);

    SysMenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    int updateByPrimaryKeySelective(SysMenu record);

    int updateByPrimaryKey(SysMenu record);

    List<SysMenu> selectRoleMenu(Long[] roleId);

    List<SysMenu> selectAdminUserPermissionMenuById(long id);

}