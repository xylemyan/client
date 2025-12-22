package com.cruoyi.system.service;

import java.util.List;

import com.cruoyi.system.domain.TTeacher;

/**
 * 教师信息Service接口
 * 
 * @author ruoyi
 * @date 2025-12-13
 */
public interface ITTeacherService 
{
    /**
     * 查询教师信息
     * 
     * @param teacherId 教师信息主键
     * @return 教师信息
     */
    public TTeacher selectTTeacherByTeacherId(String teacherId);

    /**
     * 查询教师信息列表
     * 
     * @param tTeacher 教师信息
     * @return 教师信息集合
     */
    public List<TTeacher> selectTTeacherList(TTeacher tTeacher);

    /**
     * 新增教师信息
     * 
     * @param tTeacher 教师信息
     * @return 结果
     */
    public int insertTTeacher(TTeacher tTeacher);

    /**
     * 修改教师信息
     * 
     * @param tTeacher 教师信息
     * @return 结果
     */
    public int updateTTeacher(TTeacher tTeacher);

    /**
     * 批量删除教师信息
     * 
     * @param teacherIds 需要删除的教师信息主键集合
     * @return 结果
     */
    public int deleteTTeacherByTeacherIds(String[] teacherIds);

    /**
     * 删除教师信息信息
     * 
     * @param teacherId 教师信息主键
     * @return 结果
     */
    public int deleteTTeacherByTeacherId(String teacherId);
}
