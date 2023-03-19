package org.example.Model.Services.Group;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;
import org.example.View.View;

import java.util.List;
import java.util.Map;

public interface GroupDataService {
    View view = new View();

    StudyGroup create(Teacher teacher, List<Student> students);

    String read(Map<? extends User, List<User>> group);
}
