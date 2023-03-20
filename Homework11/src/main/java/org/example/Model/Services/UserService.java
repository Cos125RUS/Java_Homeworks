package org.example.Model.Services;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;
import org.example.Model.Services.Impl.DataUserService;
import org.example.Model.Services.Impl.GroupDataService;
import org.example.Model.Services.Impl.Info;
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

//    @Override
//    public Association create(StudyGroup studyGroup) {
//        return new StudyGroup();
//    }
//
//    @Override
//    public Association readGroup(Association group) {
//        return group;
//    }
//
//    @Override
//    public Association readGroup(StudyGroup group) {
//        return group;
//    }
    @Override
    public StudyGroup create() {
        return null;
    }

    @Override
    public void showInfo(String info) {
        ConsoleView.show(info);
    }

    public void showMenu(String choice) {
        switch (choice) {
            case "1":
                ConsoleView.show(menu.choiceMember());
                break;
            case "2":
                ConsoleView.show(menu.choiceGroup());
                break;
            case "3":
                ConsoleView.show(menu.choiceWhosMember());
                break;
            case "4":
                ConsoleView.show(menu.choiceWhotsGroup());
                break;

            case "0":
                ConsoleView.show(menu.mainMenu());
                break;

            default:
                ConsoleView.show("Пока-пока");
        }
    }

    public String userEnter() {
        return enter.enterString();
    }

}
