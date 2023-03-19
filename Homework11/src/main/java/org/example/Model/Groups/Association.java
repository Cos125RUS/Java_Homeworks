package org.example.Model.Groups;

import java.util.List;

public abstract class Association<T> {
    int groupId;
    List<T> users;

    public Association() {
    }


    public Association(List<T> users) {
        this.users = users;
    }

    public void addMember(T newUser){
        users.add(newUser);
    }

    public int getGroupId() {
        return groupId;
    }

    public List<T> getUsers() {
        return users;
    }
}
