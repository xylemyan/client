package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.dto.GradeAnalysisDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "GradeAnalysis")
public interface GradeAnalysisClient {

    @GetMapping("/system/gradeAnalysis/generate")
    AjaxResult generate(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false, value = "classSeq") String classSeq);

    @GetMapping("/system/gradeAnalysis/chart")
    AjaxResult chart(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false, value = "classSeq") String classSeq);

    @GetMapping("/system/gradeAnalysis/history")
    TableDataInfo history(
            @RequestParam(required = false) String courseName,
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false, defaultValue = "1") Integer pageNum,
            @RequestParam(required = false, defaultValue = "10") Integer pageSize);

    @GetMapping("/system/gradeAnalysis/courseList")
    AjaxResult courseList(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester);

    @PostMapping("/system/gradeAnalysis/saveAnalysis")
    AjaxResult saveAnalysis(@RequestBody GradeAnalysisDTO gradeAnalysis);

    @PostMapping("/system/gradeAnalysis/export")
    AjaxResult export(
            @RequestParam(required = false) String academicYear,
            @RequestParam(required = false) String semester,
            @RequestParam(required = false) String courseId,
            @RequestParam(required = false, value = "classSeq") String classSeq);
}
