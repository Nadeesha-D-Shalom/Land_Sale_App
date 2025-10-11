package com.example.Land_Sale_App.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Projects")
@Getter
@Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ProjectName")   // match DB column exactly
    private String projectName;

    @Column(name = "Location")
    private String location;

    @Column(name = "Email")
    private String email;

    @Column(name = "Status")
    private String status;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "EndDate")
    private LocalDate endDate;

    @Column(name = "Budget")
    private Double budget;

    @Column(name = "Description")
    private String description;
}
