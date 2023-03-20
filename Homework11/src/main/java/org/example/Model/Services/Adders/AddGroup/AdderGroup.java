package org.example.Model.Services.Adders.AddGroup;

import org.example.Model.Members.Teacher;
import org.example.Model.Services.UserService;

import java.util.List;

public abstract class AdderGroup {
    UserService us;

    public AdderGroup(UserService userService) {
        this.us = userService;
    }

}
