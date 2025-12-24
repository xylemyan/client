package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.feign.SysDictDataClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 字典数据Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/dict/data")
public class SysDictDataController extends BaseController {

    @Autowired
    private SysDictDataClient sysDictDataClient;

    @GetMapping("/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType) {
        return sysDictDataClient.dictType(dictType);
    }

    @GetMapping("/{dictCode}")
    public AjaxResult getInfo(@PathVariable Long dictCode) {
        return sysDictDataClient.getInfo(dictCode);
    }
}
