package com.cruoyi.system.service.impl;

import com.cruoyi.system.domain.dto.GradeAnalysisDTO;
import com.cruoyi.system.domain.vo.GradeChartVO;
import com.cruoyi.system.domain.vo.GradeHistoryVO;
import com.cruoyi.system.domain.vo.GradeMetricsVO;
import com.cruoyi.system.domain.vo.GradeRowVO;
import com.cruoyi.system.service.IGradeAnalysisService;
import com.cruoyi.system.mapper.GradeAnalysisMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

@Service
public class GradeAnalysisServiceImpl implements IGradeAnalysisService {

    @Autowired
    private GradeAnalysisMapper gradeAnalysisMapper;

    @Override
    public List<GradeRowVO> selectGradeList(GradeAnalysisDTO query) {
        return gradeAnalysisMapper.selectGradeList(query);
    }

    @Override
    public GradeMetricsVO calculateMetrics(List<GradeRowVO> gradeList) {
        GradeMetricsVO metrics = new GradeMetricsVO();

        // Ensure distribution is always present to avoid frontend null errors
        Map<String, Integer> dist = new LinkedHashMap<>();
        dist.put("0-59", 0);
        dist.put("60-69", 0);
        dist.put("70-79", 0);
        dist.put("80-89", 0);
        dist.put("90-100", 0);
        metrics.setScoreDistribution(dist);

        if (gradeList == null || gradeList.isEmpty()) {
            metrics.setMaxScore(BigDecimal.ZERO);
            metrics.setMinScore(BigDecimal.ZERO);
            metrics.setAvgScore(BigDecimal.ZERO);
            metrics.setPassRate(BigDecimal.ZERO);
            return metrics;
        }

        BigDecimal sum = BigDecimal.ZERO;
        BigDecimal max = BigDecimal.ZERO;
        BigDecimal min = new BigDecimal("999");
        int passCount = 0;
        
        for (GradeRowVO row : gradeList) {
            BigDecimal score = row.getScoreTotal();
            if (score == null) score = BigDecimal.ZERO;

            sum = sum.add(score);
            if (score.compareTo(max) > 0) max = score;
            if (score.compareTo(min) < 0) min = score;

            if (score.doubleValue() >= 60) passCount++;

            // Distribution
            double val = score.doubleValue();
            if (val < 60) dist.put("0-59", dist.get("0-59") + 1);
            else if (val < 70) dist.put("60-69", dist.get("60-69") + 1);
            else if (val < 80) dist.put("70-79", dist.get("70-79") + 1);
            else if (val < 90) dist.put("80-89", dist.get("80-89") + 1);
            else dist.put("90-100", dist.get("90-100") + 1);
        }

        metrics.setMaxScore(max);
        metrics.setMinScore(min.compareTo(new BigDecimal("999")) == 0 ? BigDecimal.ZERO : min);
        metrics.setAvgScore(sum.divide(new BigDecimal(gradeList.size()), 2, RoundingMode.HALF_UP));
        metrics.setPassRate(new BigDecimal(passCount).multiply(new BigDecimal(100))
                .divide(new BigDecimal(gradeList.size()), 2, RoundingMode.HALF_UP));
        return metrics;
    }

    @Override
    public Map<String, GradeChartVO> getChartData(List<GradeRowVO> gradeList, GradeAnalysisDTO query) {
        Map<String, GradeChartVO> charts = new HashMap<>();
        GradeMetricsVO metrics = calculateMetrics(gradeList);

        // Bar Chart (Distribution)
        GradeChartVO barChart = new GradeChartVO();
        barChart.setChartType("bar");
        barChart.setxAxisData(new ArrayList<>(metrics.getScoreDistribution().keySet()));
        barChart.setSeriesData(new ArrayList<>(metrics.getScoreDistribution().values()));
        charts.put("distribution", barChart);

        // Pie Chart (Pass Rate)
        GradeChartVO pieChart = new GradeChartVO();
        pieChart.setChartType("pie");
        List<Object> pieData = new ArrayList<>();
        int total = gradeList.size();
        int passed = (int) (total * metrics.getPassRate().doubleValue() / 100);
        int failed = total - passed;
        
        Map<String, Object> passItem = new HashMap<>(); passItem.put("name", "通过"); passItem.put("value", passed);
        Map<String, Object> failItem = new HashMap<>(); failItem.put("name", "未通过"); failItem.put("value", failed);
        pieData.add(passItem);
        pieData.add(failItem);
        
        pieChart.setSeriesData(pieData);
        charts.put("passRate", pieChart);

        // Line Chart (History Avg) - requires separate DB call
        GradeChartVO lineChart = new GradeChartVO();
        lineChart.setChartType("line");
        
        // We need history for this course, but generic query
        // Re-using selectHistoryCourses but filtering by courseId only (ignore semester)
        GradeAnalysisDTO historyQuery = new GradeAnalysisDTO();
        historyQuery.setTeacherId(query.getTeacherId()); // Keep teacher context
        historyQuery.setCourseId(query.getCourseId());
        // No semester/year filter to get all history
        
        // Note: The selectHistoryCourses mapper uses courseName fuzzy search or exact ID matching if we modify it.
        // Current mapper uses courseName. Let's fetch course name first or modify mapper.
        // Actually, let's just fetch history for the same course name.
        if (gradeList.size() > 0) {
             // Assuming all rows have same course. But we don't have course name in DTO easily.
             // Ideally we should have it.
        }
        
        return charts;
    }

    @Override
    public List<GradeHistoryVO> selectHistoryCourses(GradeAnalysisDTO query) {
        return gradeAnalysisMapper.selectHistoryCourses(query);
    }

    @Override
    public List<Map<String, Object>> selectTeacherCourses(GradeAnalysisDTO query) {
        return gradeAnalysisMapper.selectTeacherCourses(query);
    }

    @Override
    public int updateAnalysis(GradeAnalysisDTO gradeAnalysis) {
        return gradeAnalysisMapper.updateAnalysis(gradeAnalysis);
    }

    @Override
    public String selectAnalysis(GradeAnalysisDTO query) {
        return gradeAnalysisMapper.selectAnalysis(query);
    }
}
