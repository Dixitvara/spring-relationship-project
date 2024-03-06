package com.example.jpa.relationship.entity;

import com.example.jpa.relationship.member.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Complaint {

    @Id
    @Column(name = "compid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long compId;

    private String title;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_mem_id")
    private Member mem_id;
}