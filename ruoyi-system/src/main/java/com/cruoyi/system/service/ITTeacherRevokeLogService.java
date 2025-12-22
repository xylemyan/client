package com.cruoyi.system.service;

import java.util.List;

import com.cruoyi.system.domain.TTeacherRevokeLog;

/**
 * 成绩撤销申请Service接口
 */
public interface ITTeacherRevokeLogService
{
    /**
     * 查询成绩撤销申请
     */
    public TTeacherRevokeLog selectTTeacherRevokeLogByRevokeId(Long revokeId);

    /**
     * 查询成绩撤销申请列表
     */
    public List<TTeacherRevokeLog> selectTTeacherRevokeLogList(TTeacherRevokeLog tTeacherRevokeLog);

    /**
     * 新增成绩撤销申请
     */
    public int insertTTeacherRevokeLog(TTeacherRevokeLog tTeacherRevokeLog);

    /**
     * 修改成绩撤销申请
     */
    public int updateTTeacherRevokeLog(TTeacherRevokeLog tTeacherRevokeLog);

    /**
     * 批量删除成绩撤销申请
     */
    public int deleteTTeacherRevokeLogByRevokeIds(Long[] revokeIds);

    /**
     * 删除成绩撤销申请
     */
    public int deleteTTeacherRevokeLogByRevokeId(Long revokeId);

    /**
     * 审批通过撤销申请
     */
    public int approveRevoke(Long revokeId, String adminId, String remark);

    /**
     * 审批拒绝撤销申请
     */
    public int rejectRevoke(Long revokeId, String adminId, String remark);
}
