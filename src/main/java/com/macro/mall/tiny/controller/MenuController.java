package com.macro.mall.tiny.controller;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SysMenu;
import com.macro.mall.tiny.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "MenuController", description = "系统菜单")
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private SysMenuService sysMenuService;

    @ApiOperation("获取所有菜单列表")
    @RequestMapping(value = "getMenuList", method = RequestMethod.GET)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:read')")
    public CommonResult<List<SysMenu>> getMenuList() {
        return CommonResult.success(sysMenuService.getMenuList());
    }
    @ApiOperation("创建菜单")
    @RequestMapping(value = "createMenu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> createMenu(@RequestBody SysMenu sysMenu){
        return  CommonResult.success(sysMenuService.createMenu(sysMenu));
    }
    @ApiOperation("更新菜单")
    @RequestMapping(value = "updateMenu", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateMenu(@RequestBody SysMenu sysMenu){
        if(StringUtils.isEmpty(sysMenu.getId()))
        {
            return CommonResult.failed("id不能为空");
        }
        return  CommonResult.success(sysMenuService.updateMenu(sysMenu));
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @PreAuthorize("hasAuthority('pms:brand:delete')")
    public CommonResult deleteMenu(@PathVariable("id") Long id) {
        int count = sysMenuService.deleteMenu(id);
        if (count == 1) {
            return CommonResult.success(null);
        } else {
            return CommonResult.failed("操作失败");
        }
    }


}
