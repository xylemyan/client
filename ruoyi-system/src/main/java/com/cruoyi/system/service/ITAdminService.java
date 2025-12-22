package com.cruoyi.system.service;

import java.util.List;

import com.cruoyi.system.domain.TAdmin;

/**
 * 管理员信息Service接口
 * 
 * @author ruoyi
 * @date 2025-12-13
 */
public interface ITAdminService 
{
    /**
     * 查询管理员信息
     * 
     * @param adminId 管理员信息主键
     * @return 管理员信息
     */
    public TAdmin selectTAdminByAdminId(String adminId);

    /**
     * 查询管理员信息列表
     * 
     * @param tAdmin 管理员信息
     * @return 管理员信息集合
     */
    public List<TAdmin> selectTAdminList(TAdmin tAdmin);

    /**
     * 新增管理员信息
     * 
     * @param tAdmin 管理员信息
     * @return 结果
     */
    public int insertTAdmin(TAdmin tAdmin);

    /**
     * 修改管理员信息
     * 
     * @param tAdmin 管理员信息
     * @return 结果
     */
    public int updateTAdmin(TAdmin tAdmin);

    /**
     * 批量删除管理员信息
     * 
     * @param adminIds 需要删除的管理员信息主键集合
     * @return 结果
     */
    public int deleteTAdminByAdminIds(String[] adminIds);

    /**
     * 删除管理员信息信息
     * 
     * @param adminId 管理员信息主键
     * @return 结果
     */
    public int deleteTAdminByAdminId(String adminId);
}
