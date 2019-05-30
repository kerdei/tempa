package hu.kerdei.tempa.persistence.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "hu.kerdei.tempa.persistence.repository")
@EntityScan(basePackages = "hu.kerdei.tempa.persistence.entity")
@Configuration
@Import(LoadDatabase.class)
public class PersistenceConfiguration {
}
