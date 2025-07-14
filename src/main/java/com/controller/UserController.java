package com.controller;

import com.dto.UserDTO;
import com.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping("/me")
  @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
  public UserDTO getMyInfo(@AuthenticationPrincipal UserDetails userDetails) {
    return userService.getUser(userDetails.getUsername());
  }

  @GetMapping("/all")
  @PreAuthorize("hasRole('ADMIN')")
  public List<UserDTO> getAllUsers() {
    return userService.getUsers();
  }

  @PutMapping("/me")
  @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
  public UserDTO updateMyInfo(
      @AuthenticationPrincipal UserDetails userDetails, @RequestBody UserDTO dto) {
    return userService.updateUser(userDetails.getUsername(), dto);
  }

  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public void deleteUser(@PathVariable Integer id) {
    userService.deleteUser(id);
  }
}
