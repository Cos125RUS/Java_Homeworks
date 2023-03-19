package org.example.Model.Services;

import org.example.Model.Groups.Association;
import org.example.Model.Groups.StudyGroup;
import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;
import org.example.View.View;

import java.util.List;
import java.util.Map;

public interface GroupDataService {
    View view = new View();

    Association create(StudyGroup studyGroup);

    Association readGroup(Association group);
    Association readGroup(StudyGroup group);
}
