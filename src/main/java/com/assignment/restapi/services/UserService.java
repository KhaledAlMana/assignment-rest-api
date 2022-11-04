package com.assignment.restapi.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public List<Object> getAllUsers();
}
