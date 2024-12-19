package org.example;
import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.*;
@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private InstructorStatus status;

    // Getters and Setters
}
public enum InstructorStatus {
    PENDING,
    APPROVED,
    REJECTED
}

