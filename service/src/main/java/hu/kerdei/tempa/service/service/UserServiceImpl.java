package hu.kerdei.tempa.service.service;

import hu.kerdei.tempa.persistence.model.MeasurementDevice;
import hu.kerdei.tempa.persistence.model.User;
import hu.kerdei.tempa.persistence.repository.MeasurementDeviceRepository;
import hu.kerdei.tempa.persistence.repository.UserRepository;
import hu.kerdei.tempa.service.domain.MeasurementDeviceDto;
import hu.kerdei.tempa.service.domain.UserDto;
import hu.kerdei.tempa.service.exception.MeasurementDeviceNotFoundException;
import hu.kerdei.tempa.service.exception.UserNotFoundException;
import hu.kerdei.tempa.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final MeasurementDeviceRepository measurementDeviceRepository;


    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        Type listType = new TypeToken<List<UserDto>>() {
        }.getType();
        return modelMapper.map(users, listType);
    }


    @Override
    public UserDto getById(Long id) {
        Optional<User> user = userRepository.findById(id);
        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public void removeById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findUserByName(String userName) {

        User userByName = userRepository.findUserByName(userName).orElseThrow(() -> new UserNotFoundException(userName));
        return modelMapper.map(userByName, UserDto.class);
    }

    @Override
    public List<MeasurementDeviceDto> getAllDeviceByUser(String userName) {

        User user = userRepository.findUserByName(userName).orElseThrow(() -> new UserNotFoundException(userName));
        List<MeasurementDevice> measurementDevices = measurementDeviceRepository.findByUser(user).orElseThrow(() -> new MeasurementDeviceNotFoundException(user));

        Type listType = new TypeToken<List<MeasurementDeviceDto>>() {
        }.getType();

        return modelMapper.map(measurementDevices, listType);
    }
}
