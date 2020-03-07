package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.SysDictDataMapper;
import com.macro.mall.tiny.mbg.mapper.SysDictTypeMapper;
import com.macro.mall.tiny.mbg.model.SysDictData;
import com.macro.mall.tiny.mbg.model.SysDictDataExample;
import com.macro.mall.tiny.mbg.model.SysDictType;
import com.macro.mall.tiny.mbg.model.SysDictTypeExample;
import com.macro.mall.tiny.service.SysDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysDictImpl implements SysDictService {
    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;
    @Autowired
    private SysDictDataMapper sysDictDataMapper;
    @Override
    public int createDictType(SysDictType dictType) {
        return  sysDictTypeMapper.insertSelective(dictType);
    }

    @Override
    public int updateDictType(SysDictType dictType) {
        return sysDictTypeMapper.updateByPrimaryKeySelective(dictType);
    }

    @Override
    public int deleteDictType(long dictId) {
        return sysDictTypeMapper.deleteByPrimaryKey(dictId);
    }

    @Override
    public SysDictType getSysDictType(long dictId) {
        return sysDictTypeMapper.selectByPrimaryKey(dictId);
    }

    @Override
    public List<SysDictType> getDictTypeAll() {
        return sysDictTypeMapper.selectByExample(new SysDictTypeExample());
    }

    @Override
    public int createDictData(SysDictData sysDictData) {
        return sysDictDataMapper.insertSelective(sysDictData);
    }

    @Override
    public int updateDictData(SysDictData sysDictData) {
        return sysDictDataMapper.updateByPrimaryKeySelective(sysDictData);
    }

    @Override
    public int deteteDictData(long dictCode) {
        return sysDictDataMapper.deleteByPrimaryKey(dictCode);
    }

    @Override
    public List<SysDictData> getDictDataByType(String type) {
        SysDictDataExample sysDictDataExample=new SysDictDataExample();
        SysDictDataExample.Criteria criteria=sysDictDataExample.createCriteria();
        criteria.andDictTypeEqualTo(type);
        return sysDictDataMapper.selectByExample(sysDictDataExample);
    }

}
