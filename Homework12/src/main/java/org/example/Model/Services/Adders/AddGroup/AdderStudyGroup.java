package org.example.Model.Services.Adders.AddGroup;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Services.Getters.GetterMembersList;
import org.example.Model.Services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Метод отвечает за создание непосредственно студенческих групп.
 * Реализован принцип подстановки Барбары Лисков
 */
public class AdderStudyGroup extends AdderGroup implements AdderGroupImpl<Teacher, Student, StudyGroup> {
    List<Teacher> teachers;
    List<Student> students;
    public AdderStudyGroup(UserService userService, List<Teacher> teachers, List<Student> students) {
        super(userService);
        this.teachers = teachers;
        this.students = students;
    }

    @Override
    public String name() {
        us.showInfo("\nНомер группы: ");
        return us.userEnter();
    }

    @Override
    public Teacher leader() {
        us.showInfo("\nВыбор куратора группы: ");
        us.showInfo(new GetterMembersList<Teacher>(teachers).toString());
        try {
            int choiceLeader = Integer.parseInt(us.userEnter());
            return teachers.get(choiceLeader - 1);
        } catch (Exception e) {
            us.showInfo("\nОшибка ввода!\n");
        }
        return null;
    }

    @Override
    public List<Student> members() {
        us.showInfo("\nДобавление студентов: ");
        us.showInfo(new GetterMembersList<Student>(students).toString());
        List<Student> selectStudents = new ArrayList<>();
        us.showInfo("\nВведите номера через пробел и нажмите Enter: ");
        try {
            String choiceMembers = us.userEnter();
            String[] membersId = choiceMembers.split(" ");
            for (String s : membersId) {
                selectStudents.add(students.get(Integer.parseInt(s) - 1));
            }
            return selectStudents;
        } catch (Exception e) {
            us.showInfo("\nОшибка ввода!\n");
        }
        return null;
    }

    @Override
    public StudyGroup newGroup() {
        return new StudyGroup(leader(), members(),Integer.parseInt(name()));
    }
}
