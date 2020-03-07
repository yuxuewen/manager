package com.macro.mall.tiny.service;

import com.macro.mall.tiny.mbg.model.SysDept;

import java.util.List;

public interface SysDeptService {
    int createDept(SysDept sysDept);
    int updateDept(SysDept sysDept);
    int deleteDept(long deptId);
    SysDept getDeptById(long deptId);
    List<SysDept> getDeptList(long parentId);
}
