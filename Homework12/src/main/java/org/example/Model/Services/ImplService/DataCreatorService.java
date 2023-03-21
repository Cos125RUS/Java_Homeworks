package org.example.Model.Services.ImplService;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;

import java.util.List;

public interface DataCreatorService {

    Student createStudent();
    Teacher createTeacher();
    StudyGroup createGroup(List<Teacher> teachers, List<Student> students);

}
