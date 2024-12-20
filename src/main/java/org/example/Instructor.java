package org.example;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;
import java.util.List;

@Entity
public class Instructor {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    String email;


    @Column(nullable = false)
    String password;

    @Enumerated(EnumType.STRING)
    private InstructorStatus status;

    public Instructor(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // Getters and Setters
}

