package hu.kerdei.tempa.persistence.configuration;

import hu.kerdei.tempa.persistence.entity.TemperatureMeasurementEntity;
import hu.kerdei.tempa.persistence.repository.TemperatureMeasurementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(TemperatureMeasurementRepository temperatureMeasurementRepository) {
        return args -> {
            TemperatureMeasurementEntity temperatureMeasurementEntity = new TemperatureMeasurementEntity(1L, 16.5, LocalDate.now(), "kerdei");

            log.info("Preloading " + temperatureMeasurementRepository.save(temperatureMeasurementEntity));
        };
    }
}

