package com.cruoyi.csystem;

import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.feign.StudentGradeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/student.grade/grade")
public class StudentGradeController {
    @Autowired
    private StudentGradeClient studentGradeClient;

    //查询学生成绩列表
    @GetMapping("/list")
    public TableDataInfo list(
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false) String classSeq,
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) Long semester,
            @RequestParam(required = false) String studentId  // Feign调用时传递
    ){
        return studentGradeClient.list(courseId,classSeq,academicYear,semester,studentId);
    }

    //导出学生成绩列表
    @PostMapping("/export")
    public void export(HttpServletResponse response,
                       @RequestParam(required = false) String courseId,
                       @RequestParam(required = false) String classSeq,
                       @RequestParam(required = false) String academicYear,
                       @RequestParam(required = false) Long semester){
        studentGradeClient.export(response,courseId,classSeq,academicYear,semester);
    }
}
