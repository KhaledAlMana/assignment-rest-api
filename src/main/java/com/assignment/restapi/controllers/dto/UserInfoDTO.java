package com.assignment.restapi.controllers.dto;

import java.util.Map;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoDTO {
    private String application;
    private Map<String, Object> principal;
}