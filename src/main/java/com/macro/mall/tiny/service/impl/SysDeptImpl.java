package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.SysDeptMapper;
import com.macro.mall.tiny.mbg.model.SysDept;
import com.macro.mall.tiny.mbg.model.SysDeptExample;
import com.macro.mall.tiny.service.SysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysDeptImpl implements SysDeptService {
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Override
    public int createDept(SysDept sysDept) {
        return sysDeptMapper.insertSelective(sysDept);
    }

    @Override
    public int updateDept(SysDept sysDept) {
        return sysDeptMapper.updateByExampleSelective(sysDept,new SysDeptExample());
    }

    @Override
    public int deleteDept(long deptId) {
        return sysDeptMapper.deleteByPrimaryKey(deptId);
    }

    @Override
    public SysDept getDeptById(long deptId) {
        return sysDeptMapper.selectByPrimaryKey(deptId);
    }

    @Override
    public List<SysDept> getDeptList(long parentId) {

        List<SysDept> list=sysDeptMapper.selectByParentId(parentId);
        return list;
    }


}
