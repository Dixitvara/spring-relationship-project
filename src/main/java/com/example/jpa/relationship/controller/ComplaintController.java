package com.example.jpa.relationship.controller;

import com.example.jpa.relationship.entity.Complaint;
import com.example.jpa.relationship.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/auth")
public class ComplaintController {

    private ComplaintService complaintService;

    @PostMapping("/complaint")
    public ResponseEntity<String> registerComplaint(@RequestBody Complaint complaint)
    {
        complaintService.saveComplaint(complaint);
        return ResponseEntity.ok("Complaint successfully!");
    }
}
