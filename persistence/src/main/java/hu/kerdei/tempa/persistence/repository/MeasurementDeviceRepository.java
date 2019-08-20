package hu.kerdei.tempa.persistence.repository;


import hu.kerdei.tempa.persistence.model.MeasurementDevice;
import hu.kerdei.tempa.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MeasurementDeviceRepository extends JpaRepository<MeasurementDevice, Long> {

    Optional<List<MeasurementDevice>> findByUser(User user);
}
