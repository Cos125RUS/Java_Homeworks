package org.example.Model.Services.Adders.AddGroup;

import org.example.Model.Services.UserService;

/**
 * Класс для управления добавлением групп
 * Использую принцып единственной ответственности:
 * Класс StudyGroup отвечает только за хранение информации о группах,
 * А за создание новых групп отвечает класс AdderGroup.
 */
public abstract class AdderGroup {
    UserService us;

    public AdderGroup(UserService userService) {
        this.us = userService;
    }

}
