package com.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
  private Integer id;
  private String email;
  private String firstName;
  private String lastName;
  private String role;
}
