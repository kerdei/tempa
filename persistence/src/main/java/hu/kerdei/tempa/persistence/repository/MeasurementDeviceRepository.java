package hu.kerdei.tempa.persistence.repository;


import hu.kerdei.tempa.persistence.model.MeasurementDevice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeasurementDeviceRepository extends JpaRepository<MeasurementDevice, Long> {

}
