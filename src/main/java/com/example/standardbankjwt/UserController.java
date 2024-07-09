package com.example.standardbankjwt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class responsible for handling user authentication requests.
 * This class uses JWT (JSON Web Token) for authentication purposes.
 *
 * @author Cytrogen
 * @version 1.0
 * @since 2024-07-09
 */
@RestController
public class UserController {

    /**
     * Constructs a new UserController with the specified JWTUtil.
     *
     * @param jwtUtil The JWT utility class used for token generation and parsing.
     */
    public UserController(JWTUtil jwtUtil) {}

    /**
     * Authenticates a user based on the provided credentials.
     * If authentication is successful, a JWT token is generated and returned.
     *
     * @param user The User object containing the username and password for authentication.
     * @return A ResponseEntity containing either the JWT token (if authentication is successful) or an error message (if authentication fails).
     */
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody User user) {
        System.out.println("Received authentication request for user: " + user.getUsername());
        if ("user".equals(user.getUsername()) && "password".equals(user.getPassword())) {
            System.out.println("Authentication successful");
            return ResponseEntity.ok(JWTUtil.genAccessToken(user.getUsername()));
        } else {
            System.out.println("Authentication failed");
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }

}
