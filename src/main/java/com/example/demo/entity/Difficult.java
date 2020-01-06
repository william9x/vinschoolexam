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
@Table(name="difficult")
public class Difficult {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDifficult")
    private int id;
    @Column(name="level")
    private String level;
    @OneToMany(mappedBy = "difficult")
    private List<Question> questions;
}
