package com.cruoyi.system.mapper;

import java.util.List;

import com.cruoyi.system.domain.TTeacherRevokeLog;

/**
 * 成绩撤销申请Mapper接口
 */
public interface TTeacherRevokeLogMapper
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
     * 删除成绩撤销申请
     */
    public int deleteTTeacherRevokeLogByRevokeId(Long revokeId);

    /**
     * 批量删除成绩撤销申请
     */
    public int deleteTTeacherRevokeLogByRevokeIds(Long[] revokeIds);
}
