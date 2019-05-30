package hu.kerdei.tempa.service.interfaces;

import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;

public interface TemperatureMeasurementService extends BaseService<TemperatureMeasurementDto> {

    TemperatureMeasurementDto add(TemperatureMeasurementDto measurementDto);
}
