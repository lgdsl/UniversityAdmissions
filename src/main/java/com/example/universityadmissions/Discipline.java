package com.example.universityadmissions;

public class Discipline {
    private String name;          // Название дисциплины (например, "Математика")


    // Конструктор для класса Discipline
    public Discipline(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
