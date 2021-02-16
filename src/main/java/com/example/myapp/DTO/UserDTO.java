package com.example.myapp.DTO;

import com.example.myapp.Entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
private User user;
private String errorMessage;
}
