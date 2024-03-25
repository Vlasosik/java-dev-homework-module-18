package com.example.entity;

import com.example.entity.enum_role.RoleName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    @Enumerated(EnumType.STRING)
    @JsonIgnore
    private RoleEntity roleName;
    @Column(unique = true)
    private String login;
    private String password;
}

