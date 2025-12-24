package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 字典数据Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "sysDictDataClient")
public interface SysDictDataClient {

    @GetMapping("/system/dict/data/type/{dictType}")
    AjaxResult dictType(@PathVariable("dictType") String dictType);

    @GetMapping("/system/dict/data/{dictCode}")
    AjaxResult getInfo(@PathVariable("dictCode") Long dictCode);
}
