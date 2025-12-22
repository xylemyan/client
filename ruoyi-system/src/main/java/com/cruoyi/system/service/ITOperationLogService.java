package com.cruoyi.system.service;

import java.util.List;

import com.cruoyi.system.domain.TOperationLog;

/**
 * 业务操作日志Service接口
 */
public interface ITOperationLogService {
    
    /**
     * 查询操作日志
     */
    public TOperationLog selectTOperationLogByLogId(Long logId);

    /**
     * 查询操作日志列表
     */
    public List<TOperationLog> selectTOperationLogList(TOperationLog tOperationLog);

    /**
     * 记录敏感操作日志（同时上链）
     * @param operatorId 操作人ID
     * @param operatorRole 操作人角色
     * @param opType 操作类型
     * @param opDetail 操作详情
     * @return 日志ID
     */
    public Long recordOperation(String operatorId, String operatorRole, String opType, String opDetail);

    /**
     * 清空操作日志
     */
    public void cleanOperationLog();
}
