package hu.kerdei.tempa.application.configuraton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@Import(ServiceConfiguration.class) //TODO
@ComponentScan(basePackages = {
        "hu.kerdei.tempa.application.controller"})
public class TempaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TempaApplication.class, args);
    }

}
