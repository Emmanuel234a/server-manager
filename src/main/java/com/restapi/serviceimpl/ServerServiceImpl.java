package com.restapi.serviceimpl;

import com.restapi.entity.ServerEntity;
import com.restapi.exception.ServerNotFoundException;
import com.restapi.repository.ServerRepository;
import com.restapi.service.ServerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerServiceImpl implements ServerService {
//     use constructor base to inject repository in order to use Jpa methods
    private final ServerRepository serverRepository;
    @Override
    public List<ServerEntity> listAll() {
        return serverRepository.findAll();
    }
    @Override
    public ServerEntity saveNew(ServerEntity server) {
        return serverRepository.save(server);
    }

    @Override
    public ServerEntity selectBYId(Long server_id) {
//        first check if server by given id exists in the database
        ServerEntity ifExists=serverRepository.findById(server_id).
                orElseThrow(()-> new ServerNotFoundException("SUCH SERVER DOES NOT EXISTS IN THE DATABASE!"));
//        if it exists, go ahead and return the server
        return ifExists;
    }

    @Override
    public ServerEntity pingServer(ServerEntity serverEntity) {
        return null;
    }

    @Override
    public ServerEntity updateServer(ServerEntity serverEntity, Long server_id) {
        //        first check if server by given id exists in the database
        ServerEntity ifExists=serverRepository.findById(server_id).
                orElseThrow(()-> new ServerNotFoundException("SUCH SERVER DOES NOT EXISTS IN THE DATABASE!"));
// now go ahead and add the changes
        ifExists.setServerLocation(serverEntity.getServerLocation());
        ifExists.setServerType(serverEntity.getServerType());
        ifExists.setServerName(serverEntity.getServerName());
        ifExists.setSeverStatus(serverEntity.getSeverStatus());
        ifExists.setServerIP(serverEntity.getServerIP());
//        now go ahead and save the changes
        return serverRepository.save(ifExists);
    }

    @Override
    public void deleteServer(Long server_id) {
        //        first check if server by given id exists in the database
        ServerEntity ifExists=serverRepository.findById(server_id).
                orElseThrow(()-> new ServerNotFoundException("SUCH SERVER DOES NOT EXISTS IN THE DATABASE!"));

//        if exists, go ahead and delete the server
        serverRepository.delete(ifExists);

    }
}
