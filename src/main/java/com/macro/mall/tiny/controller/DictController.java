package com.macro.mall.tiny.controller;

import com.macro.mall.tiny.common.api.CommonResult;
import com.macro.mall.tiny.mbg.model.SysDept;
import com.macro.mall.tiny.mbg.model.SysDictData;
import com.macro.mall.tiny.mbg.model.SysDictType;
import com.macro.mall.tiny.service.SysDictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "DictController", description = "字典管理")
@Controller
@RequestMapping("/dict")

public class DictController {
    @Autowired
    private SysDictService sysDictService;

    @ApiOperation("创建字典类型")
    @RequestMapping(value = "createDictType", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> createDictType (@Validated @RequestBody SysDictType sysDictType, BindingResult result){
        if(result.hasErrors())
        {
            return CommonResult.failed(result.getFieldError().getDefaultMessage());
        }
        return  CommonResult.success(sysDictService.createDictType(sysDictType));
    }
    @ApiOperation("更新字典类型")
    @RequestMapping(value = "updateDictType", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> updateDictType (@RequestBody SysDictType sysDictType, BindingResult result){
        if(StringUtils.isEmpty(sysDictType.getDictId()))
        {
            return CommonResult.failed("字典类型id不能为空");
        }
        return  CommonResult.success(sysDictService.updateDictType(sysDictType));
    }

    @ApiOperation("删除字典类型给")
    @RequestMapping(value = "deleteDictType", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Integer> deleteDictType (@RequestParam(value = "", required = true) long dictId){
        return  CommonResult.success(sysDictService.deleteDictType(dictId));
    }

    @ApiOperation("获取全部字典类型")
    @RequestMapping(value = "getDictTypeListAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List> getDictTypeListAll (){

        return  CommonResult.success(sysDictService.getDictTypeAll());
    }

    @ApiOperation("根据id字典类型")
    @RequestMapping(value = "getDictTypeById", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getDictTypeById (@RequestParam(value = "", required = true) long dictId){

        return  CommonResult.success(sysDictService.getSysDictType(dictId));
    }

    @ApiOperation("根据字典类型获得数据")
    @RequestMapping(value = "getDictDataByType", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List> getDictDataByType (@RequestParam(value = "", required = true) String dictType){

        return  CommonResult.success(sysDictService.getDictDataByType(dictType));
    }

    @ApiOperation("创建字典数据")
    @RequestMapping(value = "createDictData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> createDictData (@Validated @RequestBody SysDictData sysDictData, BindingResult result){
        if(result.hasErrors())
        {
            return CommonResult.failed(result.getFieldError().getDefaultMessage());
        }
        return  CommonResult.success(sysDictService.createDictData(sysDictData));
    }

    @ApiOperation("更新字典数据")
    @RequestMapping(value = "updateDictData", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> updateDictData ( @RequestBody SysDictData sysDictData, BindingResult result){
        if(StringUtils.isEmpty(sysDictData.getDictCode()))
        {
            return CommonResult.failed("dictCode不能为空");
        }
        return CommonResult.success(sysDictService.updateDictData(sysDictData));
    }

    @ApiOperation("删除字典类型给")
    @RequestMapping(value = "deleteDictData", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<Integer> deleteDictData (@RequestParam(value = "", required = true) long dictCode){
        return  CommonResult.success(sysDictService.deteteDictData(dictCode));
    }

}
