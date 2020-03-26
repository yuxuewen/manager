package com.macro.mall.tiny.service;

import com.macro.mall.tiny.common.api.CommonPage;
import com.macro.mall.tiny.mbg.model.ScSubject;

import java.util.List;


public interface SubjectService {
    int createSubject(ScSubject subject);
    int updateSubject(ScSubject subject);
    int deleteSubject(int id);
    ScSubject getSubjectById(int id);
    List<ScSubject> getSubjectByCode(String code);
   // CommonPage getSubjectPage();

}
