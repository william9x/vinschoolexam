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
@Table(name="questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="idQuestions")
    private int id;
    @Column(name="content")
    private String content;
    @Column(name="active")
    private Boolean active;
    @ManyToOne
    @JoinColumn(name = "cat_id")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "diff_id")
    private Difficult difficult;
    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;
    @ManyToMany
    @JoinTable(
            name = "examDescription",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "exam_id"))
    private List<Exam> exams;
    @OneToMany(mappedBy = "question")
    List<QuestionDescription> questionDescriptions;

}

