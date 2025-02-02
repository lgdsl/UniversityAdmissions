package com.example.universityadmissions;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;

public class ApplicantController {

    @FXML
    private TableView<Applicant> applicantTable;

    @FXML
    private TableColumn<Applicant, String> nameColumn;
    @FXML
    private TableColumn<Applicant, String> birthDateColumn;
    @FXML
    private TableColumn<Applicant, String> addressColumn;
    @FXML
    private TableColumn<Applicant, String> phoneColumn;
    @FXML
    private TableColumn<Applicant, String> emailColumn;
    @FXML
    private TableColumn<Applicant, String> specialtyColumn;
    @FXML
    private TableColumn<Applicant, Integer> examScoreColumn;

    @FXML
    private TextField nameField;
    @FXML
    private DatePicker birthDatePicker;
    @FXML
    private TextField addressField;
    @FXML
    private TextField phoneField;
    @FXML
    private TextField emailField;
    @FXML
    private ComboBox<String> specialtyComboBox;
    @FXML
    private DatePicker examDatePicker;
    @FXML
    private TextField examScoreField;

    @FXML
    private Button addButton;
    @FXML
    private Button deleteButton;
    @FXML
    private Button clearButton;

    private ObservableList<Applicant> applicantList = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        // Настройка колонок таблицы
        nameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFullName()));
        birthDateColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBirthDate().toString()));
        addressColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));
        phoneColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPhoneNumber()));
        emailColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEmail()));

        // Для колонки специальности отображаем только имя специальности
        specialtyColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSpecialty().getName()));

        // Для колонки балла экзамена отображаем общий балл экзамена
        examScoreColumn.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getExamSheet().getTotalScore()).asObject());

        applicantTable.setItems(applicantList);  // Привязываем список к таблице

        // Настроим ComboBox для специальностей
        specialtyComboBox.setItems(FXCollections.observableArrayList("Информатика", "Математика", "Физика"));

        // Обработчики кнопок
        addButton.setOnAction(event -> handleAddApplicant());
        deleteButton.setOnAction(event -> handleDeleteApplicant());
        clearButton.setOnAction(event -> clearFields());
    }

    @FXML
    private void handleAddApplicant() {
        try {
            // Получаем данные из полей ввода
            String name = nameField.getText();
            LocalDate birthDate = birthDatePicker.getValue();
            String address = addressField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String specialtyName = specialtyComboBox.getValue();

            // Проверка на незаполненные поля
            if (name.isEmpty() || address.isEmpty() || phone.isEmpty() || email.isEmpty() || specialtyName == null ||
                    examScoreField.getText().isEmpty() || examDatePicker.getValue() == null) {
                showAlert(Alert.AlertType.WARNING, "Ошибка", "Пожалуйста, заполните все поля.");
                return;
            }

            // Создаем специальность
            Specialty specialty = new Specialty(specialtyName, "00001", new ArrayList<>());

            // Создаем экзамен
            int score = Integer.parseInt(examScoreField.getText());
            LocalDate examDate = examDatePicker.getValue();
            Discipline discipline = new Discipline("Неизвестная дисциплина");
            Exam exam = new Exam(discipline, score, examDate);

            // Создаем экзаменационный лист
            ExamSheet examSheet = new ExamSheet();
            examSheet.setExams(Collections.singletonList(exam));
            examSheet.setTotalScore();

            // Создаем абитуриента
            Applicant newApplicant = new Applicant(name, birthDate, address, phone, email, examSheet, specialty);

            // Добавление абитуриента в список
            applicantList.add(newApplicant);

            // Очистка полей после добавления
            clearFields();
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Неверный формат балла. Пожалуйста, введите целое число.");
        } catch (DateTimeParseException e) {
            showAlert(Alert.AlertType.ERROR, "Ошибка", "Неверный формат даты рождения. Используйте формат ГГГГ-ММ-ДД.");
        }
    }

    @FXML
    private void handleDeleteApplicant() {
        Applicant selectedApplicant = applicantTable.getSelectionModel().getSelectedItem();
        if (selectedApplicant != null) {
            applicantList.remove(selectedApplicant);
        } else {
            showAlert(Alert.AlertType.WARNING, "Ошибка", "Пожалуйста, выберите абитуриента для удаления.");
        }
    }

    private void clearFields() {
        nameField.clear();
        birthDatePicker.setValue(null);
        addressField.clear();
        phoneField.clear();
        emailField.clear();
        specialtyComboBox.setValue(null);
        examDatePicker.setValue(null);
        examScoreField.clear();
    }

    private void showAlert(Alert.AlertType type, String title, String message) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
