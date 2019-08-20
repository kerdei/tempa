package hu.kerdei.tempa.service.service;

import hu.kerdei.tempa.persistence.model.Measurement;
import hu.kerdei.tempa.persistence.repository.MeasurementRepository;
import hu.kerdei.tempa.service.domain.MeasurementDto;
import hu.kerdei.tempa.service.exception.MeasurementNotFoundException;
import hu.kerdei.tempa.service.interfaces.MeasurementService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MeasurementServiceImpl implements MeasurementService {

    private MeasurementRepository measurementRepository;
    private ModelMapper modelMapper;

    @Override
    public List<MeasurementDto> getAll() {
        List<Measurement> measurementEntities = measurementRepository.findAll();
        Type listType = new TypeToken<List<MeasurementDto>>() {
        }.getType();
        return modelMapper.map(measurementEntities, listType);
    }

    @Override
    public MeasurementDto getById(Long id) {
        Optional<Measurement> measurementEntity = measurementRepository.findById(id);
        return modelMapper.map(measurementEntity, MeasurementDto.class);
    }

    @Override
    public void removeById(Long id) {
        measurementRepository.deleteById(id);
    }

    @Override
    public MeasurementDto add(MeasurementDto measurementDto) {
        Measurement measurementEntity =
                modelMapper.map(measurementDto, Measurement.class);
        Measurement save = measurementRepository.save(measurementEntity);
        return modelMapper.map(save, MeasurementDto.class);
    }

    @Override
    public List<MeasurementDto> measurementsByDeviceUntilYesterday(Long deviceId, boolean filterSameValues) {
        List<Measurement> measurementEntities = measurementRepository.lastDayMeasurementsByDeviceId(deviceId).
                orElseThrow(() -> new MeasurementNotFoundException(deviceId));

        if (filterSameValues) {
            filterSameValues(measurementEntities);
        }

        Type listType = new TypeToken<List<MeasurementDto>>() {
        }.getType();

        return modelMapper.map(measurementEntities, listType);
    }

    private void filterSameValues(List<Measurement> measurementEntities) {
        if (measurementEntities.size() > 1) {
            for (int i = 1; i < measurementEntities.size(); i++) {
                if (measurementEntities.get(i - 1).getValue().equals(measurementEntities.get(i).getValue())) {
                    measurementEntities.remove(measurementEntities.get(i - 1));
                    i--;
                }
            }
        }
    }
}
