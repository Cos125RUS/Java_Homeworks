package org.example.Model.Services.ImplService;

import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;

import java.util.List;

public interface DataReaderService {

    String getStudentsList(List<Student> students);
    String getTeachersList(List<Teacher> teachers);
    void getStudyGroupsList(List<StudyGroup> studyGroups);
    String userEnter();
}
