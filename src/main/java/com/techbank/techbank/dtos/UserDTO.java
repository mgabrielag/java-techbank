package com.techbank.techbank.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.techbank.techbank.domain.user.User;
import com.techbank.techbank.domain.user.UserType;
import lombok.Data;

import java.math.BigDecimal;


public record UserDTO(@JsonProperty(access = JsonProperty.Access.READ_ONLY) Long userId,
                      String firstName,
                      String lastName,
                      String document,
                      String email,
                      UserType userType,
                      BigDecimal amount) {

    public UserDTO(User user) {
        this(user.getUserId(), user.getFirstName(), user.getLastName(), user.getDocument(), user.getEmail(), user.getUserType(),user.getAmount());
    }
}
