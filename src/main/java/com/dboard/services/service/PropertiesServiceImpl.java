package com.dboard.services.service;

import com.dboard.services.request.PropertiesRequest;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * Created by Dash on 4/29/2018.
 */
@Service
public class PropertiesServiceImpl {

    Map<String, String> envMap = new HashMap<>();

    @PostConstruct()
    public void environmentsMap(){
        envMap.put("servicename", "D:\\Test\\config\\abc.properties");
    }

    public List<PropertiesRequest> loadProperties(String serviceName){

        List<PropertiesRequest> propertiesList = new ArrayList<>();

        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(envMap.get(serviceName)));

        try {
            Configuration config = builder.getConfiguration();

            loadProperties(config, propertiesList);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }

        return propertiesList;
    }

    public ResponseEntity<List<PropertiesRequest>> updateProperties(String serviceName, List<PropertiesRequest> propertiesRequestList){
        List<PropertiesRequest> propertiesList = new ArrayList<>();

        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(envMap.get(serviceName)));

        try {
            Configuration config = builder.getConfiguration();

            for(PropertiesRequest propRequest: propertiesRequestList) {
                String keyToBeModified = propRequest.getKey();
                config.setProperty(keyToBeModified, propRequest.getValue());
            }
            builder.save();
            loadProperties(builder.getConfiguration(), propertiesList);
        } catch (ConfigurationException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(propertiesList);
    }


    private List<PropertiesRequest> loadProperties(Configuration config,  List<PropertiesRequest> propertiesList){
        for (Iterator<String> it = config.getKeys(); it.hasNext(); ) {
            String key = it.next();
            String value = config.getString(key);

            PropertiesRequest propertiesRequest = new PropertiesRequest();
            propertiesRequest.setKey(key);
            propertiesRequest.setValue(value);
            propertiesList.add(propertiesRequest);
        }
        return propertiesList;
    }
}
