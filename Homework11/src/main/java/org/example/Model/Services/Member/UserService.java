package org.example.Model.Services.Member;

import org.example.Model.Groups.Association;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;

import java.util.List;

public class UserService implements DataService{

    @Override
    public User create(Student student) {
        return new Student();
    }

    @Override
    public User create(Teacher teacher) {
        return new Teacher();
    }

    @Override
    public Association create(StudyGroup studyGroup) {
        return new StudyGroup();
    }

    @Override
    public List<User> readUsers(List<User> users) {
        return users;
    }
}
