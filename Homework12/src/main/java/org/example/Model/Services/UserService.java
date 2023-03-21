package org.example.Model.Services;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Services.Adders.AddGroup.AdderStudyGroup;
import org.example.Model.Services.Adders.AddMember.StudentAdderMembers;
import org.example.Model.Services.Adders.AddMember.TeacherAdderMembers;
import org.example.Model.Services.Getters.GetterGroupList;
import org.example.Model.Services.Getters.GetterMembersList;
import org.example.Model.Services.ImplService.DataCreatorService;
import org.example.Model.Services.ImplService.DataReaderService;
import org.example.Model.Services.ImplService.Info;
import org.example.View.ConsoleView;
import org.example.View.In.In;
import org.example.View.Menu.GetMenu;
import org.example.View.View;

import java.util.List;

/**
 * Модуль предоставления сервисов
 * Реализован список разделения интерфейсов,
 * Один класс имплементирует три различных интерфейса
 */
public class UserService implements DataCreatorService, DataReaderService, Info {
    GetMenu menu;
    ConsoleView view;
    GetMenu getMenu;
    In enter;

    public UserService() {
        this.menu = new GetMenu();
        this.view = new ConsoleView();
        this.getMenu = new GetMenu();
        this.enter = new In();
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
        view.show(info);
    }

    @Override
    public void showMenu(String choice) {
        switch (choice) {
            case "1":
                view.show(menu.getChoiceMember());
                break;
            case "2":
                view.show(menu.getChoiceGroup());
                break;
            case "3":
                view.show(menu.getChoiceWhoseMember());
                break;
            case "4":
                view.show(menu.getChoiceWhatsGroup());
                break;

            case "0":
                view.show(menu.getMainMenu());
                break;

            default:
                view.show("Пока-пока");
        }
    }

    @Override
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
