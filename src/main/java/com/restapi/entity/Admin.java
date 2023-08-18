package com.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@Table(name = "admin_tbl")
@NoArgsConstructor
public class Admin {
//     add admin attributes
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
// add some validations in table attributes
    private Long admin_id;
    private String adminName;
    @Column(unique = true, length = 64,nullable = false)
    private String adminEmail;
    private String adminPassword;
    private String adminLocation;
    private BigDecimal adminSalary;
//    use lombok to reduce boilerplate code


}
