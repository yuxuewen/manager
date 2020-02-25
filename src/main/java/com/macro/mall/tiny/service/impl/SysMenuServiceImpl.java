package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.SysMenuMapper;
import com.macro.mall.tiny.mbg.model.PmsBrandExample;
import com.macro.mall.tiny.mbg.model.SysMenu;
import com.macro.mall.tiny.mbg.model.SysMenuExample;
import com.macro.mall.tiny.service.SysMenuService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Autowired
    private SysMenuMapper sysMenuMapper;
    @Override
    public List<SysMenu> getMenuList() {
        SysMenuExample sysMenuExample=new SysMenuExample();
        SysMenuExample.Criteria criteria=sysMenuExample.createCriteria();
        return sysMenuMapper.selectByExample(sysMenuExample);
    }

    @Override
    public Integer createMenu(SysMenu sysMenu) {
        return sysMenuMapper.insertSelective(sysMenu);
    }

    @Override
    public Integer updateMenu(SysMenu sysMenu) {
        return sysMenuMapper.updateByPrimaryKeySelective(sysMenu);
    }

    @Override
    public Integer deleteMenu(long id) {

        return sysMenuMapper.deleteByPrimaryKey(id);
    }

}
