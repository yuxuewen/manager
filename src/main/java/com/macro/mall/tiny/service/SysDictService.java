package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SysDictData;
import com.macro.mall.tiny.mbg.model.SysDictType;

import java.util.List;

public interface SysDictService {
    int createDictType(SysDictType dictType);
    int updateDictType(SysDictType dictType);
    int deleteDictType(long dictId);
    SysDictType getSysDictType(long dictId);
    List<SysDictType> getDictTypeAll();
    int createDictData(SysDictData sysDictData);
    int updateDictData(SysDictData sysDictData);
    int deteteDictData(long dictCode);
    List<SysDictData> getDictDataByType(String type);
}
