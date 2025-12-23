package com.cruoyi.domain.dto;

/**
 * 成绩上链请求DTO（包含所有成绩字段）
 */
public class GradeStoreDTO {
    private String studentId;
    private String courseId;
    private String academicYear;
    private Integer semester;
    private String scoreRegular;
    private String scoreAttendance;
    private String scoreHomework;
    private String scoreExperiment;
    private String scoreMidterm;
    private String scoreFinalExam;
    private String scoreTotal;
    private String scoreResit;

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public String getAcademicYear() { return academicYear; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public Integer getSemester() { return semester; }
    public void setSemester(Integer semester) { this.semester = semester; }
    public String getScoreRegular() { return scoreRegular; }
    public void setScoreRegular(String scoreRegular) { this.scoreRegular = scoreRegular; }
    public String getScoreAttendance() { return scoreAttendance; }
    public void setScoreAttendance(String scoreAttendance) { this.scoreAttendance = scoreAttendance; }
    public String getScoreHomework() { return scoreHomework; }
    public void setScoreHomework(String scoreHomework) { this.scoreHomework = scoreHomework; }
    public String getScoreExperiment() { return scoreExperiment; }
    public void setScoreExperiment(String scoreExperiment) { this.scoreExperiment = scoreExperiment; }
    public String getScoreMidterm() { return scoreMidterm; }
    public void setScoreMidterm(String scoreMidterm) { this.scoreMidterm = scoreMidterm; }
    public String getScoreFinalExam() { return scoreFinalExam; }
    public void setScoreFinalExam(String scoreFinalExam) { this.scoreFinalExam = scoreFinalExam; }
    public String getScoreTotal() { return scoreTotal; }
    public void setScoreTotal(String scoreTotal) { this.scoreTotal = scoreTotal; }
    public String getScoreResit() { return scoreResit; }
    public void setScoreResit(String scoreResit) { this.scoreResit = scoreResit; }
}
