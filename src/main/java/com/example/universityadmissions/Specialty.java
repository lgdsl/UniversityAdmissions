package com.example.universityadmissions;

import java.util.ArrayList;
import java.util.List;

public class Specialty {
    private String name;          // Название специальности (например, "Информатика")
    private String code;          // Код специальности
    private List<Discipline> requiredExams; // Список дисциплин, необходимых для поступления

    // Конструктор для класса Specialty
    public Specialty(String name, String code, List<Discipline> requiredExams) {
        this.name = name;
        this.code = code;
        this.requiredExams = new ArrayList<Discipline>();
    }

    // Геттер и сеттер для поля name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Геттер и сеттер для поля code
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // Геттер и сеттер для поля requiredExams
    public List<Discipline> getRequiredExams() {
        return requiredExams;
    }

    public void setRequiredExams(List<Discipline> requiredExams) {
        this.requiredExams = requiredExams;
    }
}
