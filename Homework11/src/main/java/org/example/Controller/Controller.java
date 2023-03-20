package org.example.Controller;

import org.example.Model.Services.Adders.AddGroup.AdderStudyGroup;
import org.example.Model.Services.Adders.AddMember.StudentAdderMembers;
import org.example.Model.Services.Adders.AddMember.TeacherAdderMembers;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Services.Getters.GetterMembersList;
import org.example.Model.Services.UserService;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void start() {
        UserService us = new UserService();
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();
        List<StudyGroup> studyGroups = new ArrayList<>();

        String userChoice = "0";
        us.showMenu(userChoice);
        while (!userChoice.equals("-1")) {
            switch (userChoice) {
                case "1":
                    userChoice = us.userEnter();
                    switch (userChoice) {
                        case "1":
                            students.add(new StudentAdderMembers(us).addStudent());
                            break;
                        case "2":
                            teachers.add(new TeacherAdderMembers(us).addTeacher());
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
                    us.showInfo("Жмякни Enter, чтобы выйти в меню");
                    us.userEnter();
                    userChoice = "0";
                    us.showMenu(userChoice);
                    break;

                case "2":
                    userChoice = us.userEnter();
                    switch (userChoice) {
                        case "1":
                            studyGroups.add(new AdderStudyGroup(us, teachers, students).newGroup());
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
                    us.showInfo("Жмякни Enter, чтобы выйти в меню");
                    us.userEnter();
                    userChoice = "0";
                    us.showMenu(userChoice);
                    break;

                case "3":
                    userChoice = us.userEnter();
                    switch (userChoice) {
                        case "1":
                            us.showInfo(new GetterMembersList<Student>(students).toString());
                            break;
                        case "2":
                            us.showInfo(new GetterMembersList<Teacher>(teachers).toString());
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
                    us.showInfo("Жмякни Enter, чтобы выйти в меню");
                    us.userEnter();
                    userChoice = "0";
                    us.showMenu(userChoice);
                    break;


                case "0":
                    userChoice = us.userEnter();
                    us.showMenu(userChoice);
            }
        }
    }
}
