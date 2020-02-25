package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SysMenu;

import java.util.List;

public interface SysMenuService {
    List<SysMenu> getMenuList( );
    Integer createMenu(SysMenu sysMenu);
    Integer updateMenu(SysMenu sysMenu);
    Integer deleteMenu(long id);
}
