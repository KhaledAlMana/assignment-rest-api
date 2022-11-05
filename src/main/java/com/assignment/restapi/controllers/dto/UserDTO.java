package com.assignment.restapi.controllers.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
@ToString
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String gender;
    private boolean status;
}
