package org.example.Model.Services.Adders.AddGroup;

import org.example.Model.Groups.Group;
import org.example.Model.Members.User;

import java.util.List;

/**
 * Интерфейс с методами на добавление групп
 * @param <U1> класс лидера
 * @param <U2> класс списка участников
 * @param <U3> класс группы
 *            Добавил наследование для абстрактных типов
 */
public interface AdderGroupImpl<U1 extends User, U2 extends User, U3 extends Group> {
    String name();
    U1 leader();
    List<U2> members(int groupName);
    U3 newGroup();
}
