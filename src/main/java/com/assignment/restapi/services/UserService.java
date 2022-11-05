package com.assignment.restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.assignment.restapi.controllers.dto.UserDTO;

@Service
public interface UserService {
    public List<UserDTO> getAllUsers();
}
