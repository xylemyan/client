package com.cruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 学生信息对象 t_student
 * 
 * @author ruoyi
 * @date 2025-12-13
 */
public class TStudent extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 学号(10位) */
    private String studentId;

    /** 加密密码 */
    @Excel(name = "加密密码")
    private String password;

    /** 学院 */
    @Excel(name = "学院")
    private String college;

    /** 系 */
    @Excel(name = "系")
    private String department;

    /** 班级 */
    @Excel(name = "班级")
    private String className;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    public void setStudentId(String studentId) 
    {
        this.studentId = studentId;
    }

    public String getStudentId() 
    {
        return studentId;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }

    public void setCollege(String college) 
    {
        this.college = college;
    }

    public String getCollege() 
    {
        return college;
    }

    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }

    public void setClassName(String className) 
    {
        this.className = className;
    }

    public String getClassName() 
    {
        return className;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("studentId", getStudentId())
            .append("password", getPassword())
            .append("college", getCollege())
            .append("department", getDepartment())
            .append("className", getClassName())
            .append("name", getName())
            .append("gender", getGender())
            .toString();
    }
}
