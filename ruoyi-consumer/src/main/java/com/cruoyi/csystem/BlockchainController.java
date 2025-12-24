package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.domain.dto.GradeQueryDTO;
import com.cruoyi.domain.dto.GradeStoreDTO;
import com.cruoyi.domain.dto.GradeVerifyDTO;
import com.cruoyi.feign.BlockchainClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 区块链管理Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/blockchain")
public class BlockchainController extends BaseController {

    @Autowired
    private BlockchainClient blockchainClient;

    /**
     * 获取区块链连接状态
     */
    @GetMapping("/status")
    public AjaxResult getStatus() {
        return blockchainClient.getStatus();
    }

    /**
     * 获取当前区块高度
     */
    @GetMapping("/blockNumber")
    public AjaxResult getBlockNumber() {
        return blockchainClient.getBlockNumber();
    }

    /**
     * 验证成绩是否被篡改（明文对比）
     */
    @PostMapping("/verifyGrade")
    public AjaxResult verifyGrade(@RequestBody GradeVerifyDTO dto) {
        return blockchainClient.verifyGrade(dto);
    }

    /**
     * 从区块链获取原始成绩（数据恢复）
     */
    @PostMapping("/getGradeFromChain")
    public AjaxResult getGradeFromChain(@RequestBody GradeQueryDTO dto) {
        return blockchainClient.getGradeFromChain(dto);
    }

    /**
     * 检查成绩是否已上链
     */
    @PostMapping("/existsOnChain")
    public AjaxResult existsOnChain(@RequestBody GradeQueryDTO dto) {
        return blockchainClient.existsOnChain(dto);
    }

    /**
     * 成绩上链
     */
    @PostMapping("/storeGrade")
    public AjaxResult storeGrade(@RequestBody GradeStoreDTO dto) {
        return blockchainClient.storeGrade(dto);
    }

    /**
     * 从区块链还原成绩到数据库
     */
    @PostMapping("/restoreToDb")
    public AjaxResult restoreToDb(@RequestBody GradeQueryDTO dto) {
        return blockchainClient.restoreToDb(dto);
    }

    /**
     * 批量扫描成绩篡改
     */
    @GetMapping("/scanTampered")
    public AjaxResult scanTampered() {
        return blockchainClient.scanTampered();
    }
}
