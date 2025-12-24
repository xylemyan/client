package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.TStudent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 学生信息Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "studentClient")
public interface StudentClient {

    @GetMapping("/system/student/list")
    TableDataInfo list(@SpringQueryMap TStudent tStudent);

    @GetMapping("/system/student/{studentId}")
    AjaxResult getInfo(@PathVariable("studentId") String studentId);

    @PostMapping("/system/student")
    AjaxResult add(@RequestBody TStudent tStudent);

    @PutMapping("/system/student")
    AjaxResult edit(@RequestBody TStudent tStudent);

    @DeleteMapping("/system/student/{studentIds}")
    AjaxResult remove(@PathVariable("studentIds") String[] studentIds);
}
