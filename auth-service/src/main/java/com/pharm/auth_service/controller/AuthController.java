package com.pharm.auth_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pharm.auth_service.dto.LoginRequest;
import com.pharm.auth_service.dto.RegisterRequest;
import com.pharm.auth_service.model.User;
import com.pharm.auth_service.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request){
        
        User user = User.builder()
            .username(request.getUsername())
            .password(request.getPassword())
            .build();

        return ResponseEntity.ok(userRepository.save(user));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest req){

        User user = userRepository.findByUsername(req.getUsername())
            .orElseThrow(() -> new RuntimeException("User not Found"));

        if (!user.getPassword().equals(req.getPassword())) {
            return ResponseEntity.status(401).body("Invalid Credentials");
        }

        return ResponseEntity.ok("dummy-token-for-" + user.getUsername());
    }
    
}
