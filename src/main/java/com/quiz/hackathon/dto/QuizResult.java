package com.quiz.hackathon.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class QuizResult {
    private int score;
    private int totalQuestions;
}
