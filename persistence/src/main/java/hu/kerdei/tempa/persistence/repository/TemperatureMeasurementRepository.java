package hu.kerdei.tempa.persistence.repository;


import hu.kerdei.tempa.persistence.entity.TemperatureMeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureMeasurementRepository extends JpaRepository<TemperatureMeasurementEntity, Long> {

}
