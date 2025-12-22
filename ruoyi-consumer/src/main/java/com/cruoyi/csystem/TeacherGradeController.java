package com.cruoyi.csystem;



import com.cruoyi.common.annotation.Anonymous;
import com.cruoyi.common.annotation.Log;
import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.common.enums.BusinessType;
import com.cruoyi.common.utils.SecurityUtils;
import com.cruoyi.feign.TeacherGradeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.cruoyi.domain.dto.GradeInputDTO;
import com.cruoyi.domain.dto.RevokeApplyDTO;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teacher/grade")
public class TeacherGradeController extends BaseController {

    @Autowired
    private TeacherGradeClient teacherGradeClient;

    /**
     * 获取当前学期信息
     */

    @GetMapping("/currentTerm")
    public AjaxResult getCurrentTerm() {
       return teacherGradeClient.getCurrentTerm();
    }

    /**
     * 获取当前学期教师任课列表
     */
    //@PreAuthorize("@ss.hasPermi('teacher:grade:list')")
    @GetMapping("/courses")
    public AjaxResult getCurrentTermCourses(HttpServletRequest request) {
        return teacherGradeClient.getCurrentTermCourses();
    }

    /**
     * 获取课程成绩系数设置
     */
    // @PreAuthorize("@ss.hasPermi('teacher:grade:list')")
    @GetMapping("/coefficient")
    public AjaxResult getGradeCoefficient(
            @RequestParam String courseId,
            @RequestParam String academicYear,
            @RequestParam Integer semester) {
        return teacherGradeClient.getGradeCoefficient(courseId,academicYear,semester);
    }

    /**
     * 获取课程学生列表（用于成绩录入）
     */
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:list')")
    @GetMapping("/students")
    public TableDataInfo getCourseStudents(
            @RequestParam String courseId,
            @RequestParam String classSeq,
            @RequestParam String academicYear,
            @RequestParam Integer semester,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {

        return teacherGradeClient.getCourseStudents(courseId,classSeq,academicYear,semester,pageNum,pageSize);
    }

    @GetMapping("/resitstudents")
    public TableDataInfo getResitCourseStudents(
            @RequestParam String courseId,
            @RequestParam String classSeq,
            @RequestParam String academicYear,
            @RequestParam Integer semester,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "20") Integer pageSize) {

        return teacherGradeClient.getResitCourseStudents(courseId,classSeq,academicYear,semester,pageNum,pageSize);
    }
    /**
     * 保存成绩系数设置
     */
    @Log(title = "成绩系数设置", businessType = BusinessType.UPDATE)
    // @PreAuthorize("@ss.hasPermi('teacher:grade:edit')")
    @PostMapping("/coefficient")
    public AjaxResult saveCoefficient(@RequestBody GradeInputDTO dto) {
        return teacherGradeClient.saveCoefficient(dto);
    }

    /**
     * 暂存学生成绩
     */
    @Log(title = "暂存成绩", businessType = BusinessType.INSERT)
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:add')")
    @PostMapping("/temp")
    public AjaxResult saveTempGrades(@RequestBody GradeInputDTO dto) {
        return teacherGradeClient.saveTempGrades(dto);
    }

    /**
     * 提交学生成绩（正式提交）
     */
    @Log(title = "提交成绩", businessType = BusinessType.UPDATE)
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:edit')")
    @PostMapping("/submit")
    public AjaxResult submitGrades(@RequestBody GradeInputDTO dto) {
        return teacherGradeClient.submitGrades(dto);
    }
    @Log(title = "暂存补考成绩", businessType = BusinessType.INSERT)
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:add')")
    @PostMapping("/resittemp")
    public AjaxResult saveResitTempGrades(@RequestBody GradeInputDTO dto) {
        return teacherGradeClient.saveResitTempGrades(dto);
    }

    /**
     * 提交学生成绩（正式提交）
     */
    @Log(title = "提交补考成绩", businessType = BusinessType.UPDATE)
    //  @PreAuthorize("@ss.hasPermi('teacher:grade:edit')")
    @PostMapping("/resitsubmit")
    public AjaxResult submitResitGrades(@RequestBody GradeInputDTO dto) {
        return teacherGradeClient.submitResitGrades(dto);
    }

    /**
     * 申请撤销/修改成绩
     */
    @Log(title = "申请撤销成绩", businessType = BusinessType.UPDATE)
    // @PreAuthorize("@ss.hasPermi('teacher:grade:revoke')")
    @PostMapping("/revoke")
    public AjaxResult applyRevoke(@RequestBody RevokeApplyDTO dto) {
        return teacherGradeClient.applyRevoke(dto);
    }
}