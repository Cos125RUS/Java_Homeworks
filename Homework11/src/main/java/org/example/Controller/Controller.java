package org.example.Controller;

import org.example.Controller.AddMember.StudentAdder;
import org.example.Controller.AddMember.TeacherAdder;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
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
                            students.add(new StudentAdder(us).addStudent());
                            break;
                        case "2":
                            teachers.add(new TeacherAdder(us).addTeacher());
                            break;
                        case "3":
                            //Добавить зав.кафедрой
                            break;
                        case "4":
                            //Добавить ректора
                            break;
                    }


                    userChoice = "0";
                    us.showMenu(userChoice);
                    break;

                case "0":
                    userChoice = us.userEnter();
                    us.showMenu(userChoice);
            }
        }


//        UserService userService = new UserService();
//        List<Student> students = new ArrayList<>();
//        students.add(new Student());
////        users.add(new Teacher());
////        userService.read(users);
////        View view = new View();
////        System.out.println(view.studentView(users));
//
//        userService.create(new Student());
//        GroupService groupService = new GroupService();
//        students.add(new Student());
//        students.add(new Student());
//        students.add(new Student());
////        Map<Teacher, List<Student>> group = new HashMap<>();
////        group.put(new Teacher(), students);
//        StudyGroup studyGroup = groupService.create(new Teacher(), students);
////        System.out.println(view.groupView(group));
////        System.out.println();
////        System.out.println(groupService.read(studyGroup.getGroup()));

    }
}
