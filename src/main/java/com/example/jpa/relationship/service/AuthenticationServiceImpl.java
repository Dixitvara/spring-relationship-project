package com.example.jpa.relationship.service;

import com.example.jpa.relationship.dao.JwtAuthenticationResponse;
import com.example.jpa.relationship.dao.request.Signin;
import com.example.jpa.relationship.dao.request.Signup;
import com.example.jpa.relationship.jwt.JwtService;
import com.example.jpa.relationship.member.Member;
import com.example.jpa.relationship.member.MemberRepo;
import com.example.jpa.relationship.member.Role;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private MemberRepo memberRepo;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;
    @Override
    public JwtAuthenticationResponse signup(Signup request) {
        var member = Member.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .flat(request.getFlat())
                .wing(request.getWing())
                .mobile(request.getMobile())
                .role(Role.USER).build();
        memberRepo.save(member);
        var jwt = jwtService.generateToken(member);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(Signin request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var member = memberRepo.findByEmail(request.getEmail()).orElseThrow(() -> new IllegalArgumentException("Invalid Credentials!"));
        var jwt = jwtService.generateToken(member);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }
}
