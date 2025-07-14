package com.controller;

import com.dto.RegistrationRequest;
import com.dto.UserDTO;
import com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<UserDTO> register(@RequestBody RegistrationRequest request) {
    UserDTO savedUser = userService.registerUser(request);
    return ResponseEntity.ok(savedUser);
  }
}
