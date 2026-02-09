package com.quiz.hackathon.repository;

import com.quiz.hackathon.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
