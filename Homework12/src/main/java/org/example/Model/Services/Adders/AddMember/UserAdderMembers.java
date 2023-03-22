package org.example.Model.Services.Adders.AddMember;

import org.example.Model.Services.UserService;
import org.example.Model.Services.Adders.Validity.Validity;

/**
 * Абстрактный класс добавления юзеров
 * Реализован принцип единственной ответственности
 * Добавление пользователей вынесено в отдельный класс,
 * Тогда как сам класс пользователей лишь хранит информацию
 * ~
 * Реализован принцип открытости/закрытости:
 * Да-да, здесь пока не особо видно,
 * Но класс Зав.кафедры будет наследником Учителя,
 * А Ректор наследником Зав.кафедры
 * ~
 * Вообще, любое наследование от абстрактного класса,
 * Считай, уже реализует принцип закрытости/открытости,
 * ~
 * Но в большей степени это, наверно, реализует принцип Барбары Лисков
 */
public abstract class UserAdderMembers implements AdderMembers {
    UserService us;
    Validity validity;

    public UserAdderMembers(UserService userService) {
        this.us = userService;
        this.validity = new Validity();
    }

    @Override
    public String date() {
        us.showInfo("\nДата рождения (дд.мм.гггг): ");
        String value = us.userEnter();
        if (!validity.dateCheck(value)) {
            us.showInfo("Ошибка ввода!");
            return date();
        }
        return value;
    }

    @Override
    public String fio() {
        us.showInfo("\nФИО: ");
        return us.userEnter();
    }
}
