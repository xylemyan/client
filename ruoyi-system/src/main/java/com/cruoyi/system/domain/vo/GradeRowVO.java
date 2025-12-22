package com.cruoyi.system.domain.vo;

import com.ruoyi.common.annotation.Excel;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 成绩分析-学生成绩行数据 VO
 */
public class GradeRowVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Excel(name = "学号")
    private String studentId;

    @Excel(name = "姓名")
    private String studentName;

    @Excel(name = "班级")
    private String className;

    @Excel(name = "平时成绩")
    private BigDecimal scoreRegular;

    @Excel(name = "考勤成绩")
    private BigDecimal scoreAttendance;

    @Excel(name = "作业成绩")
    private BigDecimal scoreHomework;

    @Excel(name = "实验成绩")
    private BigDecimal scoreExperiment;

    @Excel(name = "期中成绩")
    private BigDecimal scoreMidterm;

    @Excel(name = "期末成绩")
    private BigDecimal scoreFinalExam;

    @Excel(name = "补考成绩")
    private BigDecimal scoreResit;

    @Excel(name = "总评成绩")
    private BigDecimal scoreTotal;

    @Excel(name = "状态", readConverterExp = "0=正常,1=不及格,2=补考通过,3=挂科")
    private String passStatus; // "通过" / "不通过"

    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getClassName() { return className; }
    public void setClassName(String className) { this.className = className; }

    public BigDecimal getScoreRegular() { return scoreRegular; }
    public void setScoreRegular(BigDecimal scoreRegular) { this.scoreRegular = scoreRegular; }

    public BigDecimal getScoreAttendance() { return scoreAttendance; }
    public void setScoreAttendance(BigDecimal scoreAttendance) { this.scoreAttendance = scoreAttendance; }

    public BigDecimal getScoreHomework() { return scoreHomework; }
    public void setScoreHomework(BigDecimal scoreHomework) { this.scoreHomework = scoreHomework; }

    public BigDecimal getScoreExperiment() { return scoreExperiment; }
    public void setScoreExperiment(BigDecimal scoreExperiment) { this.scoreExperiment = scoreExperiment; }

    public BigDecimal getScoreMidterm() { return scoreMidterm; }
    public void setScoreMidterm(BigDecimal scoreMidterm) { this.scoreMidterm = scoreMidterm; }

    public BigDecimal getScoreFinalExam() { return scoreFinalExam; }
    public void setScoreFinalExam(BigDecimal scoreFinalExam) { this.scoreFinalExam = scoreFinalExam; }

    public BigDecimal getScoreResit() { return scoreResit; }
    public void setScoreResit(BigDecimal scoreResit) { this.scoreResit = scoreResit; }

    public BigDecimal getScoreTotal() { return scoreTotal; }
    public void setScoreTotal(BigDecimal scoreTotal) { this.scoreTotal = scoreTotal; }

    public String getPassStatus() { return passStatus; }
    public void setPassStatus(String passStatus) { this.passStatus = passStatus; }
}
