package com.assignment.restapi.services;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PostService {
    public List<Object> getAllPosts();
}
