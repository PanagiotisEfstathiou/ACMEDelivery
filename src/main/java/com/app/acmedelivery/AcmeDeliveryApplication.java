package com.app.acmedelivery;

import com.app.acmedelivery.base.BaseComponent;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;


@SpringBootApplication
@EnableJpaRepositories
public class AcmeDeliveryApplication extends BaseComponent {

    public static void main(String[] args) {
        SpringApplication.run(AcmeDeliveryApplication.class, args);
    }

}
