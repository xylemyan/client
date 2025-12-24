package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.domain.dto.GradeQueryDTO;
import com.cruoyi.domain.dto.GradeStoreDTO;
import com.cruoyi.domain.dto.GradeVerifyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 区块链服务Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "Blockchain")
public interface BlockchainClient {

    /**
     * 获取区块链连接状态
     */
    @GetMapping("/system/blockchain/status")
    AjaxResult getStatus();

    /**
     * 获取当前区块高度
     */
    @GetMapping("/system/blockchain/blockNumber")
    AjaxResult getBlockNumber();

    /**
     * 验证成绩是否被篡改（明文对比）
     */
    @PostMapping("/system/blockchain/verifyGrade")
    AjaxResult verifyGrade(@RequestBody GradeVerifyDTO dto);

    /**
     * 从区块链获取原始成绩（数据恢复）
     */
    @PostMapping("/system/blockchain/getGradeFromChain")
    AjaxResult getGradeFromChain(@RequestBody GradeQueryDTO dto);

    /**
     * 检查成绩是否已上链
     */
    @PostMapping("/system/blockchain/existsOnChain")
    AjaxResult existsOnChain(@RequestBody GradeQueryDTO dto);

    /**
     * 成绩上链
     */
    @PostMapping("/system/blockchain/storeGrade")
    AjaxResult storeGrade(@RequestBody GradeStoreDTO dto);
}
