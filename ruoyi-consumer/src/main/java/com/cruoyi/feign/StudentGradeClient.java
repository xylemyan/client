package com.cruoyi.feign;

import com.cruoyi.common.core.page.TableDataInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@FeignClient(name = "ruoyi-server", url = "http://localhost:8081", contextId = "studentGradeClient")
public interface StudentGradeClient {

    //查询学生成绩列表
    @GetMapping("/student.grade/grade/list")
    public TableDataInfo list(
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false) String classSeq,
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) Long semester,
            @RequestParam(required = false) String studentId  // Feign调用时传递
    );

    //导出学生成绩列表
    @PostMapping("/student.grade/grade/export")
    public void export(HttpServletResponse response,
                       @RequestParam(required = false) String courseId,
                       @RequestParam(required = false) String classSeq,
                       @RequestParam(required = false) String academicYear,
                       @RequestParam(required = false) Long semester);

}