package com.cruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 成绩撤销申请对象 t_teacher_revoke_log
 */
public class TTeacherRevokeLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 撤销ID */
    private Long revokeId;

    /** 教师号 */
    @Excel(name = "教师号")
    private String teacherId;

    /** 课程号 */
    @Excel(name = "课程号")
    private String courseId;

    /** 课程序号/教学班号 */
    @Excel(name = "课程序号")
    private String classSeq;

    /** 学年 */
    @Excel(name = "学年")
    private String academicYear;

    /** 学期 */
    @Excel(name = "学期")
    private Integer semester;

    /** 类型:大撤销/小撤销 */
    @Excel(name = "撤销类型")
    private String revokeType;

    /** 撤销原因 */
    @Excel(name = "撤销原因")
    private String revokeReason;

    /** 申请时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "申请时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date applyTime;

    /** 审批状态:待审批/已通过/已拒绝 */
    @Excel(name = "审批状态")
    private String approveStatus;

    /** 审批管理员ID */
    @Excel(name = "审批管理员")
    private String approveAdminId;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date approveTime;

    /** 审批备注 */
    @Excel(name = "审批备注")
    private String approveRemark;

    /** 教师姓名（非数据库字段，用于显示） */
    private String teacherName;

    /** 课程名称（非数据库字段，用于显示） */
    private String courseName;

    public Long getRevokeId() {
        return revokeId;
    }

    public void setRevokeId(Long revokeId) {
        this.revokeId = revokeId;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

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

    public String getRevokeType() {
        return revokeType;
    }

    public void setRevokeType(String revokeType) {
        this.revokeType = revokeType;
    }

    public String getRevokeReason() {
        return revokeReason;
    }

    public void setRevokeReason(String revokeReason) {
        this.revokeReason = revokeReason;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getApproveAdminId() {
        return approveAdminId;
    }

    public void setApproveAdminId(String approveAdminId) {
        this.approveAdminId = approveAdminId;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public String getApproveRemark() {
        return approveRemark;
    }

    public void setApproveRemark(String approveRemark) {
        this.approveRemark = approveRemark;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("revokeId", getRevokeId())
            .append("teacherId", getTeacherId())
            .append("courseId", getCourseId())
            .append("academicYear", getAcademicYear())
            .append("semester", getSemester())
            .append("revokeType", getRevokeType())
            .append("revokeReason", getRevokeReason())
            .append("applyTime", getApplyTime())
            .append("approveStatus", getApproveStatus())
            .append("approveAdminId", getApproveAdminId())
            .append("approveTime", getApproveTime())
            .append("approveRemark", getApproveRemark())
            .toString();
    }
}
