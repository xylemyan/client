package com.cruoyi.domain;

/**
 * 管理员信息
 */
public class TAdmin {
    private String adminId;
    private String password;
    private String name;
    private String gender;

    public String getAdminId() { return adminId; }
    public void setAdminId(String adminId) { this.adminId = adminId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
