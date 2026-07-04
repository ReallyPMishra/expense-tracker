package com.logicoy.expense_tracker.service;

import com.logicoy.expense_tracker.dto.LoginRequestDto;
import com.logicoy.expense_tracker.dto.LoginResponseDto;
import com.logicoy.expense_tracker.dto.RegisterRequestDto;
import com.logicoy.expense_tracker.entity.Role;
import com.logicoy.expense_tracker.entity.User;
import com.logicoy.expense_tracker.repository.UserRepository;
import com.logicoy.expense_tracker.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String register(RegisterRequestDto request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exists");
        }

        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setRole(Role.ROLE_USER);

        userRepository.save(user);

        return "User Registered Successfully";
    }

    public LoginResponseDto login(LoginRequestDto request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword())) {

            throw new RuntimeException("Invalid Password");
        }

        String token = jwtUtil.generateToken(
                user.getEmail());

        return new LoginResponseDto(token);
    }
}