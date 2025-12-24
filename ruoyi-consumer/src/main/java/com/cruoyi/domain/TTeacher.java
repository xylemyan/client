package com.cruoyi.domain;

/**
 * 教师信息
 */
public class TTeacher {
    private String teacherId;
    private String password;
    private String college;
    private String department;
    private String name;
    private String gender;

    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
