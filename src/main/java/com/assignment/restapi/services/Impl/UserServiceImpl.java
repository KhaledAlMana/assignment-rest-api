package com.assignment.restapi.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.assignment.restapi.services.UserService;
import com.assignment.restapi.controllers.dto.UserDTO;
import com.assignment.restapi.data.Mockup;

@Service
public class UserServiceImpl implements UserService {

    // mockup data
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new Mockup().getAllUsers().stream().map(
                mapper -> UserDTO.builder().id(mapper.getId())
                        .name(mapper.getName()).email(mapper.getEmail()).gender(mapper.getGender())
                        .status(mapper.isStatus()).build())
                .collect(Collectors.toList());
        return users;
    }
}
