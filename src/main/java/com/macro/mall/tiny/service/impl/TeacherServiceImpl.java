package com.macro.mall.tiny.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.macro.mall.tiny.bean.RoleMenu;
import com.macro.mall.tiny.bean.TeacherSubject;
import com.macro.mall.tiny.dto.SearchTeacher;
import com.macro.mall.tiny.mbg.mapper.ScTeacherMapper;
import com.macro.mall.tiny.mbg.model.ScTeacher;
import com.macro.mall.tiny.mbg.model.ScTeacherExample;
import com.macro.mall.tiny.service.TeaherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TeacherServiceImpl implements TeaherService {
    @Autowired
    private ScTeacherMapper scTeacherMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public int createTeacher(ScTeacher scTeacher) {

        ScTeacher teacher = new ScTeacher();
        BeanUtils.copyProperties(scTeacher, teacher);
        //查询是否有相同工号的用户
        ScTeacherExample scTeacherExample = new ScTeacherExample();
        scTeacherExample.createCriteria().andWorkerNumEqualTo(scTeacher.getWorkerNum());
        List<ScTeacher> list = scTeacherMapper.selectByExample(scTeacherExample);
        if (list.size() > 0) {
            return -1;
        }
        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode("123456");
        teacher.setPassword(encodePassword);
        return  scTeacherMapper.insert(teacher);
    }

    @Override
    public int updateTeacher(ScTeacher scTeacher) {
        //不允许这样修改密码
        scTeacher.setPassword(null);
        int res= scTeacherMapper.updateByPrimaryKeySelective(scTeacher);
        return res;
    }

    @Override
    public ScTeacher getScTeacherById(int id) {
        ScTeacher scTeacher=scTeacherMapper.selectByPrimaryKey(id);
        return scTeacher;
    }

    @Override
    public int deleteTeacher(int id) {
        return scTeacherMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageInfo getTeacherPage(SearchTeacher params) {
        Page page= PageHelper.startPage(params.pageNum,params.pageSize);
        List<ScTeacher> list=scTeacherMapper.selectTeacher(params);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    @Override
    public int insertTeacherSubject(int teacherId, String subIds) {
        try{
            String[] subjectIds = subIds.split(",");
            List<TeacherSubject> list=new ArrayList<TeacherSubject>();
            for(String s :subjectIds)
            {

                System.out.println("*****"+s);
                TeacherSubject teacherSubject=new TeacherSubject(teacherId,Integer.parseInt(s));
                list.add(teacherSubject);
            }
            int code=scTeacherMapper.deleteTeacherSubject(teacherId);
            int id=scTeacherMapper.insertTeacherSubject(list);
            return id;

        }catch (Exception e)
        {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return  -1;

        }

    }
}
