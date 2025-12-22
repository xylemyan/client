package com.cruoyi.domain.dto;

import java.math.BigDecimal;

public class StudentGradeInputDTO {
    private String studentId;
    private String studentName;
    private BigDecimal scoreRegular;
    private BigDecimal scoreAttendance;
    private BigDecimal scoreHomework;
    private BigDecimal scoreExperiment;
    private BigDecimal scoreMidterm;
    private BigDecimal scoreFinalExam;
    private BigDecimal scoreTotal;
    private BigDecimal scoreResit;

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


    public BigDecimal getScoreTotal() {
        return scoreTotal;
    }

    public void setScoreTotal(BigDecimal scoreTotal) {
        this.scoreTotal = scoreTotal;
    }




    // Getter和Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public BigDecimal getScoreRegular() {
        return scoreRegular;
    }

    public void setScoreRegular(BigDecimal scoreRegular) {
        this.scoreRegular = scoreRegular;
    }

    public BigDecimal getScoreAttendance() {
        return scoreAttendance;
    }

    public void setScoreAttendance(BigDecimal scoreAttendance) {
        this.scoreAttendance = scoreAttendance;
    }

    public BigDecimal getScoreHomework() {
        return scoreHomework;
    }

    public void setScoreHomework(BigDecimal scoreHomework) {
        this.scoreHomework = scoreHomework;
    }

    public BigDecimal getScoreExperiment() {
        return scoreExperiment;
    }

    public void setScoreExperiment(BigDecimal scoreExperiment) {
        this.scoreExperiment = scoreExperiment;
    }

    public BigDecimal getScoreMidterm() {
        return scoreMidterm;
    }

    public void setScoreMidterm(BigDecimal scoreMidterm) {
        this.scoreMidterm = scoreMidterm;
    }

    public BigDecimal getScoreFinalExam() {
        return scoreFinalExam;
    }

    public void setScoreFinalExam(BigDecimal scoreFinalExam) {
        this.scoreFinalExam = scoreFinalExam;
    }
}