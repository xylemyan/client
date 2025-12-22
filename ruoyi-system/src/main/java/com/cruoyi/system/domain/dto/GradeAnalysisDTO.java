package com.cruoyi.system.domain.dto;

import java.io.Serializable;

public class GradeAnalysisDTO implements Serializable {
    private String teacherId;
    private String courseId;
    private String courseName; // Fuzzy search for history
    private String academicYear;
    private String semester;
    private String classSeq;
    private String analysisContent; // New field for analysis text

    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }

    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public String getAcademicYear() { return academicYear; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public String getClassSeq() { return classSeq; }
    public void setClassSeq(String classSeq) { this.classSeq = classSeq; }

    public String getAnalysisContent() { return analysisContent; }
    public void setAnalysisContent(String analysisContent) { this.analysisContent = analysisContent; }
}
