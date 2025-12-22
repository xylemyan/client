package com.cruoyi.csystem;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.dto.GradeAnalysisDTO;
import com.cruoyi.feign.GradeAnalysisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/gradeAnalysis")
public class GradeAnalysisController {

    @Autowired
    private GradeAnalysisClient gradeAnalysisClient;

    @GetMapping("/generate")
    public AjaxResult generate(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false) String classSeq) {
        return gradeAnalysisClient.generate(academicYear, semester, courseId, classSeq);
    }

    @GetMapping("/chart")
    public AjaxResult chart(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false) String classSeq) {
        return gradeAnalysisClient.chart(academicYear, semester, courseId, classSeq);
    }

    @GetMapping("/history")
    public TableDataInfo history(
            @RequestParam(required = false) String courseName,
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        return gradeAnalysisClient.history(courseName, academicYear, semester, pageNum, pageSize);
    }

    @GetMapping("/courseList")
    public AjaxResult courseList(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester) {
        return gradeAnalysisClient.courseList(academicYear, semester);
    }

    @PostMapping("/saveAnalysis")
    public AjaxResult saveAnalysis(@RequestBody GradeAnalysisDTO gradeAnalysis) {
        return gradeAnalysisClient.saveAnalysis(gradeAnalysis);
    }

    @PostMapping("/export")
    public AjaxResult export(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false) String classSeq) {
        return gradeAnalysisClient.export(academicYear, semester, courseId, classSeq);
    }
}
