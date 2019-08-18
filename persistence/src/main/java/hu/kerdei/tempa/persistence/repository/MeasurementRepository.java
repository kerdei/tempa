package hu.kerdei.tempa.persistence.repository;


import hu.kerdei.tempa.persistence.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    //  @Query("select e from Measurement e where e.user.firstName = :userName and e.date > DATEADD('DAY',-1, CURRENT_DATE)")
    //   Optional<List<Measurement>> lastDayMeasurementsByClient(
    //          @Param("userName") String userName);
}
