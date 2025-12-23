package com.cruoyi.domain.dto;

import java.util.Date;

/**
 * 成绩撤销申请DTO
 */
public class TeacherRevokeLogDTO {
    private Long revokeId;
    private String teacherId;
    private String courseId;
    private String classSeq;
    private String academicYear;
    private Integer semester;
    private String revokeType;
    private String revokeReason;
    private Date applyTime;
    private String approveStatus;
    private String approveAdminId;
    private Date approveTime;
    private String approveRemark;

    public Long getRevokeId() { return revokeId; }
    public void setRevokeId(Long revokeId) { this.revokeId = revokeId; }
    public String getTeacherId() { return teacherId; }
    public void setTeacherId(String teacherId) { this.teacherId = teacherId; }
    public String getCourseId() { return courseId; }
    public void setCourseId(String courseId) { this.courseId = courseId; }
    public String getClassSeq() { return classSeq; }
    public void setClassSeq(String classSeq) { this.classSeq = classSeq; }
    public String getAcademicYear() { return academicYear; }
    public void setAcademicYear(String academicYear) { this.academicYear = academicYear; }
    public Integer getSemester() { return semester; }
    public void setSemester(Integer semester) { this.semester = semester; }
    public String getRevokeType() { return revokeType; }
    public void setRevokeType(String revokeType) { this.revokeType = revokeType; }
    public String getRevokeReason() { return revokeReason; }
    public void setRevokeReason(String revokeReason) { this.revokeReason = revokeReason; }
    public Date getApplyTime() { return applyTime; }
    public void setApplyTime(Date applyTime) { this.applyTime = applyTime; }
    public String getApproveStatus() { return approveStatus; }
    public void setApproveStatus(String approveStatus) { this.approveStatus = approveStatus; }
    public String getApproveAdminId() { return approveAdminId; }
    public void setApproveAdminId(String approveAdminId) { this.approveAdminId = approveAdminId; }
    public Date getApproveTime() { return approveTime; }
    public void setApproveTime(Date approveTime) { this.approveTime = approveTime; }
    public String getApproveRemark() { return approveRemark; }
    public void setApproveRemark(String approveRemark) { this.approveRemark = approveRemark; }
}
