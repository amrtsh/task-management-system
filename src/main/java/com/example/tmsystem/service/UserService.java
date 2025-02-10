package com.example.tmsystem.service;

import com.example.tmsystem.dto.UserAuthDto;
import com.example.tmsystem.dto.UserDto;
import com.example.tmsystem.model.User;
import com.example.tmsystem.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.List;

import static com.example.tmsystem.mapper.Mapper.toDomain;
import static com.example.tmsystem.mapper.Mapper.toDto;

@Service
@ApplicationScope
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDto createUser(UserAuthDto userAuthDto) {
        User user = toDomain(userAuthDto);
        User savedUser = userRepository.save(user);
        UserDto userDto = toDto(savedUser);
        return userDto;

    }

    public UserDto updateUser(UserDto userDto) {
        User user = toDomain(userDto);
        return toDto(userRepository.save(user));
    }

    public List<UserDto> getAllUsers() {
        List<UserDto> userDtoList = userRepository.findAll()
                .stream()
                .map(i -> toDto(i))
                .toList();
        return userDtoList;
    }

    public UserDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return toDto(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }


}
