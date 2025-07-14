package com.service;

import com.dto.RegistrationRequest;
import com.dto.UserDTO;
import com.entity.Role;
import com.entity.User;
import com.mapper.UserMapper;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final UserMapper userMapper;
  private final PasswordEncoder passwordEncoder;

  @Transactional
  public UserDTO registerUser(RegistrationRequest request) {
    userRepository
        .findByEmail(request.getEmail())
        .ifPresent(
            u -> {
              throw new IllegalArgumentException("Email already registered");
            });

    Role userRole =
        roleRepository
            .findByRolename("USER")
            .orElseThrow(() -> new IllegalStateException("USER role not found in DB"));

    User user = new User();
    user.setEmail(request.getEmail());
    user.setFirstName(request.getFirstName());
    user.setLastName(request.getLastName());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole(userRole);

    User saved = userRepository.save(user);
    return userMapper.toDTO(saved);
  }

  public UserDTO getUser(String email) {
    User user =
        userRepository
            .findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    return userMapper.toDTO(user);
  }

  public List<UserDTO> getUsers() {
    return userRepository.findAll().stream().map(userMapper::toDTO).collect(Collectors.toList());
  }

  @Transactional
  public UserDTO updateUser(String email, UserDTO update) {
    User user =
        userRepository
            .findByEmail(email)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

    user.setFirstName(update.getFirstName());
    user.setLastName(update.getLastName());

    User saved = userRepository.save(user);
    return userMapper.toDTO(saved);
  }

  @Transactional
  public void deleteUser(Integer id) {
    if (!userRepository.existsById(id)) {
      throw new IllegalArgumentException("User not found");
    }
    userRepository.deleteById(id);
  }
}
