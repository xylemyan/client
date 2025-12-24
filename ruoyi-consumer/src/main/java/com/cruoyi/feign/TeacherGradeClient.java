package com.cruoyi.feign;

import com.cruoyi.common.annotation.Log;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.common.enums.BusinessType;
import com.cruoyi.common.utils.SecurityUtils;
import com.cruoyi.domain.dto.GradeInputDTO;
import com.cruoyi.domain.dto.RevokeApplyDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "TeacherGrade")
public interface TeacherGradeClient {
    @GetMapping("/teacher/grade/currentTerm")
    public AjaxResult getCurrentTerm();

    /**
     * 获取当前学期教师任课列表
     */
    //@PreAuthorize("@ss.hasPermi('teacher:grade:list')")
    @GetMapping("/teacher/grade/courses")
    public AjaxResult getCurrentTermCourses();

    /**
     * 获取课程成绩系数设置
     */
    // @PreAuthorize("@ss.hasPermi('teacher:grade:list')")
    @GetMapping("/teacher/grade/coefficient")
    public AjaxResult getGradeCoefficient(
            @RequestParam String courseId,
            @RequestParam String academicYear,
            @RequestParam Integer semester);

    /**
     * 获取课程学生列表（用于成绩录入）
     */
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:list')")
    @GetMapping("/teacher/grade/students")
    public TableDataInfo getCourseStudents(
            @RequestParam String courseId,
            @RequestParam String classSeq,
            @RequestParam String academicYear,
            @RequestParam Integer semester,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize);

    @GetMapping("/teacher/grade/resitstudents")
    public TableDataInfo getResitCourseStudents(
            @RequestParam String courseId,
            @RequestParam String classSeq,
            @RequestParam String academicYear,
            @RequestParam Integer semester,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize);
    /**
     * 保存成绩系数设置
     */
    @Log(title = "成绩系数设置", businessType = BusinessType.UPDATE)
    // @PreAuthorize("@ss.hasPermi('teacher:grade:edit')")
    @PostMapping("/teacher/grade/coefficient")
    public AjaxResult saveCoefficient(@RequestBody GradeInputDTO dto);

    /**
     * 暂存学生成绩
     */
    @Log(title = "暂存成绩", businessType = BusinessType.INSERT)
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:add')")
    @PostMapping("/teacher/grade/temp")
    public AjaxResult saveTempGrades(@RequestBody GradeInputDTO dto);

    /**
     * 提交学生成绩（正式提交）
     */
    @Log(title = "提交成绩", businessType = BusinessType.UPDATE)
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:edit')")
    @PostMapping("/teacher/grade/submit")
    public AjaxResult submitGrades(@RequestBody GradeInputDTO dto);
    @Log(title = "暂存补考成绩", businessType = BusinessType.INSERT)
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:add')")
    @PostMapping("/teacher/grade/resittemp")
    public AjaxResult saveResitTempGrades(@RequestBody GradeInputDTO dto);

    /**
     * 提交学生成绩（正式提交）
     */
    @Log(title = "提交补考成绩", businessType = BusinessType.UPDATE)
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:edit')")
    @PostMapping("/teacher/grade/resitsubmit")
    public AjaxResult submitResitGrades(@RequestBody GradeInputDTO dto) ;

    /**
     * 申请撤销/修改成绩
     */
    @Log(title = "申请撤销成绩", businessType = BusinessType.UPDATE)
    // @PreAuthorize("@ss.hasPermi('teacher:grade:revoke')")
    @PostMapping("/teacher/grade/revoke")
    public AjaxResult applyRevoke(@RequestBody RevokeApplyDTO dto);
}
