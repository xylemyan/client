package com.cruoyi.system.service.impl;

import java.util.List;

import com.cruoyi.system.domain.TTeacher;
import com.cruoyi.system.service.ITTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.cruoyi.system.mapper.TTeacherMapper;

/**
 * 教师信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-13
 */
@Service
public class TTeacherServiceImpl implements ITTeacherService
{
    @Autowired
    private TTeacherMapper tTeacherMapper;

    /**
     * 查询教师信息
     * 
     * @param teacherId 教师信息主键
     * @return 教师信息
     */
    @Override
    public TTeacher selectTTeacherByTeacherId(String teacherId)
    {
        return tTeacherMapper.selectTTeacherByTeacherId(teacherId);
    }

    /**
     * 查询教师信息列表
     * 
     * @param tTeacher 教师信息
     * @return 教师信息
     */
    @Override
    public List<TTeacher> selectTTeacherList(TTeacher tTeacher)
    {
        return tTeacherMapper.selectTTeacherList(tTeacher);
    }

    /** 默认密码 */
    private static final String DEFAULT_PASSWORD = "123456";

    /**
     * 新增教师信息
     * 
     * @param tTeacher 教师信息
     * @return 结果
     */
    @Override
    public int insertTTeacher(TTeacher tTeacher)
    {
        // 设置默认密码并加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        tTeacher.setPassword(encoder.encode(DEFAULT_PASSWORD));
        return tTeacherMapper.insertTTeacher(tTeacher);
    }

    /**
     * 修改教师信息
     * 
     * @param tTeacher 教师信息
     * @return 结果
     */
    @Override
    public int updateTTeacher(TTeacher tTeacher)
    {
        return tTeacherMapper.updateTTeacher(tTeacher);
    }

    /**
     * 批量删除教师信息
     * 
     * @param teacherIds 需要删除的教师信息主键
     * @return 结果
     */
    @Override
    public int deleteTTeacherByTeacherIds(String[] teacherIds)
    {
        return tTeacherMapper.deleteTTeacherByTeacherIds(teacherIds);
    }

    /**
     * 删除教师信息信息
     * 
     * @param teacherId 教师信息主键
     * @return 结果
     */
    @Override
    public int deleteTTeacherByTeacherId(String teacherId)
    {
        return tTeacherMapper.deleteTTeacherByTeacherId(teacherId);
    }
}
