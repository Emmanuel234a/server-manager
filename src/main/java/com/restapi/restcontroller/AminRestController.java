package com.restapi.restcontroller;

import com.restapi.entity.Admin;
import com.restapi.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/")
@RequiredArgsConstructor
public class AminRestController {
//    inject service class
    private final AdminService adminService;
//    REST API TO LIST ALL ADMINS
    @GetMapping("all")
    public ResponseEntity<List<Admin>> findAllAdmins(){
        return new ResponseEntity<>(adminService.getAllAdmins(), HttpStatus.OK);
    }
//    REST API TO SAVE NEW ADMIN IN THE SYSTEM
    @PostMapping("add")
    public ResponseEntity<Admin> saveNewAdmin(@RequestBody() Admin admin){
        return new ResponseEntity<>(adminService.addNewAdmin(admin),HttpStatus.CREATED);
    }
//    REST API TO SELECT ADMIN BY ID
    @GetMapping("{admin_id}")
    public ResponseEntity<Admin> findAdminById(@PathVariable("admin_id") Long admin_id){
           return new ResponseEntity<>(adminService.selectById(admin_id),HttpStatus.OK);
    }
//    REST API TO UPDATE ADMIN DETAILS
    @PutMapping("{admin_id}")
    public ResponseEntity<Admin>
    updateAdmin(@RequestBody() Admin admin,@PathVariable("admin_id") Long admin_id){
        return new ResponseEntity<>(adminService.updateById(admin,admin_id),HttpStatus.OK);
    }
//    REST API TO DELETE ADMIN
    @DeleteMapping("{admin_id}")
    public String deleteAdmin(@PathVariable("admin_id")  Long admin_id){
        adminService.deleteAdmin(admin_id);
        return "Admin deleted successful from the database";
    }
}
