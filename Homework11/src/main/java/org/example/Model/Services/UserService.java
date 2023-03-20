package org.example.Model.Services;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Services.Adders.AddGroup.AdderStudyGroup;
import org.example.Model.Services.Adders.AddMember.StudentAdderMembers;
import org.example.Model.Services.Adders.AddMember.TeacherAdderMembers;
import org.example.Model.Services.Getters.GetterGroupList;
import org.example.Model.Services.Getters.GetterMembersList;
import org.example.Model.Services.Impl.DataCreatorService;
import org.example.Model.Services.Impl.DataReaderService;
import org.example.Model.Services.Impl.Info;
import org.example.View.In;
import org.example.View.Menu;
import org.example.View.View;

import java.util.List;

public class UserService implements DataCreatorService, DataReaderService, Info {
    View view;
    Menu menu;
    In enter;

    public UserService() {
        view = new View();
        menu = new Menu();
        enter = new In();
    }

    @Override
    public Student createStudent() {
        return new StudentAdderMembers(this).addStudent();
    }

    @Override
    public Teacher createTeacher() {
        return new TeacherAdderMembers(this).addTeacher();
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

    @Override
    public StudyGroup createGroup(List<Teacher> teachers, List<Student> students) {
        return new AdderStudyGroup(this, teachers, students).newGroup();
    }


    @Override
    public String getStudentsList(List<Student> students) {
        return new GetterMembersList<Student>(students).toString();
    }

    @Override
    public String getTeachersList(List<Teacher> teachers) {
        return new GetterMembersList<Teacher>(teachers).toString();
    }

    @Override
    public void getStudyGroupsList(List<StudyGroup> studyGroups) {
        try {
            showInfo(new GetterMembersList<StudyGroup>(studyGroups).toString());
            showInfo(new GetterGroupList<StudyGroup>(studyGroups)
                    .showGroupList(Integer.parseInt(userEnter()) - 1));
        }
        catch (Exception e){
            showInfo("Ошибка ввода значений");
        }
    }
}
