package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SysDept;
import com.macro.mall.tiny.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "DeptController", description = "组织机构")
@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private SysDeptService sysDeptService;

    @ApiOperation("创建组织机构")
    @RequestMapping(value = "createDept", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> createDept (@Validated  @RequestBody SysDept sysDept, BindingResult result){
        if(result.hasErrors())
        {
          //  LOGGER.warn("异常:{}", result.getFieldError().getDefaultMessage());
            return CommonResult.failed(result.getFieldError().getDefaultMessage());
        }
        return  CommonResult.success(sysDeptService.createDept(sysDept));
    }

    @ApiOperation("更新组织机构")
    @RequestMapping(value = "updateDept", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> updateDept (@RequestBody SysDept sysDept){
        if(StringUtils.isEmpty(sysDept.getDeptId()))
        {
            return CommonResult.failed("deptId 不能为空！");
        }

        return  CommonResult.success(sysDeptService.updateDept(sysDept));
    }

    @ApiOperation("删除组织机构")
    @RequestMapping(value = "deleteDept", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Integer> deleteDept (@RequestParam(value = "", required = true) long deptId){
        return  CommonResult.success(sysDeptService.deleteDept(deptId));
    }

    @ApiOperation("根据id 查 组织机构")
    @RequestMapping(value = "getDeptById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<SysDept> getDeptById (@RequestParam(value = "", required = true) long deptId){
        return  CommonResult.success(sysDeptService.getDeptById(deptId));
    }

    @ApiOperation("根据parendId查下级组织机构")
    @RequestMapping(value = "getDeptList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List> getDeptList (@RequestParam(value = "", required = true) long parendId){

        return  CommonResult.success(sysDeptService.getDeptList(parendId));
    }



}
