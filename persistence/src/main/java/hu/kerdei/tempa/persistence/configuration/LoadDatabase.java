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

            User user1 = new User("John", "Smith", "smithy");
            User user2 = new User("Robert", "Johnson", "jonyr");
            log.info("Preloading " + userRepository.saveAndFlush(user1));
            log.info("Preloading " + userRepository.saveAndFlush(user2));
            MeasurementDevice outdoorDevice = new MeasurementDevice(1L, "Outdoor", user1);
            MeasurementDevice bedroomDevice = new MeasurementDevice(2L, "Bedroom", user1);

            MeasurementDevice anotherDevice = new MeasurementDevice(3L, "Test", user2);

            log.info("Preloading " + measurementDeviceRepository.saveAndFlush(anotherDevice));
            log.info("Preloading " + measurementDeviceRepository.saveAndFlush(bedroomDevice));
            log.info("Preloading " + measurementDeviceRepository.saveAndFlush(outdoorDevice));

            LocalDateTime time = LocalDateTime.of(2019, 8, 20, 17, 30);
            for (int i = 0; i < 512; i++) {
                Measurement measurement = new Measurement(25.5 + Math.random() * 6 - 3, time.plusMinutes(i), outdoorDevice);
                log.info("Preloading " + measurementRepository.saveAndFlush(measurement));
            }

            for (int i = 0; i < 128; i++) {
                Measurement measurement = new Measurement(21.0 + + Math.random() * 6 - 3, time.plusMinutes(i), bedroomDevice);
                log.info("Preloading " + measurementRepository.save(measurement));
            }

            for (int i = 0; i < 16; i++) {
                Measurement measurement = new Measurement(26.7 + + Math.random() * 6 - 3, time.plusMinutes(i), anotherDevice);
                log.info("Preloading " + measurementRepository.save(measurement));
            }
        };
    }
}

