package com.dboard.services.service;

import com.dboard.services.dao.ServicePathDao;
import com.dboard.services.entity.ServicePath;
import com.dboard.services.request.ServicePathRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Created by Dash on 4/15/2018.
 */
@Service
public class ServicePathImpl {

    @Autowired
    private ServicePathDao servicePathDao;

    public ResponseEntity serviceRestart(ServicePathRequest servicePathRequest){

        try {
            ServicePath servicePath = servicePathDao.findByServiceNameEquals(servicePathRequest.getServiceName());
            Process process = new ProcessBuilder( servicePath.getPath()).start();
            process.waitFor();
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
