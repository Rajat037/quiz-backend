package com.quiz.hackathon.controller;

import com.quiz.hackathon.dto.QuizResult;
import com.quiz.hackathon.dto.QuizSubmitRequest;
import com.quiz.hackathon.model.Question;
import com.quiz.hackathon.model.Quiz;
import com.quiz.hackathon.repository.QuestionRepository;
import com.quiz.hackathon.repository.QuizRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@CrossOrigin(origins = "*")
public class QuizController {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizController(QuizRepository quizRepository,
            QuestionRepository questionRepository) {
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    // Create quiz
    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizRepository.save(quiz);
    }

    // Get all quizzes
    @GetMapping
    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Submit quiz & calculate score
    @PostMapping("/{quizId}/submit")
    public QuizResult submitQuiz(
            @PathVariable Long quizId,
            @RequestBody QuizSubmitRequest request) {
        int score = 0;

        List<Question> questions = questionRepository.findByQuizId(quizId);

        for (Question q : questions) {
            String submitted = request.getAnswers().get(q.getId());
            if (q.getCorrectOption().equalsIgnoreCase(submitted)) {
                score++;
            }
        }

        return new QuizResult(score, questions.size());
    }
}
