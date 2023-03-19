package org.example.Model.Services;

import org.example.Model.Groups.Association;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;

import java.util.List;

public interface DataUserService {

    User create(Student student);
    User create(Teacher teacher);
    List<User> readUsers(List<User> users);

}
