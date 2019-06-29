package hu.kerdei.tempa.service.impl;

import hu.kerdei.tempa.persistence.entity.TemperatureMeasurementEntity;
import hu.kerdei.tempa.persistence.repository.TemperatureMeasurementRepository;
import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;
import hu.kerdei.tempa.service.exception.MeasurementNotFoundException;
import hu.kerdei.tempa.service.interfaces.TemperatureMeasurementService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@Service
public class TemperatureMeasurementServiceImpl implements TemperatureMeasurementService {

    @Autowired
    TemperatureMeasurementRepository measurementRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<TemperatureMeasurementDto> getAll() {
        List<TemperatureMeasurementEntity> measurementEntities = measurementRepository.findAll();
        Type listType = new TypeToken<List<TemperatureMeasurementDto>>() {
        }.getType();
        return modelMapper.map(measurementEntities, listType);
    }

    @Override
    public TemperatureMeasurementDto getById(Long id) {
        Optional<TemperatureMeasurementEntity> measurementEntity = measurementRepository.findById(id);
        return modelMapper.map(measurementEntity, TemperatureMeasurementDto.class);

    }

    @Override
    public void removeById(Long id) {
    }

    @Override
    public TemperatureMeasurementDto add(TemperatureMeasurementDto measurementDto) {
        TemperatureMeasurementEntity measurementEntity =
                modelMapper.map(measurementDto, TemperatureMeasurementEntity.class);
        TemperatureMeasurementEntity save = measurementRepository.save(measurementEntity);
        return modelMapper.map(save, TemperatureMeasurementDto.class);
    }

    @Override
    public List<TemperatureMeasurementDto> measurementsByClientUntilYesterday(String userName) {
        List<TemperatureMeasurementEntity> measurementEntities = measurementRepository.measurementsByClientUntilYesterday(userName).
                orElseThrow(() -> new MeasurementNotFoundException(userName));

        if (measurementEntities.size() > 1) {
            for (int i = 1; i < measurementEntities.size(); i++) {
                if (measurementEntities.get(i - 1).getValue().equals(measurementEntities.get(i).getValue())) {
                    measurementEntities.remove(measurementEntities.get(i-1));
                    i--;
                }
            }
        }

        Type listType = new TypeToken<List<TemperatureMeasurementDto>>() {
        }.getType();

        return modelMapper.map(measurementEntities, listType);
    }
}
