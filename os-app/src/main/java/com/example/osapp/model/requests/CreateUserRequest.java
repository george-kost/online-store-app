package com.example.osapp.model.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateUserRequest {

    @JsonProperty
    private String username;

    @JsonProperty
    private String password;

    @JsonProperty
    private String confirmPassword;
}



//{"username" : "panos", "password": 12345, "confirmPassord": "12345"}