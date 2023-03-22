package org.example.AppSystem.WorkingWithFiles.Converter;

import org.example.Model.Groups.StudyGroup;

public interface ToStudyGroup {
    StudyGroup toStudyGroup(String line);
}
