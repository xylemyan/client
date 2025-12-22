package com.cruoyi.system.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * 成绩分析-统计指标 VO
 */
public class GradeMetricsVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private BigDecimal maxScore;
    private BigDecimal minScore;
    private BigDecimal avgScore;
    private BigDecimal passRate; // Percentage
    
    // 分数段人数 key: "0-59", "60-69", etc. value: count
    private Map<String, Integer> scoreDistribution;

    public BigDecimal getMaxScore() { return maxScore; }
    public void setMaxScore(BigDecimal maxScore) { this.maxScore = maxScore; }

    public BigDecimal getMinScore() { return minScore; }
    public void setMinScore(BigDecimal minScore) { this.minScore = minScore; }

    public BigDecimal getAvgScore() { return avgScore; }
    public void setAvgScore(BigDecimal avgScore) { this.avgScore = avgScore; }

    public BigDecimal getPassRate() { return passRate; }
    public void setPassRate(BigDecimal passRate) { this.passRate = passRate; }

    public Map<String, Integer> getScoreDistribution() { return scoreDistribution; }
    public void setScoreDistribution(Map<String, Integer> scoreDistribution) { this.scoreDistribution = scoreDistribution; }
}
