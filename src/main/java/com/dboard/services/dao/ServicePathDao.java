package com.dboard.services.dao;

import com.dboard.services.entity.ServicePath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Dash on 4/15/2018.
 */
@Repository
public interface ServicePathDao extends JpaRepository<ServicePath, Integer>{

    ServicePath findByServiceNameEquals(String serviceName);
}
