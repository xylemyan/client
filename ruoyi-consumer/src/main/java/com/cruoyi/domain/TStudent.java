package com.cruoyi.domain;

/**
 * 学生信息
 */
public class TStudent {
    private String studentId;
    private String password;
    private String college;
    private String department;
    private String className;
    private String name;
    private String gender;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }
    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
