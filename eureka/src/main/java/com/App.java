package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by sandog on 2018/11/9.
 */
@SpringBootApplication
@EnableEurekaServer
public class App {

    public static void main(String[] args) {
        System.out.println("------------------- start -------------------");
        SpringApplication.run(App.class, args);
        System.out.println("-------------------  end  -------------------");
    }

}
