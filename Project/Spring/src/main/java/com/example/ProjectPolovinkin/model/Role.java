package com.example.ProjectPolovinkin.model;

import com.example.ProjectPolovinkin.model.ERole;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(ERole name) {
        this.name = name;
    }

    public ERole getName() {
        return name;
    }

    public Role(ERole name) {
        this.name = name;
    }
}
