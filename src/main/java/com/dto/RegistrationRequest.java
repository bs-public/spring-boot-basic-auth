package com.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
  private String email;
  private String firstName;
  private String lastName;
  private String password;
}
