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
@Table(name="class")
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idClass")
    private int id;
    @Column(name="classname")
    private String classname;
    @OneToMany(mappedBy = "aClass")
    private List<Question> questionList;
}
