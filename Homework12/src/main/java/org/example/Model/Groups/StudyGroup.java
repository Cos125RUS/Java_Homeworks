package org.example.Model.Groups;

import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudyGroup extends Group<Teacher, Student>{
    int groupId;

    public StudyGroup(Teacher teacher, List<Student> students, int groupId) {
        super(teacher, students);
        this.groupId = groupId;
    }


    @Override
    public String toString() {
        return "StudyGroup{" +
                "groupId=" + groupId +
                ", leader=" + leader.getFio() +
                ", members=" + members.size() +
                '}';
    }

    public int getGroupId() {
        return groupId;
    }
}
