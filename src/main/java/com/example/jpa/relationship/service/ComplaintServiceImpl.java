package com.example.jpa.relationship.service;

import com.example.jpa.relationship.entity.Complaint;
import com.example.jpa.relationship.jwt.JwtService;
import com.example.jpa.relationship.member.Member;
import com.example.jpa.relationship.member.MemberRepo;
import com.example.jpa.relationship.member.MemberService;
import com.example.jpa.relationship.repository.ComplaintRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@AllArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {

    private ComplaintRepo complaintRepo;
    private MemberRepo memberRepo;
    @Override
    public Complaint saveComplaint(Complaint complaint) {
        System.out.println(complaint);
        return complaintRepo.save(complaint);
    }
}