package com.restapi.restcontroller;

import com.restapi.entity.ServerEntity;
import com.restapi.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ServerManagerController {
//    inject server service using constructor base
    private final ServerService serverService;
//    REST API TO ADD NEW SERVER IN THE SERVER MANAGER SYSTEM
    @PostMapping("add")
    public ResponseEntity<ServerEntity> addNew(@RequestBody ServerEntity serverEntity){
        return new ResponseEntity<>(serverService.saveNew(serverEntity), HttpStatus.CREATED);
    }
//    REST API TO LIST ALL SERVERS IN THE SERVER MANAGER
    @GetMapping("all")
    public  ResponseEntity<List<ServerEntity>> getAll(){
        return new ResponseEntity<>(serverService.listAll(),HttpStatus.OK);
    }
//    REST API TO UPDATE SERVERS IN THE SERVER MANAGER SYSTEM
    @PutMapping("{server_id}")
    public ResponseEntity<ServerEntity> updateServer(@RequestBody ServerEntity serverEntity,@PathVariable("server_id") Long server_id){
        return new ResponseEntity<>(serverService.updateServer(serverEntity,server_id),HttpStatus.OK);
    }
//    REST API TO SELECT SERVER BY ID FROM THE SERVER MANAGER
    @GetMapping("{server_id}")
    public ResponseEntity<ServerEntity> selectById(@PathVariable("server_id") Long server_id){
      return new ResponseEntity<>(serverService.selectBYId(server_id),HttpStatus.OK);
    }
//    REST API DELETE SERVERS FROM THE SERVER MANAGER SYSTEM
    @DeleteMapping("{server_id}")
    public  String erase(@PathVariable("server_id") Long server_id){
        serverService.deleteServer(server_id);
        return "Server deleted successful!";
    }
}
