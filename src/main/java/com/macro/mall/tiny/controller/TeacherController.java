package com.macro.mall.tiny.controller;


import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.dto.InsertTeacherSubjectParams;
import com.macro.mall.tiny.dto.SearchTeacher;
import com.macro.mall.tiny.mbg.model.ScTeacher;
import com.macro.mall.tiny.mbg.model.UmsRole;
import com.macro.mall.tiny.service.TeaherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(tags = "TeacherController", description = "学校教职工管理")
@Controller
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeaherService teaherService;
    @ApiOperation("创建教职工")
    @RequestMapping(value = "createTeacher", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> createTeacher(@Valid  @RequestBody ScTeacher teacher, BindingResult result){
        if(result.hasErrors())
        {
            return CommonResult.failed(result.getFieldError().getDefaultMessage());
        }
        int res=teaherService.createTeacher(teacher);
        if(res==-1)
        {
            return  CommonResult.failed("工号已经存在");
        }
        return  CommonResult.success(teaherService.createTeacher(teacher));
    }

    @ApiOperation("更新教职工信息")
    @RequestMapping(value = "updateTeacher", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> updateTeacher(  @RequestBody ScTeacher teacher, BindingResult result){

        return  CommonResult.success(teaherService.updateTeacher(teacher));
    }

    @ApiOperation("分页查询教职工信息")
    @RequestMapping(value = "searchTeacherPage", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<PageInfo> searchTeacherPage(@RequestBody SearchTeacher params, BindingResult result){
       PageInfo list=teaherService.getTeacherPage(params);
        return  CommonResult.success(list);
    }

    @ApiOperation("根据id教职工信息")
    @RequestMapping(value = "getTeacherById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ScTeacher> getTeacherById(@RequestParam(value = "", required = true) int teacherId){
        ScTeacher res=teaherService.getScTeacherById(teacherId);
        return  CommonResult.success(res);

    }

    @ApiOperation("根据id删除教职工信息")
    @RequestMapping(value = "deleteTeacher", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Integer> deleteTeacher(@RequestParam(value = "", required = true) int teacherId){
        int res=teaherService.deleteTeacher(teacherId);
        if(res>0)
        {
            return  CommonResult.success(res);
        }
        else
        {
            return CommonResult.failed("删除失败:id不存在");
        }
    }


    @ApiOperation("教师绑定学科")
    @RequestMapping(value = "insertTeacherSubject", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult insertTeacherSubject(@Valid @RequestBody InsertTeacherSubjectParams params, BindingResult result){
        int id=teaherService.insertTeacherSubject(params.getTeacherId(),params.getSubIDs());
        if(id==-1)
        {
          return CommonResult.failed("绑定失败，请查看参数是否正确");
        }
        return  CommonResult.success(id);

    }



}
