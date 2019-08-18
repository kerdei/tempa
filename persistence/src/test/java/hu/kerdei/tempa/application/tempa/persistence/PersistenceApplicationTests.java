package hu.kerdei.tempa.application.tempa.persistence;

import hu.kerdei.tempa.persistence.configuration.PersistenceConfiguration;
import hu.kerdei.tempa.persistence.model.Measurement;
import hu.kerdei.tempa.persistence.repository.MeasurementRepository;
import org.junit.Before;
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


    public void lastDayMeasurementsByClient() {
        //Given
        List<Measurement> lastDayMeasurements = new ArrayList<>();
        List<Measurement> unwantedMeasurements = new ArrayList<>();
        LocalDateTime lastDay = LocalDateTime.now().minusDays(1);
        String userName = "testUser";

        /*for (int i = 0; i < 16; i++) {
            lastDay = lastDay.plusHours(1);
            Measurement lastDayMeasurement =
                    new Measurement(1L, 16.5, lastDay, userName);
            lastDayMeasurements.add(lastDayMeasurement);
            entityManager.persist(lastDayMeasurement);
            entityManager.flush();
        }
        LocalDateTime oldDate = lastDay.minusMonths(1);

        for (int i = 0; i < 16; i++) {
            oldDate = oldDate.plusHours(1);
            Measurement oldMeasurement =
                    new Measurement(1L, 16.5, oldDate, userName);
            unwantedMeasurements.add(oldMeasurement);
            entityManager.persist(oldMeasurement);
            entityManager.flush();
        }
        lastDay = LocalDateTime.now().minusDays(1);
        for (int i = 0; i < 16; i++) {
            lastDay = lastDay.plusHours(1);
            Measurement lastDayMeasurementWithDifferentUser =
                    new Measurement(1L, 16.5, lastDay, "otherUser");
            unwantedMeasurements.add(lastDayMeasurementWithDifferentUser);
            entityManager.persist(lastDayMeasurementWithDifferentUser);
            entityManager.flush();
        }
        */
      /*  List<Measurement> allMeasurement = measurementRepository.findAll();
        assertEquals(48, allMeasurement.size());
        List<Measurement> actualLastDayMeasurements = measurementRepository.lastDayMeasurementsByClient(userName).orElseThrow(NullPointerException::new);
        assertEquals(lastDayMeasurements, actualLastDayMeasurements);

        for (Measurement unwantedMeasurement : unwantedMeasurements) {
            assertFalse(actualLastDayMeasurements.contains(unwantedMeasurement));
        }
*/
    }

}
