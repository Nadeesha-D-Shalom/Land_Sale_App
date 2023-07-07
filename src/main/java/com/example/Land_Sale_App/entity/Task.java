package com.example.Land_Sale_App.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "Tasks")
@Getter
@Setter
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TaskName")
    private String taskName;

    @Column(name = "Description")
    private String description;

    @Column(name = "DueDate")
    private LocalDate dueDate;

    @Column(name = "AssignedTo")
    private String assignedTo;

    @Column(name = "Status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "ProjectId")   // foreign key in DB
    private Project project;
}
