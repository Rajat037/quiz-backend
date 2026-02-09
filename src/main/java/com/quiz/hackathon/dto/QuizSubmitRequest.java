package com.quiz.hackathon.dto;

import lombok.Data;
import java.util.Map;

@Data
public class QuizSubmitRequest {
    private Long quizId;

    // questionId -> selectedOption
    private Map<Long, String> answers;
}
