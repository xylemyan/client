package com.cruoyi.system.mapper;

import com.cruoyi.system.domain.dto.GradeAnalysisDTO;
import com.cruoyi.system.domain.vo.GradeHistoryVO;
import com.cruoyi.system.domain.vo.GradeRowVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface GradeAnalysisMapper {
    /**
     * Get list of student grades for a specific course/semester
     */
    List<GradeRowVO> selectGradeList(GradeAnalysisDTO query);

    /**
     * Get grade coefficients (Assuming single global setting or handling in service)
     * Returning map for flexibility
     */
    Map<String, Object> selectGradeCoefficients();

    /**
     * Get history of courses for a teacher
     */
    List<GradeHistoryVO> selectHistoryCourses(GradeAnalysisDTO query);

    /**
     * Get course list for a teacher in a specific semester
     */
    List<Map<String, Object>> selectTeacherCourses(GradeAnalysisDTO query);
    
    /**
     * Get stats for distribution (0-59, 60-69 etc)
     * This might be easier to calculate in Java from the list, but can be done in SQL
     */
    Map<String, Object> selectGradeDistributionStats(GradeAnalysisDTO query);

    /**
     * Update analysis content
     */
    int updateAnalysis(GradeAnalysisDTO query);

    /**
     * Select analysis content
     */
    String selectAnalysis(GradeAnalysisDTO query);
}
