package hu.kerdei.tempa.persistence.repository;


import hu.kerdei.tempa.persistence.entity.TemperatureMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TemperatureMeasurementRepository extends JpaRepository<TemperatureMeasurementEntity, Long> {

    @Query("select e from TemperatureMeasurementEntity e where e.userName = :userName and e.date > DATEADD('DAY',-1, CURRENT_DATE)")
    Optional<List<TemperatureMeasurementEntity>> measurementsByClientUntilYesterday(
            @Param("userName") String userName);
}
