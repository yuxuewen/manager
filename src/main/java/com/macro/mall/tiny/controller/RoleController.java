package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.bean.RoleMenu;
import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.InsertRoleMenuParams;
import com.macro.mall.tiny.dto.SearchRoleRarams;
import com.macro.mall.tiny.mbg.model.SysMenu;
import com.macro.mall.tiny.mbg.model.UmsRole;
import com.macro.mall.tiny.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = "RoleController", description = "系统角色")
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @ApiOperation("获取所有角色列表")
    @RequestMapping(value = "getRoleListAll", method = RequestMethod.GET)
    @ResponseBody

    @PreAuthorize("hasAuthority('system:role:query')")
    public CommonResult<List<UmsRole>> getRoleListAll() {
        return CommonResult.success(roleService.getRoleList());
    }
    @ApiOperation("分页查询角色")
    @RequestMapping(value = "getRoleListPage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<CommonPage<UmsRole>> getRoleListPage(@RequestBody SearchRoleRarams params) {
        List<UmsRole> list=roleService.getRoleListPage(params);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("创建角色")
    @RequestMapping(value = "createRole", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> createRole(@RequestBody UmsRole UmsRole){
        return  CommonResult.success(roleService.createRole(UmsRole));
    }
    @ApiOperation("更新角色")
    @RequestMapping(value = "updateRole", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateRole(@RequestBody UmsRole UmsRole){
        if(StringUtils.isEmpty(UmsRole.getId()))
        {
            return CommonResult.failed("id不能为空");
        }
        return  CommonResult.success(roleService.updateRole(UmsRole));
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult deleteRole(@PathVariable("id") Long id) {
        int count = roleService.deleteRole(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("角色绑定菜单权限")
    @RequestMapping(value = "batchInsertRoleMenu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult batchInsertRoleMenu(@RequestBody InsertRoleMenuParams insertRoleMenuParams){
        String[] menusIds = insertRoleMenuParams.getMenusId().split(",");
        List<RoleMenu> roleMenus=new ArrayList<RoleMenu>();
        for(String s :menusIds)
        {
            RoleMenu roleMenu=new RoleMenu(insertRoleMenuParams.getRoleId(),Long.parseLong(s));
            roleMenus.add(roleMenu);
        }
        return  CommonResult.success(roleService.insertRoleMenu(roleMenus));
    }

    @ApiOperation("获得角色绑定的菜单，逗号分隔")
    @RequestMapping(value = "/getRoleMenus/{roleIds}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getRoleMenus(@PathVariable("roleIds") String roleIds) {


        List<SysMenu> menus = roleService.getRoleMenus(roleIds);
        return  CommonResult.success(menus);
    }


}

