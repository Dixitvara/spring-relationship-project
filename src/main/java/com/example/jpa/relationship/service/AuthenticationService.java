package com.example.jpa.relationship.service;

import com.example.jpa.relationship.dao.JwtAuthenticationResponse;
import com.example.jpa.relationship.dao.request.Signin;
import com.example.jpa.relationship.dao.request.Signup;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(Signup request);
    JwtAuthenticationResponse signin(Signin request);
}
