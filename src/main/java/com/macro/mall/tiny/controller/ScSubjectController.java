package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.ScSubject;
import com.macro.mall.tiny.service.SubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "ScSubjectController", description = "学科管理")
@Controller
@RequestMapping("/subject")
public class ScSubjectController {
    @Autowired
    private SubjectService subjectService;

    @ApiOperation("创建科目")
    @RequestMapping(value = "createSubject", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> createSubject(@Valid @RequestBody ScSubject subject, BindingResult result){

        int res=subjectService.createSubject(subject);
        if(res==-1)
        {
            return  CommonResult.failed("学科编号已经存在");
        }
        return  CommonResult.success(res);
    }

    @ApiOperation("更新科目")
    @RequestMapping(value = "updateSubject", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> updateSubject(@Valid @RequestBody ScSubject subject, BindingResult result){
        if(StringUtils.isEmpty(subject.getId()))
        {
            return  CommonResult.failed("id 不能为空");
        }
        int res=subjectService.updateSubject(subject);
        if(res==-1)
        {
            return  CommonResult.failed("学科编号已经存在,不能重复");
        }
        return  CommonResult.success(res);
    }

    @ApiOperation("根据id获取学科信息")
    @RequestMapping(value = "getSubjectById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ScSubject> getSubjectById(@RequestParam(value = "", required = true) int subjectId){
        ScSubject res=subjectService.getSubjectById(subjectId);
        return  CommonResult.success(res);

    }

    @ApiOperation("根据工号获取学科信息")
    @RequestMapping(value = "getSubjectByCode", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<ScSubject> getSubjectByCode(@RequestParam(value = "", required = true) String subCode){
        List<ScSubject> subjectList=subjectService.getSubjectByCode(subCode);
        if(subjectList.size()==0)
        {
            return  CommonResult.failed("学科编号不存在");

        }
        return  CommonResult.success(subjectList.get(0));

    }
    /**
     * 删除
     */

    @ApiOperation("根据id删除学科信息")
    @RequestMapping(value = "deleteSubject", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Integer> deleteSubject(@RequestParam(value = "", required = true) int id){
        int res=subjectService.deleteSubject(id);
        if(res>0)
        {
            return  CommonResult.success(res);
        }
        else
        {
            return CommonResult.failed("删除失败:id不存在");
        }


    }



}
