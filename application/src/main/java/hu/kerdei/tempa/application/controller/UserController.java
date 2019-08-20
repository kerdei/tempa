package hu.kerdei.tempa.application.controller;

import hu.kerdei.tempa.service.domain.MeasurementDeviceDto;
import hu.kerdei.tempa.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class UserController {
    
    private UserService userService;

    @GetMapping("/{userName}/devices")
    List<MeasurementDeviceDto> getAllMeasurementDevicesForUser(@PathVariable(name = "userName") String userName) {
        return userService.getAllDeviceByUser(userName);
    }
}
