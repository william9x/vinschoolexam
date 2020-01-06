package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;
    @Column(name="active")
    private boolean active;
    @Column(name="point")
    private int point;
    @OneToMany(mappedBy = "user")
    private List<Exam> exams;
    @OneToMany (mappedBy = "user")
    private List<History> histories;
}
