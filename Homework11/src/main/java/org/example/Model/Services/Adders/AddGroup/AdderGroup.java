package org.example.Model.Services.Adders.AddGroup;

import org.example.Model.Services.UserService;

public abstract class AdderGroup {
    UserService us;

    public AdderGroup(UserService userService) {
        this.us = userService;
    }

}
