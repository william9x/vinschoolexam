package com.example.demo.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private int id;
    private String content;
    private String answer;
    private String description;
    private boolean active;
    private String category;
    private String diff;
    private String className;

}
