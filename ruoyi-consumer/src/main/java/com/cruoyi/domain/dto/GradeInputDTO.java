package com.cruoyi.domain.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class GradeInputDTO {
    // 课程信息
    private String courseId;
    private String classSeq;
    private String academicYear;
    private Integer semester;

    // 成绩系数设置
    private BigDecimal ratioRegular;
    private BigDecimal ratioAttendance;
    private BigDecimal ratioHomework;
    private BigDecimal ratioExperiment;
    private BigDecimal ratioMidterm;
    private BigDecimal ratioFinal;
    private List<StudentGradeInputDTO> studentGrades;
    private Map<String, Double> coefficient;
    private BigDecimal scoreResit;
    private String submitStatus;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;
    public BigDecimal getScoreResit() {
        return scoreResit;
    }

    public void setScoreResit(BigDecimal scoreResit) {
        this.scoreResit = scoreResit;
    }


    public String getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(String submitStatus) {
        this.submitStatus = submitStatus;
    }


    public Map<String, Double> getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Map<String, Double> coefficient) {
        this.coefficient = coefficient;
    }

    // 学生成绩列表

    // Getter和Setter
    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
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

    public BigDecimal getRatioRegular() {
        return ratioRegular;
    }

    public void setRatioRegular(BigDecimal ratioRegular) {
        this.ratioRegular = ratioRegular;
    }

    public BigDecimal getRatioAttendance() {
        return ratioAttendance;
    }

    public void setRatioAttendance(BigDecimal ratioAttendance) {
        this.ratioAttendance = ratioAttendance;
    }

    public BigDecimal getRatioHomework() {
        return ratioHomework;
    }

    public void setRatioHomework(BigDecimal ratioHomework) {
        this.ratioHomework = ratioHomework;
    }

    public BigDecimal getRatioExperiment() {
        return ratioExperiment;
    }

    public void setRatioExperiment(BigDecimal ratioExperiment) {
        this.ratioExperiment = ratioExperiment;
    }

    public BigDecimal getRatioMidterm() {
        return ratioMidterm;
    }

    public void setRatioMidterm(BigDecimal ratioMidterm) {
        this.ratioMidterm = ratioMidterm;
    }

    public BigDecimal getRatioFinal() {
        return ratioFinal;
    }

    public void setRatioFinal(BigDecimal ratioFinal) {
        this.ratioFinal = ratioFinal;
    }

    public List<StudentGradeInputDTO> getStudentGrades() {
        return studentGrades;
    }

    public void setStudentGrades(List<StudentGradeInputDTO> studentGrades) {
        this.studentGrades = studentGrades;
    }
}
