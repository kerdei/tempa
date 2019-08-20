package hu.kerdei.tempa.application.controller;

import hu.kerdei.tempa.service.domain.MeasurementDto;
import hu.kerdei.tempa.service.interfaces.MeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class MeasurementController {

    @Autowired
    private
    MeasurementService measurementService;

    @GetMapping("/measurements")
    List<MeasurementDto> getAll() {
        return measurementService.getAll();
    }

    @GetMapping("/measurements/{deviceId}/yesterday")
    List<MeasurementDto> allMeasurementForUserYesterday(@PathVariable(name = "deviceId") Long deviceId) {
        return measurementService.measurementsByDeviceUntilYesterday(deviceId, true);
    }

    @PostMapping("/measurements/add")
    MeasurementDto addMeasurement(@RequestBody MeasurementDto measurementDto) {
        return measurementService.add(measurementDto);
    }

}
