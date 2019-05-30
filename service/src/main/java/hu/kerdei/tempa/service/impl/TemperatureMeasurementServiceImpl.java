package hu.kerdei.tempa.service.impl;

import hu.kerdei.tempa.persistence.entity.TemperatureMeasurementEntity;
import hu.kerdei.tempa.persistence.repository.TemperatureMeasurementRepository;
import hu.kerdei.tempa.service.converter.Converter;
import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;
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

    @Override
    public List<TemperatureMeasurementDto> getAll() {
        ModelMapper modelMapper = Converter.getInstance().modelMapper;
        List<TemperatureMeasurementEntity> measurementEntities = measurementRepository.findAll();
        Type listType = new TypeToken<List<TemperatureMeasurementDto>>() {
        }.getType();
        return modelMapper.map(measurementEntities, listType);
    }

    @Override
    public TemperatureMeasurementDto getById(Long id) {
        ModelMapper modelMapper = Converter.getInstance().modelMapper;
        Optional<TemperatureMeasurementEntity> measurementEntity = measurementRepository.findById(id);
        return modelMapper.map(measurementEntity, TemperatureMeasurementDto.class);

    }

    @Override
    public void removeById(Long id) {
    }

    @Override
    public TemperatureMeasurementDto add(TemperatureMeasurementDto measurementDto) {
        ModelMapper modelMapper = Converter.getInstance().modelMapper;
        TemperatureMeasurementEntity measurementEntity =
                modelMapper.map(measurementDto, TemperatureMeasurementEntity.class);
        TemperatureMeasurementEntity save = measurementRepository.save(measurementEntity);
        
        return modelMapper.map(save, TemperatureMeasurementDto.class);
    }
}
