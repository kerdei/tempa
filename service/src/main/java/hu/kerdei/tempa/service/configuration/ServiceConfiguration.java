package hu.kerdei.tempa.service.configuration;

import hu.kerdei.tempa.persistence.configuration.PersistenceConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(PersistenceConfiguration.class)
@ComponentScan(basePackages = {"hu.kerdei.measurement.service"})
public class ServiceConfiguration {



}
