package hu.kerdei.tempa.service.interfaces;

import hu.kerdei.tempa.service.domain.MeasurementDto;

import java.util.List;

public interface TemperatureMeasurementService extends BaseService<MeasurementDto> {
    MeasurementDto add(MeasurementDto measurementDto);

    List<MeasurementDto> measurementsByClientUntilYesterday(String userName, boolean filterSameValues);
}
