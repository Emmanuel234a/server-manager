package com.restapi.service;

import com.restapi.entity.Admin;

import java.util.List;

public interface AdminService {
//    define all the methods to be performed on the admin
    public List<Admin> getAllAdmins();
    public Admin addNewAdmin(Admin admin);
    public Admin selectById(Long admin_id);
    public Admin updateById(Admin admin,Long admin_id);
    public void  deleteAdmin(Long admin_id);



}
