package com.cruoyi.system.service.impl;

import java.util.List;

import com.cruoyi.system.domain.TAdmin;
import com.cruoyi.system.mapper.TAdminMapper;
import com.cruoyi.system.service.ITAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 管理员信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-13
 */
@Service
public class TAdminServiceImpl implements ITAdminService
{
    @Autowired
    private TAdminMapper tAdminMapper;

    /**
     * 查询管理员信息
     * 
     * @param adminId 管理员信息主键
     * @return 管理员信息
     */
    @Override
    public TAdmin selectTAdminByAdminId(String adminId)
    {
        return tAdminMapper.selectTAdminByAdminId(adminId);
    }

    /**
     * 查询管理员信息列表
     * 
     * @param tAdmin 管理员信息
     * @return 管理员信息
     */
    @Override
    public List<TAdmin> selectTAdminList(TAdmin tAdmin)
    {
        return tAdminMapper.selectTAdminList(tAdmin);
    }

    /** 默认密码 */
    private static final String DEFAULT_PASSWORD = "123456";

    /**
     * 新增管理员信息
     * 
     * @param tAdmin 管理员信息
     * @return 结果
     */
    @Override
    public int insertTAdmin(TAdmin tAdmin)
    {
        // 设置默认密码并加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        tAdmin.setPassword(encoder.encode(DEFAULT_PASSWORD));
        return tAdminMapper.insertTAdmin(tAdmin);
    }

    /**
     * 修改管理员信息
     * 
     * @param tAdmin 管理员信息
     * @return 结果
     */
    @Override
    public int updateTAdmin(TAdmin tAdmin)
    {
        return tAdminMapper.updateTAdmin(tAdmin);
    }

    /**
     * 批量删除管理员信息
     * 
     * @param adminIds 需要删除的管理员信息主键
     * @return 结果
     */
    @Override
    public int deleteTAdminByAdminIds(String[] adminIds)
    {
        return tAdminMapper.deleteTAdminByAdminIds(adminIds);
    }

    /**
     * 删除管理员信息信息
     * 
     * @param adminId 管理员信息主键
     * @return 结果
     */
    @Override
    public int deleteTAdminByAdminId(String adminId)
    {
        return tAdminMapper.deleteTAdminByAdminId(adminId);
    }
}
