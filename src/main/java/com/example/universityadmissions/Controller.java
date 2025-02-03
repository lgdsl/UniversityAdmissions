package com.example.universityadmissions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.time.LocalDate;

public class Controller {
    @FXML private TextField fullNameField;
    @FXML private DatePicker dateOfBirthPicker;
    @FXML private TextField passportSeriesField;
    @FXML private TextField passportNumberField;
    @FXML private TextField specialtyField;
    @FXML private TextField Discipline;
    @FXML private TextField ExamScoreField;
    @FXML private DatePicker ExamDatePicker;
    @FXML private TableView<Abiturient> abiturientsTableView;
    @FXML private TableColumn<Abiturient, String> nameColumn;
    @FXML private TableColumn<Abiturient, String> specialtyColumn;
    @FXML private TableColumn<Abiturient, Double> totalScoreColumn;
    @FXML private TableColumn<Abiturient, LocalDate> birthDateColumn;
    @FXML private TableColumn<Abiturient, String> passportSeriesColumn;
    @FXML private TableColumn<Abiturient, Integer> passportNumberColumn;
    @FXML private TableColumn<Abiturient, String> disciplineColumn;
    @FXML private TableColumn<Abiturient, LocalDate> examDateColumn;
    @FXML private Button deleteButton;

    private final ObservableList<Abiturient> abiturients = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getPassport().getFullName()));
        specialtyColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getSpecialty().getName()));
        totalScoreColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getExaminationSheet().getTotalScore()));
        birthDateColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPassport().getDateOfBirth()));
        passportSeriesColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getPassport().getSeries()));
        passportNumberColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getPassport().getNumber()));
        disciplineColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleStringProperty(data.getValue().getExaminationSheet().getExam().getDiscipline().getName()));
        examDateColumn.setCellValueFactory(data ->
                new javafx.beans.property.SimpleObjectProperty<>(data.getValue().getExaminationSheet().getExam().getExamDate()));

        abiturientsTableView.setItems(abiturients);
    }

    @FXML
    private void handleSaveButton() {
        String fullName = fullNameField.getText();
        LocalDate birthDate = dateOfBirthPicker.getValue();
        String passportSeries = passportSeriesField.getText();
        int passportNumber = Integer.parseInt(passportNumberField.getText());
        String specialtyName = specialtyField.getText();
        String disciplineName = Discipline.getText();
        double examScore = Double.parseDouble(ExamScoreField.getText());
        LocalDate examDate = ExamDatePicker.getValue();

        Passport passport = new Passport(fullName, birthDate, passportSeries, passportNumber);
        Discipline discipline = new Discipline(disciplineName);
        Specialty specialty = new Specialty(specialtyName, discipline);
        Exam exam = new Exam(discipline, examScore, examDate);
        ExaminationSheet examinationSheet = new ExaminationSheet(exam, examScore);
        Abiturient abiturient = new Abiturient(specialty, examinationSheet, passport);

        abiturients.add(abiturient);
        clearFields();
    }

    @FXML
    private void handleDeleteButton() {
        Abiturient selectedAbiturient = abiturientsTableView.getSelectionModel().getSelectedItem();
        if (selectedAbiturient != null) {
            abiturients.remove(selectedAbiturient);
        } else {
            showAlert("Ошибка", "Выберите запись для удаления");
        }
    }

    private void clearFields() {
        fullNameField.clear();
        dateOfBirthPicker.setValue(null);
        passportSeriesField.clear();
        passportNumberField.clear();
        specialtyField.clear();
        Discipline.clear();
        ExamScoreField.clear();
        ExamDatePicker.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
