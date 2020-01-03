package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Exam")
public class Exam {
    @Id
    @Column(name="idExam")
    private int id;
    @Column(name="examname")
    private String examName;
    @Column(name="createdate")
    private Date createDate;
    @Column(name="userCrateted")
    private int userCrateted;
    @Column(name="active")
    private boolean active;
    @Column(name="Time")
    private int time;
}
