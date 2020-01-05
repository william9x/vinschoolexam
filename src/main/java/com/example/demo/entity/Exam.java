package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="exam")
public class Exam {
    @Id
    @Column(name="idExam")
    private int id;
    @Column(name="examname")
    private String examName;
    @Column(name="createdate")
    private Date createDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name="active")
    private boolean active;
    @Column(name="Time")
    private int time;
    @OneToMany(mappedBy = "exam")
    private List<History> histories;
    @ManyToMany(mappedBy = "examDescription")
    private List<Question>questions;


}
