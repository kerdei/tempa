package hu.kerdei.tempa.application.controller;

import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;
import hu.kerdei.tempa.service.impl.TemperatureMeasurementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "https://tempa-frontend.cfapps.io/")
public class MeasurementController {

    @Autowired
    private
    TemperatureMeasurementServiceImpl measurementService;

    @GetMapping("/measurements")
    List<TemperatureMeasurementDto> getAll() {
        return measurementService.getAll();
    }

    @GetMapping("/measurements/{userName}/yesterday")
    List<TemperatureMeasurementDto> allMeasurementForUserYesterday(@PathVariable(name = "userName") String userName) {
        return measurementService.measurementsByClientUntilYesterday(userName);
    }

    @PostMapping("/measurements/add")
    TemperatureMeasurementDto addMeasurement(@RequestBody TemperatureMeasurementDto temperatureMeasurementDto) {
        return measurementService.add(temperatureMeasurementDto);
    }

}
