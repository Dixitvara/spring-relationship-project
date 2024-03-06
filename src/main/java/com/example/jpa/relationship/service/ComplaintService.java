package com.example.jpa.relationship.service;

import com.example.jpa.relationship.entity.Complaint;
import org.springframework.http.ResponseEntity;

public interface ComplaintService {
    Complaint saveComplaint(Complaint complaint);

}