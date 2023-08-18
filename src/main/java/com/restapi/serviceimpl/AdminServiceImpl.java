package com.restapi.serviceimpl;

import com.restapi.entity.Admin;
import com.restapi.exception.AdminNotFound;
import com.restapi.repository.AdminRepository;
import com.restapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
//    inject admin repository
    private final AdminRepository adminRepository;
    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Admin addNewAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Admin selectById(Long admin_id) {
//        first check if he/she exists in the database
        Admin ifExists=adminRepository.findById(admin_id).
                orElseThrow(()-> new AdminNotFound("Such person does not exists in the database!"));
//        if admin exists, the go ahead and return the admin
        return ifExists;
    }

    @Override
    public Admin updateById(Admin admin, Long admin_id) {
        //        first check if he/she exists in the database
        Admin ifExists=adminRepository.findById(admin_id).
                orElseThrow(()-> new AdminNotFound("Such person does not exists in the database!"));
//        if admin exists, the go ahead and update the admin
        ifExists.setAdminEmail(admin.getAdminEmail());
        ifExists.setAdminLocation(admin.getAdminLocation());
        ifExists.setAdminSalary(admin.getAdminSalary());
//        now go ahead and save the changes
        return adminRepository.save(ifExists);
    }

    @Override
    public void deleteAdmin(Long admin_id) {
//        first check if he/she exists in the database
        Admin ifExists=adminRepository.findById(admin_id).
                orElseThrow(()-> new AdminNotFound("Such person does not exists in the database!"));
//        if admin exists, the go ahead and delete the admin
        adminRepository.delete(ifExists);
    }
}
