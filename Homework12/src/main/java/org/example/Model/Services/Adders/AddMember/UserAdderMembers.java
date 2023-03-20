package org.example.Model.Services.Adders.AddMember;

import org.example.Model.Services.UserService;

public abstract class UserAdderMembers implements AdderMembers {
    UserService us;

    public UserAdderMembers(UserService userService) {
        this.us = userService;
    }

    @Override
    public String date() {
        us.showInfo("\nДата рождения: ");
        return us.userEnter();
    }

    @Override
    public String fio() {
        us.showInfo("\nФИО: ");
        return us.userEnter();
    }
}
