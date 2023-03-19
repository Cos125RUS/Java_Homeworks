package org.example.Model.Services;

import org.example.Model.Groups.Association;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;
import org.example.View.In;
import org.example.View.Menu;
import org.example.View.View;

import java.util.List;

public class UserService implements DataUserService, GroupDataService, Info {
    View view;
    Menu menu;
    In enter;

    public UserService() {
        view = new View();
        menu = new Menu();
        enter = new In();
    }

    @Override
    public User create(Student student) {
        return new Student();
    }

    @Override
    public User create(Teacher teacher) {
        return new Teacher();
    }

    @Override
    public List<User> readUsers(List<User> users) {
        return users;
    }

    @Override
    public Association create(StudyGroup studyGroup) {
        return new StudyGroup();
    }

    @Override
    public Association readGroup(Association group) {
        return group;
    }

    @Override
    public Association readGroup(StudyGroup group) {
        return group;
    }

    @Override
    public void showInfo(String info) {
        System.out.println(info);
    }

    public void showMenu(int choice) {
        switch (choice) {
            case 1:
                showInfo(menu.choiceMember());
                break;


            case -1:
                showInfo("Пока-пока");
                break;
            default:
                showInfo(menu.mainMenu());
        }
    }

    public int userChoice() {
        return enter.choice();
    }
}
