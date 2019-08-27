package hu.kerdei.tempa.application.tempa.persistence;

import hu.kerdei.tempa.persistence.configuration.PersistenceConfiguration;
import hu.kerdei.tempa.persistence.model.Measurement;
import hu.kerdei.tempa.persistence.model.MeasurementDevice;
import hu.kerdei.tempa.persistence.model.User;
import hu.kerdei.tempa.persistence.repository.MeasurementRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@DataJpaTest
@ContextConfiguration(classes = PersistenceConfiguration.class)
@RunWith(SpringRunner.class)
public class PersistenceApplicationTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    MeasurementRepository measurementRepository;

    @Before
    public void resetDB() {
        measurementRepository.deleteAll();
    }

    @Test
    public void lastDayMeasurementsByClient() {
        //Given
        List<Measurement> lastDayMeasurements = new ArrayList<>();
        List<Measurement> unwantedMeasurements = new ArrayList<>();
        LocalDateTime lastDay = LocalDateTime.now().minusDays(1);

        User correctUser = new User("Name", "Test", "testName");
        User notCorrectUser = new User("Not", "the", "one!");
        entityManager.persist(correctUser);
        entityManager.persist(notCorrectUser);


        MeasurementDevice measurementDevice = new MeasurementDevice(5L, "Bedroom", correctUser);
        MeasurementDevice notCorrectMeasurementDevice = new MeasurementDevice(6L, "Bedroom", notCorrectUser);

        entityManager.persist(measurementDevice);
        entityManager.persist(notCorrectMeasurementDevice);
        for (int i = 0; i < 16; i++) {
            lastDay = lastDay.plusHours(1);
            Measurement lastDayMeasurement = new Measurement(16.5, lastDay, measurementDevice);

            lastDayMeasurements.add(lastDayMeasurement);
            entityManager.persist(lastDayMeasurement);
        }
        LocalDateTime oldDate = lastDay.minusMonths(1);

        for (int i = 0; i < 16; i++) {
            oldDate = oldDate.plusHours(1);
            Measurement oldMeasurement =
                    new Measurement(16.5, oldDate, measurementDevice);
            unwantedMeasurements.add(oldMeasurement);
            entityManager.persist(oldMeasurement);
        }
        lastDay = LocalDateTime.now().minusDays(1);
        for (int i = 0; i < 16; i++) {
            lastDay = lastDay.plusHours(1);
            Measurement lastDayMeasurementWithDifferentUser =
                    new Measurement(16.5, lastDay, notCorrectMeasurementDevice);
            unwantedMeasurements.add(lastDayMeasurementWithDifferentUser);
            entityManager.persist(lastDayMeasurementWithDifferentUser);
        }

        List<Measurement> allMeasurement = measurementRepository.findAll();
        assertEquals(48, allMeasurement.size());

        List<Measurement> actualLastDayMeasurements =
                measurementRepository.lastDayMeasurementsByDeviceId(measurementDevice.getId()).orElseThrow(NullPointerException::new);
        assertEquals(lastDayMeasurements, actualLastDayMeasurements);

        for (Measurement unwantedMeasurement : unwantedMeasurements) {
            assertFalse(actualLastDayMeasurements.contains(unwantedMeasurement));
        }

    }

}
