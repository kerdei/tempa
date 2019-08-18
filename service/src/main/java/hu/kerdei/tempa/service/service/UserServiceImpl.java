package hu.kerdei.tempa.service.service;

import hu.kerdei.tempa.persistence.model.Measurement;
import hu.kerdei.tempa.persistence.model.User;
import hu.kerdei.tempa.persistence.repository.UserRepository;
import hu.kerdei.tempa.service.domain.MeasurementDto;
import hu.kerdei.tempa.service.domain.UserDto;
import hu.kerdei.tempa.service.interfaces.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepository userRepository;


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
        Optional<User> userByName = userRepository.findUserByName(userName);
        return modelMapper.map(userByName, UserDto.class);
    }
}
