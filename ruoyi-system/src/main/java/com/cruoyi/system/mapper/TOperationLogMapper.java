package com.cruoyi.system.mapper;

import java.util.List;

import com.cruoyi.system.domain.TOperationLog;

/**
 * 业务操作日志Mapper接口
 */
public interface TOperationLogMapper {
    
    /**
     * 查询操作日志
     */
    public TOperationLog selectTOperationLogByLogId(Long logId);

    /**
     * 查询操作日志列表
     */
    public List<TOperationLog> selectTOperationLogList(TOperationLog tOperationLog);

    /**
     * 新增操作日志
     */
    public int insertTOperationLog(TOperationLog tOperationLog);

    /**
     * 清空操作日志
     */
    public int cleanOperationLog();
}
