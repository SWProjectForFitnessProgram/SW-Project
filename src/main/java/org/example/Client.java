package org.example;

public class Client {

    private Long id;

    //    @Column(nullable = false, unique = true)
    String email;


    //    @Column(nullable = false)
    String password;

    //    @Enumerated(EnumType.STRING)
    private InstructorStatus status;

    public Client(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public Client() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}