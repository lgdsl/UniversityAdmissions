package com.example.universityadmissions;

import java.util.*;

public class University {
    private List<Specialty> specialties; // Список специальностей
    private List<Applicant> applicants; // Список абитуриентов

    public University() {
        this.applicants = new ArrayList<Applicant>();
        this.specialties = new ArrayList<Specialty>();
    }

    public void addApplicant(Applicant applicant) {
        applicants.add(applicant);
    }

    public void addSpecialty(Specialty specialty) {
        specialties.add(specialty);
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }
}
