package org.example.Controller.AddMember;

import org.example.Model.Services.UserService;

public abstract class UserAdder implements Adder{
    UserService us;

    public UserAdder(UserService userService) {
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
