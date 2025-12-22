package com.cruoyi.domain.vo;

public class CourseVO {
    private String courseId;
    private String courseName;
    private String classSeq;
    private String academicYear;
    private Integer semester;

    // Getter和Setter
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getClassSeq() {
        return classSeq;
    }

    public void setClassSeq(String classSeq) {
        this.classSeq = classSeq;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}