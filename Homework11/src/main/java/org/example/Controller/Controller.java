package org.example.Controller;

import org.example.Model.Groups.Association;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;
import org.example.Model.Services.Group.GroupService;
import org.example.Model.Services.UserService;
import org.example.View.Menu;
import org.example.View.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    public void start() {
        UserService us = new UserService();
        us.showMenu(0);
        int userChoice = 0;
        while (userChoice != -1){
            userChoice += us.userChoice();
            us.showMenu(userChoice);
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
