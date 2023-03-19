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
        for (T user:users)
            sb.append(user.toString()).append("\n");
        return sb.toString();
    }
}
