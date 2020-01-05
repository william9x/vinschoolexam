package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="role")
public class Role {
    @Id
    @Column(name="idRole")
    private int id;
    @Column(name="name")
    private String name;
    @OneToMany(mappedBy = "role")
    private List<User>  users;
}
