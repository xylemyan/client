package com.cruoyi.csystem;

import com.cruoyi.common.annotation.Log;
import com.cruoyi.common.core.controller.BaseController;
import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.common.enums.BusinessType;
import com.cruoyi.domain.dto.TeacherRevokeLogDTO;
import com.cruoyi.feign.RevokeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 成绩撤销管理Controller（Feign远程调用）
 */
@RestController
@RequestMapping("/system/revoke")
public class RevokeController extends BaseController {

    @Autowired
    private RevokeClient revokeClient;

    /**
     * 查询成绩撤销申请列表
     */
    @GetMapping("/list")
    public TableDataInfo list(TeacherRevokeLogDTO dto) {
        return revokeClient.list(dto);
    }

    /**
     * 获取成绩撤销申请详细信息
     */
    @GetMapping("/{revokeId}")
    public AjaxResult getInfo(@PathVariable("revokeId") Long revokeId) {
        return revokeClient.getInfo(revokeId);
    }

    /**
     * 新增成绩撤销申请
     */
    @Log(title = "成绩撤销管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TeacherRevokeLogDTO dto) {
        return revokeClient.add(dto);
    }

    /**
     * 修改成绩撤销申请
     */
    @Log(title = "成绩撤销管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TeacherRevokeLogDTO dto) {
        return revokeClient.edit(dto);
    }

    /**
     * 删除成绩撤销申请
     */
    @Log(title = "成绩撤销管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{revokeIds}")
    public AjaxResult remove(@PathVariable Long[] revokeIds) {
        return revokeClient.remove(revokeIds);
    }

    /**
     * 审批通过
     */
    @Log(title = "成绩撤销审批", businessType = BusinessType.UPDATE)
    @PutMapping("/approve/{revokeId}")
    public AjaxResult approve(@PathVariable Long revokeId, @RequestBody TeacherRevokeLogDTO dto) {
        return revokeClient.approve(revokeId, dto);
    }

    /**
     * 审批拒绝
     */
    @Log(title = "成绩撤销审批", businessType = BusinessType.UPDATE)
    @PutMapping("/reject/{revokeId}")
    public AjaxResult reject(@PathVariable Long revokeId, @RequestBody TeacherRevokeLogDTO dto) {
        return revokeClient.reject(revokeId, dto);
    }
}
