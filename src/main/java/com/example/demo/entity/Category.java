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
@Table(name="category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idCategory")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="active")
    private boolean active;
    @OneToMany(mappedBy = "category")
    private List<Question> questions;
}
