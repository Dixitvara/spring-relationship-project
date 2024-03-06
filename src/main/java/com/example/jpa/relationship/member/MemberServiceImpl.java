package com.example.jpa.relationship.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MemberServiceImpl implements MemberService{
    @Autowired
    MemberRepo memberRepo;

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
                return memberRepo.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
            }
        };
    }

    @Override
    public Member getMemId(String email)
    {
        return memberRepo.findByEmail(email).orElseThrow(() -> new RuntimeException());
    }
}
