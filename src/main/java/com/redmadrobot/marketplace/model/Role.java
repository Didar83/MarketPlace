package com.redmadrobot.marketplace.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "role_name", unique = true)
    private String roleName;

    public Role(String roleName) {
        this.roleName = roleName;
    }
}
