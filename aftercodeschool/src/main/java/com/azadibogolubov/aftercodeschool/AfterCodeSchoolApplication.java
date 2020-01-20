package com.azadibogolubov.aftercodeschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.azadibogolubov.aftercodeschool.repository"})
public class AfterCodeSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfterCodeSchoolApplication.class, args);
    }

}
