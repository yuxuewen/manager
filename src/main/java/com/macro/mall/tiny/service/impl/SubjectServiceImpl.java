package com.macro.mall.tiny.service.impl;

import com.macro.mall.tiny.mbg.mapper.ScSubjectMapper;
import com.macro.mall.tiny.mbg.model.ScSubject;
import com.macro.mall.tiny.mbg.model.ScSubjectExample;
import com.macro.mall.tiny.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


import java.util.List;

@Service

public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private ScSubjectMapper subjectMapper;
    @Override
    public int createSubject(ScSubject subject) {
        //学科编号
        if( getSubjectByCode(subject.getSubjectCode()).size()>0)
        {
            return  -1;
        }
        return subjectMapper.insertSelective(subject);
    }

    @Override
    public int updateSubject(ScSubject subject) {
        //学科编号不能重复
        if(!StringUtils.isEmpty(subject.getSubjectCode()))
        {
            ScSubjectExample example=new ScSubjectExample();
            ScSubjectExample.Criteria criteria=example.createCriteria();
            criteria.andSubjectCodeEqualTo(subject.getSubjectCode());
            criteria.andIdNotEqualTo(subject.getId());
            List<ScSubject> scSubjects=subjectMapper.selectByExample(example);
            //更新时，工号不能重复
            if( scSubjects.size()>0)
            {
                return  -1;
            }
        }
        return subjectMapper.updateByPrimaryKey(subject);
    }

    @Override
    public int deleteSubject(int id) {
        int resCode=subjectMapper.deleteByPrimaryKey(id);
        return resCode;
    }

    @Override
    public ScSubject getSubjectById(int id) {
        ScSubject scSubject=subjectMapper.selectByPrimaryKey(id);
        return scSubject;
}

    @Override
    public List<ScSubject> getSubjectByCode(String code) {
        ScSubjectExample example=new ScSubjectExample();
        ScSubjectExample.Criteria criteria=example.createCriteria();
        criteria.andSubjectCodeEqualTo(code);
        List<ScSubject> scSubjects=subjectMapper.selectByExample(example);
        return scSubjects;
    }


}
