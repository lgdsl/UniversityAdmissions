package com.example.universityadmissions;

import java.time.LocalDate;

public class Document {
    private String type;          // Тип документа (например, "Паспорт", "Аттестат")
    private String number;        // Номер документа
    private LocalDate issueDate;  // Дата выдачи документа
    private String issuedBy;      // Кем выдан документ
    private Applicant applicant;  // Абитуриент, к которому относится документ


    // Constructor for Document
    public Document(String type, String number, LocalDate issueDate, String issuedBy, Applicant applicant) {
        this.type = type;
        this.number = number;
        this.issueDate = issueDate;
        this.issuedBy = issuedBy;
        this.applicant = applicant;
    }


    // Getter and Setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and Setter for number
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // Getter and Setter for issueDate
    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    // Getter and Setter for issuedBy
    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    // Getter and Setter for applicant
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
}
