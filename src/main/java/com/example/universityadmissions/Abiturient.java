package com.example.universityadmissions;

public class Abiturient {
    private Specialty specialty;
    private ExaminationSheet examinationSheet;
    private Passport passport;

    public Abiturient(Specialty specialty, ExaminationSheet examinationSheet, Passport passport) {
        this.specialty = specialty;
        this.examinationSheet = examinationSheet;
        this.passport = passport;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public ExaminationSheet getExaminationSheet() {
        return examinationSheet;
    }

    public void setExaminationSheet(ExaminationSheet examinationSheet) {
        this.examinationSheet = examinationSheet;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}