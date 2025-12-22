package com.cruoyi.system.service.impl;

import java.util.Date;
import java.util.List;

import com.cruoyi.system.domain.TTeacherRevokeLog;
import com.cruoyi.system.service.ITTeacherRevokeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cruoyi.system.mapper.TTeacherRevokeLogMapper;

/**
 * 成绩撤销申请Service业务层处理
 */
@Service
public class TTeacherRevokeLogServiceImpl implements ITTeacherRevokeLogService
{
    @Autowired
    private TTeacherRevokeLogMapper tTeacherRevokeLogMapper;

    @Override
    public TTeacherRevokeLog selectTTeacherRevokeLogByRevokeId(Long revokeId)
    {
        return tTeacherRevokeLogMapper.selectTTeacherRevokeLogByRevokeId(revokeId);
    }

    @Override
    public List<TTeacherRevokeLog> selectTTeacherRevokeLogList(TTeacherRevokeLog tTeacherRevokeLog)
    {
        return tTeacherRevokeLogMapper.selectTTeacherRevokeLogList(tTeacherRevokeLog);
    }

    @Override
    public int insertTTeacherRevokeLog(TTeacherRevokeLog tTeacherRevokeLog)
    {
        tTeacherRevokeLog.setApplyTime(new Date());
        tTeacherRevokeLog.setApproveStatus("待审批");
        return tTeacherRevokeLogMapper.insertTTeacherRevokeLog(tTeacherRevokeLog);
    }

    @Override
    public int updateTTeacherRevokeLog(TTeacherRevokeLog tTeacherRevokeLog)
    {
        return tTeacherRevokeLogMapper.updateTTeacherRevokeLog(tTeacherRevokeLog);
    }

    @Override
    public int deleteTTeacherRevokeLogByRevokeIds(Long[] revokeIds)
    {
        return tTeacherRevokeLogMapper.deleteTTeacherRevokeLogByRevokeIds(revokeIds);
    }

    @Override
    public int deleteTTeacherRevokeLogByRevokeId(Long revokeId)
    {
        return tTeacherRevokeLogMapper.deleteTTeacherRevokeLogByRevokeId(revokeId);
    }

    /**
     * 审批通过撤销申请
     * 根据撤销类型执行不同操作：
     * - 小撤销：将成绩状态改为"暂存"
     * - 大撤销：删除成绩记录
     */
    @Override
    @Transactional
    public int approveRevoke(Long revokeId, String adminId, String remark)
    {
        TTeacherRevokeLog revokeLog = tTeacherRevokeLogMapper.selectTTeacherRevokeLogByRevokeId(revokeId);
        if (revokeLog == null) {
            return 0;
        }
        
        // 更新审批状态
        revokeLog.setApproveStatus("已通过");
        revokeLog.setApproveAdminId(adminId);
        revokeLog.setApproveTime(new Date());
        revokeLog.setApproveRemark(remark);
        
        // 撤销类型执行具体操作（需要成绩表Mapper支持后完善）
        // 小撤销：更新 t_student_grade 的 submit_status 为 '暂存'
        // 大撤销：删除 t_student_grade 中对应记录
        // 当前仅更新审批状态，具体成绩操作待成绩模块完善后实现
        
        return tTeacherRevokeLogMapper.updateTTeacherRevokeLog(revokeLog);
    }

    /**
     * 审批拒绝撤销申请
     */
    @Override
    public int rejectRevoke(Long revokeId, String adminId, String remark)
    {
        TTeacherRevokeLog revokeLog = tTeacherRevokeLogMapper.selectTTeacherRevokeLogByRevokeId(revokeId);
        if (revokeLog == null) {
            return 0;
        }
        
        revokeLog.setApproveStatus("已拒绝");
        revokeLog.setApproveAdminId(adminId);
        revokeLog.setApproveTime(new Date());
        revokeLog.setApproveRemark(remark);
        
        return tTeacherRevokeLogMapper.updateTTeacherRevokeLog(revokeLog);
    }
}
