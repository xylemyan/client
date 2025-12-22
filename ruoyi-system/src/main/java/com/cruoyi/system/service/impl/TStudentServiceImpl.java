package com.cruoyi.system.service.impl;

import java.util.List;

import com.cruoyi.system.domain.TStudent;
import com.cruoyi.system.mapper.TStudentMapper;
import com.cruoyi.system.service.ITStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 学生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-13
 */
@Service
public class TStudentServiceImpl implements ITStudentService
{
    @Autowired
    private TStudentMapper tStudentMapper;

    /**
     * 查询学生信息
     * 
     * @param studentId 学生信息主键
     * @return 学生信息
     */
    @Override
    public TStudent selectTStudentByStudentId(String studentId)
    {
        return tStudentMapper.selectTStudentByStudentId(studentId);
    }

    /**
     * 查询学生信息列表
     * 
     * @param tStudent 学生信息
     * @return 学生信息
     */
    @Override
    public List<TStudent> selectTStudentList(TStudent tStudent)
    {
        return tStudentMapper.selectTStudentList(tStudent);
    }

    /** 默认密码 */
    private static final String DEFAULT_PASSWORD = "123456";

    /**
     * 新增学生信息
     * 
     * @param tStudent 学生信息
     * @return 结果
     */
    @Override
    public int insertTStudent(TStudent tStudent)
    {
        // 设置默认密码并加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        tStudent.setPassword(encoder.encode(DEFAULT_PASSWORD));
        return tStudentMapper.insertTStudent(tStudent);
    }

    /**
     * 修改学生信息
     * 
     * @param tStudent 学生信息
     * @return 结果
     */
    @Override
    public int updateTStudent(TStudent tStudent)
    {
        return tStudentMapper.updateTStudent(tStudent);
    }

    /**
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteTStudentByStudentIds(String[] studentIds)
    {
        return tStudentMapper.deleteTStudentByStudentIds(studentIds);
    }

    /**
     * 删除学生信息信息
     * 
     * @param studentId 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteTStudentByStudentId(String studentId)
    {
        return tStudentMapper.deleteTStudentByStudentId(studentId);
    }
}
