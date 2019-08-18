package hu.kerdei.tempa.application.controller;

import hu.kerdei.tempa.service.domain.MeasurementDeviceDto;
import hu.kerdei.tempa.service.domain.MeasurementDto;
import hu.kerdei.tempa.service.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserManageService userManageService;

    @GetMapping("/{userName}")
    List<MeasurementDeviceDto> getAllMeasurementDevicesForUser(Long deviceId) {
        return userManageService.getAllDeviceByUser(deviceId);
    }
}
