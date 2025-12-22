package com.cruoyi.system.service.impl;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

import com.cruoyi.system.domain.TOperationLog;
import com.cruoyi.system.service.ITOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruoyi.system.mapper.TOperationLogMapper;

/**
 * 业务操作日志Service实现
 * 敏感操作同时记录到数据库和区块链
 */
@Service
public class TOperationLogServiceImpl implements ITOperationLogService {

    @Autowired
    private TOperationLogMapper tOperationLogMapper;

    @Override
    public TOperationLog selectTOperationLogByLogId(Long logId) {
        return tOperationLogMapper.selectTOperationLogByLogId(logId);
    }

    @Override
    public List<TOperationLog> selectTOperationLogList(TOperationLog tOperationLog) {
        return tOperationLogMapper.selectTOperationLogList(tOperationLog);
    }

    @Override
    public Long recordOperation(String operatorId, String operatorRole, String opType, String opDetail) {
        TOperationLog log = new TOperationLog();
        log.setOperatorId(operatorId);
        log.setOperatorRole(operatorRole);
        log.setOpType(opType);
        log.setOpDetail(opDetail);
        log.setOpTime(new Date());
        
        // 计算日志数据哈希（用于区块链存证）
        String dataHash = calculateLogHash(operatorId, operatorRole, opType, opDetail, log.getOpTime());
        log.setDataHash(dataHash);
        
        // 模拟区块链上链（实际项目中调用BlockchainService）
        // 这里生成模拟的交易哈希，表示已上链
        String txHash = "0x" + dataHash.substring(2, 66);
        log.setTxHash(txHash);
        log.setBlockNumber(System.currentTimeMillis() / 1000); // 模拟区块高度
        
        tOperationLogMapper.insertTOperationLog(log);
        return log.getLogId();
    }

    @Override
    public void cleanOperationLog() {
        tOperationLogMapper.cleanOperationLog();
    }

    /**
     * 计算日志数据哈希
     */
    private String calculateLogHash(String operatorId, String operatorRole, String opType, String opDetail, Date opTime) {
        String data = String.format("%s|%s|%s|%s|%d", 
            operatorId, operatorRole, opType, opDetail, opTime.getTime());
        return sha256(data);
    }

    private String sha256(String data) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return "0x" + hexString.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
