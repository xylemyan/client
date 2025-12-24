package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.TTeacher;
import com.cruoyi.feign.TeacherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 教师信息Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/teacher")
public class TTeacherController extends BaseController {

    @Autowired
    private TeacherClient teacherClient;

    @GetMapping("/list")
    public TableDataInfo list(TTeacher tTeacher) {
        return teacherClient.list(tTeacher);
    }

    @GetMapping("/{teacherId}")
    public AjaxResult getInfo(@PathVariable("teacherId") String teacherId) {
        return teacherClient.getInfo(teacherId);
    }

    @PostMapping
    public AjaxResult add(@RequestBody TTeacher tTeacher) {
        return teacherClient.add(tTeacher);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody TTeacher tTeacher) {
        return teacherClient.edit(tTeacher);
    }

    @DeleteMapping("/{teacherIds}")
    public AjaxResult remove(@PathVariable String[] teacherIds) {
        return teacherClient.remove(teacherIds);
    }
}
