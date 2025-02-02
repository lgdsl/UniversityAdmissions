package com.example.universityadmissions;

import java.util.ArrayList;
import java.util.List;

public class ExamSheet {
    private Applicant applicant;  // Абитуриент
    private List<Exam> exams;     // Список экзаменов
    private int totalScore;       // Общий балл по всем экзаменам

    // Конструктор без параметров
    public ExamSheet() {
        this.exams = new ArrayList<>();  // Инициализируем пустой список экзаменов
        this.totalScore = 0;
    }

    // Конструктор с экзаменами
    public ExamSheet(List<Exam> exams) {
        this.exams = new ArrayList<>(exams); // Создаём копию списка экзаменов
        this.totalScore = calculateTotalScore();
    }

    // Метод для вычисления общего балла
    private int calculateTotalScore() {
        return exams.stream().mapToInt(Exam::getScore).sum();
    }

    // Геттеры и сеттеры
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = new ArrayList<>(exams);
        this.totalScore = calculateTotalScore(); // Обновляем общий балл
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore() {
        this.totalScore = calculateTotalScore();
    }
}
