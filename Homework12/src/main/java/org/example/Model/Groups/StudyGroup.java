package org.example.Model.Groups;

import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, отвечающий за создагте учебных групп.
 * Реализован принцип подстановки Барбары Лисков
 */
public class StudyGroup extends Group<Teacher, Student>{
    int groupId;

    /**
     * Создать учебную группу
     * @param teacher руководитель группы
     * @param students список учащихся группы
     * @param groupId номер группы
     */
    public StudyGroup(Teacher teacher, List<Student> students, int groupId) {
        super(teacher, students);
        this.groupId = groupId;
    }


    @Override
    public String toString() {
        return "Группа №" + groupId +
                ", Куратор: " + leader.getFio() +
                ", Количество учащихся:" + members.size();
    }


    /**
     * @return номер группы
     */
    public int getGroupId() {
        return groupId;
    }
}
