package com.example.universityadmissions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Applicant {
    private String fullName;      // ФИО абитуриента
    private LocalDate birthDate;  // Дата рождения
    private String address;       // Адрес проживания
    private String phoneNumber;   // Номер телефона
    private String email;         // Электронная почта
    private List<Document> documents; // Список документов
    private ExamSheet examSheet;  // Экзаменационный лист
    private Specialty specialty; // Специальность, на которую поступает абитуриент


    // Constructor for Applicant
    public Applicant(String fullName, LocalDate birthDate, String address, String phoneNumber, String email, ExamSheet examSheet, Specialty specialty) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.examSheet = examSheet;
        this.specialty = specialty;
        this.documents = new ArrayList<>();  // Инициализация списка документов
    }

    
    // Method to add a document to the documents list
    public void addDocument(Document document) {
        if (this.documents != null) {
            this.documents.add(document);
        }
    }
    
    // Getter and Setter for fullName
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and Setter for birthDate
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    // Getter and Setter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for documents
    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    // Getter and Setter for examSheet
    public ExamSheet getExamSheet() {
        return examSheet;
    }

    public void setExamSheet(ExamSheet examSheet) {
        this.examSheet = examSheet;
    }

    // Getter and Setter for specialty
    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

}
