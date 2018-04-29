package com.dboard.services.controller;

import com.dboard.services.request.PropertiesRequest;
import com.dboard.services.request.ServicePathRequest;
import com.dboard.services.service.PropertiesServiceImpl;
import com.dboard.services.service.ServicePathImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Dash on 4/15/2018.
 */
@RestController
@CrossOrigin("*")
public class DboardController {

    @Autowired
    private ServicePathImpl servicePath;

    @Autowired
    private PropertiesServiceImpl propertiesService;

    @PostMapping(value="/dboard/restart", consumes = "application/json")
    public ResponseEntity restartService(@RequestBody ServicePathRequest servicePathRequest){
        return servicePath.serviceRestart(servicePathRequest);
    }

    @GetMapping(value="/loadPoperties/{serviceName}")
    public List<PropertiesRequest> loadProperties(@PathVariable("serviceName") String serviceName ){
        return propertiesService.loadProperties(serviceName);
    }

    @PostMapping(value="/updateProperties/{serviceName}", consumes = "application/json")
    public ResponseEntity updateProperties(@RequestBody List<PropertiesRequest>  propertiesRequestList, @PathVariable("serviceName") String serviceName ){
        return propertiesService.updateProperties(serviceName,propertiesRequestList);
    }
}
