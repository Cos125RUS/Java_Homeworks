package org.example.Model.Groups;

import org.example.Model.Members.User;

import java.util.List;

/**
 * Абстрактный класс для объединения юзеров
 * @param <U1> Анонимный класс для лидера (куратор, зав.кафедрой, ректор)
 * @param <U2> Анонимный класс для списка юзеров
 */
public abstract class Group<U1 extends User, U2 extends User>{
    U1 leader;
    List<U2> members;


    public Group(U1 leader, List<U2> members) {
        this.leader = leader;
        this.members = members;
    }

    /**
     * Вернуть руководителя группы
     * @return Наследник User-а
     */
    public U1 getLeader() {
        return leader;
    }

    /**
     * Вернуть список участников
     * @return Лист наследников User-а
     */
    public List<U2> getMembers() {
        return members;
    }
}
