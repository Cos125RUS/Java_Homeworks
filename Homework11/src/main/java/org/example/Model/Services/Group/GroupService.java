package org.example.Model.Services.Group;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;

import java.util.List;
import java.util.Map;

public class GroupService implements GroupDataService{

    @Override
    public StudyGroup create(Teacher teacher, List<Student> students) {
        return new StudyGroup(teacher, students);
    }

    @Override
    public String read(Map<? extends User, List<User>> group) {
        return view.groupView(group);
    }
}
