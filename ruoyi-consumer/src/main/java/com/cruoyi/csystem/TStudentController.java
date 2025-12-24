package com.cruoyi.csystem;

import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.TStudent;
import com.cruoyi.feign.StudentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 学生信息Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/student")
public class TStudentController extends BaseController {

    @Autowired
    private StudentClient studentClient;

    @GetMapping("/list")
    public TableDataInfo list(TStudent tStudent) {
        return studentClient.list(tStudent);
    }

    @GetMapping("/{studentId}")
    public AjaxResult getInfo(@PathVariable("studentId") String studentId) {
        return studentClient.getInfo(studentId);
    }

    @PostMapping
    public AjaxResult add(@RequestBody TStudent tStudent) {
        return studentClient.add(tStudent);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody TStudent tStudent) {
        return studentClient.edit(tStudent);
    }

    @DeleteMapping("/{studentIds}")
    public AjaxResult remove(@PathVariable String[] studentIds) {
        return studentClient.remove(studentIds);
    }
}
