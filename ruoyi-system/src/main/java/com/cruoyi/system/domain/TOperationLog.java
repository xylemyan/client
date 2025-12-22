package com.cruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 业务操作日志对象 t_operation_log
 */
public class TOperationLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 日志ID */
    private Long logId;

    /** 操作人ID */
    @Excel(name = "操作人ID")
    private String operatorId;

    /** 角色:Teacher/Admin */
    @Excel(name = "操作人角色")
    private String operatorRole;

    /** 操作类型 */
    @Excel(name = "操作类型")
    private String opType;

    /** 操作详情 */
    @Excel(name = "操作详情")
    private String opDetail;

    /** 操作时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "操作时间", dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date opTime;

    /** 区块链交易哈希 */
    @Excel(name = "交易哈希")
    private String txHash;

    /** 区块高度 */
    @Excel(name = "区块高度")
    private Long blockNumber;

    /** 数据哈希（用于验证） */
    private String dataHash;

    public Long getLogId() { return logId; }
    public void setLogId(Long logId) { this.logId = logId; }

    public String getOperatorId() { return operatorId; }
    public void setOperatorId(String operatorId) { this.operatorId = operatorId; }

    public String getOperatorRole() { return operatorRole; }
    public void setOperatorRole(String operatorRole) { this.operatorRole = operatorRole; }

    public String getOpType() { return opType; }
    public void setOpType(String opType) { this.opType = opType; }

    public String getOpDetail() { return opDetail; }
    public void setOpDetail(String opDetail) { this.opDetail = opDetail; }

    public Date getOpTime() { return opTime; }
    public void setOpTime(Date opTime) { this.opTime = opTime; }

    public String getTxHash() { return txHash; }
    public void setTxHash(String txHash) { this.txHash = txHash; }

    public Long getBlockNumber() { return blockNumber; }
    public void setBlockNumber(Long blockNumber) { this.blockNumber = blockNumber; }

    public String getDataHash() { return dataHash; }
    public void setDataHash(String dataHash) { this.dataHash = dataHash; }
}
