package com.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "server_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServerEntity {
//    list some server attributes
    @SequenceGenerator(
            name = "server_sequence",
            sequenceName = "server_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
    generator = "server_sequence")
    private Long server_id;
    @Column(name = "server_name",nullable = false)
    private String serverName;
    @Column(name = "server_location",nullable = false)
    private String serverLocation;
    @Column(name = "server_type",nullable = false)
    private String serverType;
    @Column(name = "server_status",nullable = false) @Enumerated()
    private ServerStatus severStatus;
    @Column(name = "server_ip",nullable = false)
    private String serverIP;
//    use lombok to reduce boilerplate code

}
