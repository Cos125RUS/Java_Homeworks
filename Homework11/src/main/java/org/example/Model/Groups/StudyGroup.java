package org.example.Model.Groups;

import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudyGroup extends Association<Student>{
    Teacher teacher;
    static int idCount = 0;

    public StudyGroup() {
        idCount++;
        super.groupId = idCount;
    }

    public StudyGroup(Teacher teacher, List<Student> students) {
        this();
        this.teacher = teacher;
        super.users = students;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Map<Teacher, List<Student>> getGroup() {
        Map<Teacher, List<Student>> group = new HashMap<>();
        group.put(teacher, users);
        return group;
    }
}
