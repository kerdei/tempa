package hu.kerdei.tempa.service.service;

import hu.kerdei.tempa.service.domain.MeasurementDeviceDto;
import hu.kerdei.tempa.service.domain.UserDto;
import hu.kerdei.tempa.service.interfaces.TemperatureMeasurementService;
import hu.kerdei.tempa.service.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManageService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TemperatureMeasurementService temperatureMeasurementService;

    @Autowired
    UserService userService;


    public List<MeasurementDeviceDto> getAllDeviceByUser(String userName) {
        UserDto userByName = userService.findUserByName(userName);
        return userByName.getMeasurementDevices();
    }
}
