package com.assignment.restapi.services;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    public List<Object> getAllComments();
}
