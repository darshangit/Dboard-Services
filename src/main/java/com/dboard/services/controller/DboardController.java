package com.dboard.services.controller;

import com.dboard.services.request.ServicePathRequest;
import com.dboard.services.service.ServicePathImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Dash on 4/15/2018.
 */
@RestController
@CrossOrigin("*")
public class DboardController {

    @Autowired
    private ServicePathImpl servicePath;

    @PostMapping(value="/dboard/restart", consumes = "application/json")
    public ResponseEntity restartService(@RequestBody ServicePathRequest servicePathRequest){
        return servicePath.serviceRestart(servicePathRequest);
    }
}
