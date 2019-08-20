package hu.kerdei.tempa.persistence.repository;


import hu.kerdei.tempa.persistence.model.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    @Query("select me " +
            "from measurements me join me.measurementDevice md on me.measurementDevice = md.id " +
            "join md.user u on md.user = u.id " +
            "where md.id=:deviceId and me.date > DATEADD('DAY',-1, CURRENT_DATE)")
    Optional<List<Measurement>> lastDayMeasurementsByDeviceId(
            @Param("deviceId") Long deviceId);

}
