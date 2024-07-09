package com.example.standardbankjwt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final JWTUtil jwtUtil;

    public UserController(JWTUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody User user) {
        if ("user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            return ResponseEntity.ok(jwtUtil.generateToken(user.getUsername()));
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }
}
