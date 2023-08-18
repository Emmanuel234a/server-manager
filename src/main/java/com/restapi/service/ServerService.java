package com.restapi.service;

import com.restapi.entity.ServerEntity;

import java.util.List;

public interface ServerService {
//     define all crud methods to be performed on server object
    public List<ServerEntity> listAll();
    public ServerEntity saveNew(ServerEntity server);
    public ServerEntity selectBYId(Long server_id);
    public ServerEntity pingServer(ServerEntity serverEntity);
    public ServerEntity updateServer(ServerEntity serverEntity,Long server_id);
    public void  deleteServer(Long server_id);
}
