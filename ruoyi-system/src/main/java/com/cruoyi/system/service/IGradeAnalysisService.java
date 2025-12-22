package com.cruoyi.system.service;

import com.cruoyi.system.domain.dto.GradeAnalysisDTO;
import com.cruoyi.system.domain.vo.GradeChartVO;
import com.cruoyi.system.domain.vo.GradeHistoryVO;
import com.cruoyi.system.domain.vo.GradeMetricsVO;
import com.cruoyi.system.domain.vo.GradeRowVO;

import java.util.List;
import java.util.Map;

public interface IGradeAnalysisService {
    /**
     * Get grade list for a course
     */
    List<GradeRowVO> selectGradeList(GradeAnalysisDTO query);

    /**
     * Calculate metrics from the list
     */
    GradeMetricsVO calculateMetrics(List<GradeRowVO> gradeList);

    /**
     * Get chart data
     */
    Map<String, GradeChartVO> getChartData(List<GradeRowVO> gradeList, GradeAnalysisDTO query);

    /**
     * Get history
     */
    List<GradeHistoryVO> selectHistoryCourses(GradeAnalysisDTO query);

    /**
     * Get teacher's courses
     */
    List<Map<String, Object>> selectTeacherCourses(GradeAnalysisDTO query);

    /**
     * Save analysis content
     */
    int updateAnalysis(GradeAnalysisDTO gradeAnalysis);

    /**
     * Select analysis content
     */
    String selectAnalysis(GradeAnalysisDTO query);
}
