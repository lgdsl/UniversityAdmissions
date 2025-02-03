package com.example.universityadmissions;

import java.util.List;

public class Specialty {
    private String name;
    private Discipline discipline;

    public Specialty(String name, Discipline discipline) {
        this.name = name;
        this.discipline = discipline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}