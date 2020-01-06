package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="questionDescription")
public class QuestionDescription implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;
    @Id
    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @Column(name = "correct")
    private boolean correct;

    @Column(name = "description")
    private String description;
}
