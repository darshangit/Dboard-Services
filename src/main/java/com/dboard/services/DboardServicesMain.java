package com.dboard.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Dash on 4/15/2018.
 */
@ComponentScan
@EnableAutoConfiguration
public class DboardServicesMain {

    public static void main(String... args) {
        SpringApplication.run(DboardServicesMain.class, args);
    }
}
