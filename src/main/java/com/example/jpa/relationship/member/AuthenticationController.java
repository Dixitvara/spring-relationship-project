package com.example.jpa.relationship.member;

import com.example.jpa.relationship.dao.JwtAuthenticationResponse;
import com.example.jpa.relationship.dao.request.Signin;
import com.example.jpa.relationship.dao.request.Signup;
import com.example.jpa.relationship.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody Signup request) {
        return ResponseEntity.ok(authenticationService.signup(request));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody Signin request) {
        return ResponseEntity.ok(authenticationService.signin(request));
    }
}