package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.TTeacher;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 教师信息Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "teacherClient")
public interface TeacherClient {

    @GetMapping("/system/teacher/list")
    TableDataInfo list(@SpringQueryMap TTeacher tTeacher);

    @GetMapping("/system/teacher/{teacherId}")
    AjaxResult getInfo(@PathVariable("teacherId") String teacherId);

    @PostMapping("/system/teacher")
    AjaxResult add(@RequestBody TTeacher tTeacher);

    @PutMapping("/system/teacher")
    AjaxResult edit(@RequestBody TTeacher tTeacher);

    @DeleteMapping("/system/teacher/{teacherIds}")
    AjaxResult remove(@PathVariable("teacherIds") String[] teacherIds);
}
