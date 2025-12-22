package com.cruoyi.system.service;

import java.util.List;

import com.cruoyi.system.domain.TStudent;

/**
 * 学生信息Service接口
 * 
 * @author ruoyi
 * @date 2025-12-13
 */
public interface ITStudentService 
{
    /**
     * 查询学生信息
     * 
     * @param studentId 学生信息主键
     * @return 学生信息
     */
    public TStudent selectTStudentByStudentId(String studentId);

    /**
     * 查询学生信息列表
     * 
     * @param tStudent 学生信息
     * @return 学生信息集合
     */
    public List<TStudent> selectTStudentList(TStudent tStudent);

    /**
     * 新增学生信息
     * 
     * @param tStudent 学生信息
     * @return 结果
     */
    public int insertTStudent(TStudent tStudent);

    /**
     * 修改学生信息
     * 
     * @param tStudent 学生信息
     * @return 结果
     */
    public int updateTStudent(TStudent tStudent);

    /**
     * 批量删除学生信息
     * 
     * @param studentIds 需要删除的学生信息主键集合
     * @return 结果
     */
    public int deleteTStudentByStudentIds(String[] studentIds);

    /**
     * 删除学生信息信息
     * 
     * @param studentId 学生信息主键
     * @return 结果
     */
    public int deleteTStudentByStudentId(String studentId);
}
