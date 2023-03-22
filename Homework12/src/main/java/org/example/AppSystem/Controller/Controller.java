package org.example.AppSystem.Controller;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Services.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 * Модуль контроля вызовов
 */
public class Controller implements ControllerImpl{
    UserService us;
    List<Student> students;
    List<Teacher> teachers;
    List<StudyGroup> studyGroups;

    /**
     * Контроллер для управления приложением
     */
    public Controller() {
        this.us = new UserService();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.studyGroups = new ArrayList<>();
    }

    /**
     * Стартер приложения
     */
    @Override
    public void start() {
        String userChoice = "0";
        us.showMenu(userChoice);
        while (!userChoice.equals("-1")) {
            switch (userChoice) {
                case "1":
                    addMember(us.userEnter());
                    userChoice = end();
                    break;

                case "2":
                    addGroup(us.userEnter());
                    userChoice = end();
                    break;

                case "3":
                    readMembersList(us.userEnter());
                    userChoice = end();
                    break;

                case "4":
                    readGroupList(us.userEnter());
                    userChoice = end();
                    break;

                case "0":
                    userChoice = us.userEnter();
                    us.showMenu(userChoice);
                    break;

                default:
                    userChoice = "0";
                    us.showInfo("Указано неправильное значение");
                    break;
            }
        }
    }


    private void addMember(String userChoice) {
        switch (userChoice) {
            case "1":
                students.add(us.createStudent());
                break;
            case "2":
                teachers.add(us.createTeacher());
                break;
            case "3":
                us.showInfo("Функционал 'Зав.кафедрой' не реализован");
                break;
            case "4":
                us.showInfo("Функционал 'Ректор' не реализован");
                break;
            default:
                us.showInfo("Указано неправьное значение");
                break;
        }
    }

    private void addGroup(String userChoice) {
        switch (userChoice) {
            case "1":
                studyGroups.add(us.createGroup(teachers, students));
                us.showInfo("\nУчебная группа создана!\n");
                break;
            case "2":
                us.showInfo("Функционал 'Кафедра' не реализован");
                break;
            case "3":
                us.showInfo("Функционал 'Институт' не реализован");
                break;
            default:
                us.showInfo("Указано неправильное значение");
                break;
        }
    }

    private void readMembersList(String userChoice) {
        switch (userChoice) {
            case "1":
                us.showInfo(us.getStudentsList(students));
                break;
            case "2":
                us.showInfo(us.getTeachersList(teachers));
                break;
            case "3":
                us.showInfo("Функционал 'Зав.кафедрой' не реализован");
                break;
            case "4":
                us.showInfo("Функционал 'Ректор' не реализован");
                break;
            default:
                us.showInfo("Указано неправильное значение");
                break;
        }
    }

    private void readGroupList(String userChoice) {
        switch (userChoice) {
            case "1":
                us.getStudyGroupsList(studyGroups);
                break;
            case "2":
                us.showInfo("Функционал 'Кафедра' не реализован");
                break;
            case "3":
                us.showInfo("Функционал 'Институт' не реализован");
                break;
            default:
                us.showInfo("Указано неправильное значение");
                break;
        }
    }

    private String end() {
        us.showInfo("Жмякни Enter, чтобы выйти в меню");
        us.userEnter();
        us.showMenu("0");
        return "0";
    }
}
