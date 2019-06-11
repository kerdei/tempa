package hu.kerdei.tempa.application.controller;

import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;
import hu.kerdei.tempa.service.impl.TemperatureMeasurementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
