package com.cruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 管理员信息对象 t_admin
 * 
 * @author ruoyi
 * @date 2025-12-13
 */
public class TAdmin extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 管理员号(6位) */
    private String adminId;

    /** 加密密码 */
    @Excel(name = "加密密码")
    private String password;

    /** 所属学院 */
    @Excel(name = "所属学院")
    private String college;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 性别 */
    @Excel(name = "性别")
    private String gender;

    public void setAdminId(String adminId) 
    {
        this.adminId = adminId;
    }

    public String getAdminId() 
    {
        return adminId;
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
            .append("adminId", getAdminId())
            .append("password", getPassword())
            .append("college", getCollege())
            .append("name", getName())
            .append("gender", getGender())
            .toString();
    }
}
