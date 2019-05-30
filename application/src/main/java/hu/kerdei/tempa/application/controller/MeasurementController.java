package hu.kerdei.tempa.application.controller;

import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;
import hu.kerdei.tempa.service.impl.TemperatureMeasurementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeasurementController {

    @Autowired
    TemperatureMeasurementServiceImpl measurementService;


    @GetMapping("/measurements")
    List<TemperatureMeasurementDto> getAll() {
        return measurementService.getAll();
    }

    @PostMapping("/measurements/add")
    TemperatureMeasurementDto addMeasurement(@RequestBody TemperatureMeasurementDto temperatureMeasurementDto) {
        return measurementService.add(temperatureMeasurementDto);
    }


}
