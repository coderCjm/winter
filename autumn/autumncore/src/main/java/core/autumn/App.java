package core.autumn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by sandog on 2018/11/9.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableHystrix
public class App {

    public static void main(String[] args) {
        System.out.println("------------------- start -------------------");
        SpringApplication.run(App.class, args);
        System.out.println("-------------------  end  -------------------");
    }

}
