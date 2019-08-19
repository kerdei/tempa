package hu.kerdei.tempa.persistence.configuration;

import hu.kerdei.tempa.persistence.model.Measurement;
import hu.kerdei.tempa.persistence.model.MeasurementDevice;
import hu.kerdei.tempa.persistence.model.User;
import hu.kerdei.tempa.persistence.repository.MeasurementDeviceRepository;
import hu.kerdei.tempa.persistence.repository.MeasurementRepository;
import hu.kerdei.tempa.persistence.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.*;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(MeasurementRepository measurementRepository, UserRepository userRepository, MeasurementDeviceRepository measurementDeviceRepository) {
        return args -> {

            Measurement measurement = new Measurement(1L, 25.5, LocalDateTime.now());

            log.info("Preloading " + measurementRepository.save(measurement));

            MeasurementDevice measurementDevice = new MeasurementDevice(1L, 1L, "Outdoor", List.of(measurement));
            log.info("Preloading " + measurementDeviceRepository.save(measurementDevice));

            User user = new User(1L, "Krisztián", "Erdei", "kerdei", List.of(measurementDevice));


            log.info("Preloading " + userRepository.save(user));


        };
    }
}

