package com.cruoyi.feign;

import com.cruoyi.common.core.domain.AjaxResult;
import com.cruoyi.common.core.page.TableDataInfo;
import com.cruoyi.domain.dto.TeacherRevokeLogDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * 成绩撤销管理Feign客户端
 */
@FeignClient(name = "ruoyi-server", url = "https://localhost:8081", contextId = "Revoke")
public interface RevokeClient {

    /**
     * 查询成绩撤销申请列表
     */
    @GetMapping("/system/revoke/list")
    TableDataInfo list(@SpringQueryMap TeacherRevokeLogDTO dto);

    /**
     * 获取成绩撤销申请详细信息
     */
    @GetMapping("/system/revoke/{revokeId}")
    AjaxResult getInfo(@PathVariable("revokeId") Long revokeId);

    /**
     * 新增成绩撤销申请
     */
    @PostMapping("/system/revoke")
    AjaxResult add(@RequestBody TeacherRevokeLogDTO dto);

    /**
     * 修改成绩撤销申请
     */
    @PutMapping("/system/revoke")
    AjaxResult edit(@RequestBody TeacherRevokeLogDTO dto);

    /**
     * 删除成绩撤销申请
     */
    @DeleteMapping("/system/revoke/{revokeIds}")
    AjaxResult remove(@PathVariable("revokeIds") Long[] revokeIds);

    /**
     * 审批通过
     */
    @PutMapping("/system/revoke/approve/{revokeId}")
    AjaxResult approve(@PathVariable("revokeId") Long revokeId, @RequestBody TeacherRevokeLogDTO dto);

    /**
     * 审批拒绝
     */
    @PutMapping("/system/revoke/reject/{revokeId}")
    AjaxResult reject(@PathVariable("revokeId") Long revokeId, @RequestBody TeacherRevokeLogDTO dto);
}
