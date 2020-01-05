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
@Table(name="answer")
public class Answer {
    @Id
    @Column(name="idAnswer")
    private int id;
    @Column(name="content")
    private String content;
    @OneToMany(mappedBy = "answer")
    private List<QuestionDescription> questionDescriptions;
}
