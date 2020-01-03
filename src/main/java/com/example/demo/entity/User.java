package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name="idUser")
    private int id;
    @Column(name="username")
    private String userName;
    @Column(name="passworld")
    private String passWorld;
    @Column(name="fullname")
    private String fullName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phone;
    @Column(name="roleId")
    private int roleid;
    @Column(name="active")
    private boolean active;
}
