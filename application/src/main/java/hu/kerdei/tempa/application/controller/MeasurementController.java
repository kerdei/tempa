package hu.kerdei.tempa.application.controller;

import hu.kerdei.tempa.service.domain.MeasurementDto;
import hu.kerdei.tempa.service.interfaces.TemperatureMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MeasurementController {

    @Autowired
    private
    TemperatureMeasurementService measurementService;

    @GetMapping("/measurements")
    List<MeasurementDto> getAll() {
        return measurementService.getAll();
    }

    @GetMapping("/measurements/{userName}/yesterday")
    List<MeasurementDto> allMeasurementForUserYesterday(@PathVariable(name = "userName") String userName) {
        return measurementService.measurementsByClientUntilYesterday(userName, true);
    }

    @PostMapping("/measurements/add")
    MeasurementDto addMeasurement(@RequestBody MeasurementDto measurementDto) {
        return measurementService.add(measurementDto);
    }

}
