package org.example.Model.Services.Member;

import org.example.Model.Groups.Association;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;
import org.example.View.View;

import java.util.List;

public interface DataService {

    User create(Student student);
    User create(Teacher teacher);
    Association create(StudyGroup studyGroup);
    List<User> readUsers(List<User> users);

}
