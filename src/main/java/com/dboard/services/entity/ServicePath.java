package com.dboard.services.entity;

import javax.persistence.*;

/**
 * Created by Dash on 4/15/2018.
 */
@Entity
@Table(name="DBOARD_SERVICE_NAME")
public class ServicePath {

    private Integer uuid;
    private String serviceName;
    private String path;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="SERVICE_UUID")
    public Integer getUuid() {
        return uuid;
    }

    @Column(name="SERVICE_NAME")
    public String getServiceName() {
        return serviceName;
    }

    @Column(name="SERVICE_PATH")
    public String getPath() {
        return path;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
