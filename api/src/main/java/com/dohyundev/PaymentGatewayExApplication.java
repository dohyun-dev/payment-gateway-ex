package com.dohyundev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentGatewayExApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.name", "application,application-core,application-common");
        SpringApplication.run(PaymentGatewayExApplication.class, args);
    }

}
