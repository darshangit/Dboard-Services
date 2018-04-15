package com.dboard.services.request;

import org.springframework.stereotype.Component;

/**
 * Created by Dash on 4/15/2018.
 */
@Component
public class ServicePathRequest {

    private String serviceName;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
