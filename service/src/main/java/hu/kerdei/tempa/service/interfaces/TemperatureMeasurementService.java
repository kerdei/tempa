package hu.kerdei.tempa.service.interfaces;

import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;

import java.util.List;

public interface TemperatureMeasurementService extends BaseService<TemperatureMeasurementDto> {

    TemperatureMeasurementDto add(TemperatureMeasurementDto measurementDto);

    List<TemperatureMeasurementDto> measurementsByClientUntilYesterday(String userName);
}
