package com.macro.mall.tiny.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.macro.mall.tiny.bean.RoleMenu;
import com.macro.mall.tiny.config.RedisConfig;
import com.macro.mall.tiny.dto.SearchRoleRarams;
import com.macro.mall.tiny.mbg.mapper.SysMenuMapper;
import com.macro.mall.tiny.mbg.mapper.UmsRoleMapper;
import com.macro.mall.tiny.mbg.model.SysMenu;
import com.macro.mall.tiny.mbg.model.UmsRole;
import com.macro.mall.tiny.mbg.model.UmsRoleExample;
import com.macro.mall.tiny.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private UmsRoleMapper umsRoleMapper;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<UmsRole> getRoleList() {
        UmsRoleExample umsRoleExample=new UmsRoleExample();
        UmsRoleExample.Criteria criteria = umsRoleExample.createCriteria();
        return umsRoleMapper.selectByExample(
                umsRoleExample
        );
    }

    @Override
    public Integer createRole(UmsRole role) {
        return umsRoleMapper.insertSelective(role);
    }

    @Override
    public Integer updateRole(UmsRole role) {
        return umsRoleMapper.updateByPrimaryKeySelective(role);
    }

    @Override
    public Integer deleteRole(long id) {
        return umsRoleMapper.deleteByPrimaryKey(id);
    }


    @Override
    public Integer insertRoleMenu(List<RoleMenu> roleMenus) {
        long roleId=roleMenus.get(0).getRoleId();
        umsRoleMapper.deleteRoleMenu(roleId);
        return  umsRoleMapper.batchInsertRoleMenu(roleMenus);
    }


    @Override
    public  List<SysMenu> getRoleMenus(String roleIds) {
        String[] roleIdArray = roleIds.split(",");
        Long [] roleIdData= new Long[roleIdArray.length];
        for(int i=0;i<roleIdArray.length;i++)
        {
            roleIdData[i]=Long.parseLong(roleIdArray[i]);
        }
        return sysMenuMapper.selectRoleMenu(roleIdData);
    }

    @Override
    public List<UmsRole> getRoleListPage(SearchRoleRarams params) {
        PageHelper.startPage(params.pageNum,params.pageSize);
        UmsRoleExample umsRoleExample=new UmsRoleExample();
        UmsRoleExample.Criteria criteria = umsRoleExample.createCriteria();
        if (!StringUtils.isEmpty(params.name)) {
            criteria.andNameLike("%" + params.name + "%");
        }
        return umsRoleMapper.selectByExample(umsRoleExample);
    }
}
