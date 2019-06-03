package hu.kerdei.tempa.persistence.configuration;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "hu.kerdei.tempa.persistence.repository")
@EntityScan(basePackages = "hu.kerdei.tempa.persistence.entity")
@Configuration
@Import(LoadDatabase.class)
public class PersistenceConfiguration {

    @Bean
    public static PropertyPlaceholderConfigurer properties() {
        PropertyPlaceholderConfigurer ppc
                = new PropertyPlaceholderConfigurer();
        Resource[] resources = new ClassPathResource[]
                {new ClassPathResource("application.properties")};
        ppc.setLocations(resources);
        ppc.setIgnoreUnresolvablePlaceholders(true);
        return ppc;
    }


}
