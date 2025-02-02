package com.example.universityadmissions;

import java.time.LocalDate;

public class Exam {
    private Discipline discipline; // Дисциплина, по которой проводится экзамен
    private int score;            // Балл, полученный за экзамен
    private LocalDate examDate;   // Дата сдачи экзамена
    

    // Конструктор для класса Exam
    public Exam(Discipline discipline, int score, LocalDate examDate) {
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

    public LocalDate getExamDate() {
        return examDate;
    }

    public void setExamDate(LocalDate examDate) {
        this.examDate = examDate;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
