package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Questions")
public class Question {
    @Id
    @Column(name="idQuestions")
    private int id;
    @Column(name="content")
    private String content;
    @Column(name="active")
    private Boolean active;
    @Column(name="catId")
    private String catId;
    @Column(name="diffId")
    private String diffId;
    @Column(name="classId")
    private String classId;
}

