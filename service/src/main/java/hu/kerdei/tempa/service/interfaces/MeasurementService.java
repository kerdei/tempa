package hu.kerdei.tempa.service.interfaces;

import hu.kerdei.tempa.service.domain.MeasurementDto;

import java.util.List;

public interface MeasurementService extends BaseService<MeasurementDto> {
    MeasurementDto add(MeasurementDto measurementDto);

    List<MeasurementDto> measurementsByDeviceUntilYesterday(Long deviceId, boolean filterSameValues);
}
