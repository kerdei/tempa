package hu.kerdei.tempa.application.configuraton;

import hu.kerdei.tempa.service.configuration.ServiceConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration
@Import(ServiceConfiguration.class)
@ComponentScan(basePackages = {
        "hu.kerdei.tempa.application.controller"})
public class TempaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempaApplication.class, args);
    }

}
