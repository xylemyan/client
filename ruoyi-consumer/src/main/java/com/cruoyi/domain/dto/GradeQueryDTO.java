package com.cruoyi.domain.dto;

/**
 * 成绩查询请求DTO
 */
public class GradeQueryDTO {
    private String studentId;
    private String courseId;
    private String academicYear;
    private Integer semester;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public String getAcademicYear() { return academicYear; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public Integer getSemester() { return semester; }
    public void setSemester(Integer semester) { this.semester = semester; }
}
