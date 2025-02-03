package com.example.universityadmissions;

import java.time.LocalDate;

public class Passport {
    private String fullName;
    private LocalDate dateOfBirth;
    private String series;
    private int number;

    public Passport(String fullName, LocalDate dateOfBirth, String series, int number) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.series = series;
        this.number = number;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}