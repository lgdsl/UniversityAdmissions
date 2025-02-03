package com.example.universityadmissions;

import java.util.List;

public class ExaminationSheet {
    private Exam exam;
    private double totalScore;

    public ExaminationSheet(Exam exam, double totalScore) {
        this.exam = exam;
        this.totalScore = totalScore;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public double getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(double totalScore) {
        this.totalScore = totalScore;
    }
}