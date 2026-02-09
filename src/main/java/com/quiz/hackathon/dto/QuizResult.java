package com.quiz.hackathon.dto;

public class QuizResult {

    private int score;
    private int total;

    public QuizResult() {
    }

    public QuizResult(int score, int total) {
        this.score = score;
        this.total = total;
    }

    public int getScore() {
        return score;
    }

    public int getTotal() {
        return total;
    }
}
