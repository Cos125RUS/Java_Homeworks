package org.example.View;

import org.example.Model.Members.Student;
import org.example.Model.Members.Teacher;
import org.example.Model.Members.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Класс безнадёжгл устарел, так что был полностью заменён наследником в лице ConsoleView.
 */
public class View {

    StringBuilder sb = new StringBuilder();

    public String studentView(List<User> students){
        for (User s: students) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }

    public String groupView(Map<? extends User, List<User>> group){
        for (Map.Entry<? extends User, List<User>> entry: group.entrySet()) {
            sb.append(entry.getKey().toString()).append("\n");
            for (User member: entry.getValue())
                sb.append("  ").append(member.toString()).append("\n");
        }
        return sb.toString();
    }
}
