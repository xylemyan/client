package com.cruoyi.system.domain.vo;

import java.io.Serializable;
import java.util.List;

public class GradeChartVO implements Serializable {
    private List<String> xAxisData; // Labels
    private List<Object> seriesData; // Values
    private String chartType; // bar, pie, line

    public List<String> getxAxisData() { return xAxisData; }
    public void setxAxisData(List<String> xAxisData) { this.xAxisData = xAxisData; }

    public List<Object> getSeriesData() { return seriesData; }
    public void setSeriesData(List<Object> seriesData) { this.seriesData = seriesData; }

    public String getChartType() { return chartType; }
    public void setChartType(String chartType) { this.chartType = chartType; }
}
