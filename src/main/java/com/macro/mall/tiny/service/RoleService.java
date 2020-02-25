package com.macro.mall.tiny.service;

import com.macro.mall.tiny.bean.RoleMenu;
import com.macro.mall.tiny.dto.SearchRoleRarams;
import com.macro.mall.tiny.mbg.model.PmsBrand;
import com.macro.mall.tiny.mbg.model.SysMenu;
import com.macro.mall.tiny.mbg.model.UmsRole;
import io.swagger.models.auth.In;

import javax.management.relation.Role;
import java.util.List;

public interface RoleService {
    List<UmsRole> getRoleList();
    List<UmsRole> getRoleListPage(SearchRoleRarams params);
    Integer createRole(UmsRole role);
    Integer updateRole(UmsRole role);
    Integer deleteRole (long id);
    Integer insertRoleMenu(List<RoleMenu> roleMenus);
    List<SysMenu> getRoleMenus(String ids);
}
