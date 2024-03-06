package com.example.jpa.relationship.member;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface MemberService {
    UserDetailsService userDetailsService();
    Member getMemId(String email);
}
