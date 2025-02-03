package com.example.universityadmissions;

import java.time.LocalDate;

public class Exam {
    private Discipline discipline;
    private double score;
    private LocalDate examDate;

    public Exam(Discipline discipline, double score, LocalDate examDate) {
        this.discipline = discipline;
        this.score = score;
        this.examDate = examDate;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }
}