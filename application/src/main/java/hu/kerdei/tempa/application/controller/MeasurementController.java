package hu.kerdei.tempa.application.controller;

import hu.kerdei.tempa.service.domain.TemperatureMeasurementDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MeasurementController {

   // @Autowired
   // TemperatureMeasurementServiceImpl measurementService;

    @RequestMapping("/")
    public @ResponseBody
    String greeting() {
        return "Hello World";
    }

    @GetMapping("/measurements")
    List<TemperatureMeasurementDto> getAll() {
   //     return measurementService.getAll();
        return null;
    }

    @PostMapping("/measurements/add")
    TemperatureMeasurementDto addMeasurement(@RequestBody TemperatureMeasurementDto temperatureMeasurementDto) {
   //     return measurementService.add(temperatureMeasurementDto);
        return null;
    }

}
