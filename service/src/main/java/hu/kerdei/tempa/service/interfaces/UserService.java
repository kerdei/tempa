package hu.kerdei.tempa.service.interfaces;

import hu.kerdei.tempa.service.domain.MeasurementDeviceDto;
import hu.kerdei.tempa.service.domain.UserDto;

import java.util.List;

public interface UserService extends BaseService<UserDto> {
    UserDto findUserByName(String userName);

    List<MeasurementDeviceDto> getAllDeviceByUser(String userName);
}
