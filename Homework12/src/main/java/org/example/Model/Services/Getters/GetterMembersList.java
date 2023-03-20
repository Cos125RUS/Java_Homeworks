package org.example.Model.Services.Getters;

import java.util.List;

public class GetterMembersList<T> {
    List<T> users;


    public GetterMembersList(List<T> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < users.size(); i++)
            sb.append(i + 1).append(". ").append(users.get(i).toString()).append("\n");
        return sb.toString();
    }
}
