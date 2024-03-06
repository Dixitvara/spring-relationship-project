package com.example.jpa.relationship.repository;

import com.example.jpa.relationship.entity.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplaintRepo extends JpaRepository<Complaint, Long> {

}
