package org.example.Model.Services.Getters;

import org.example.Model.Groups.Group;

import java.util.List;

/**
 * Класс просмотра списка групп
 * @param <U> тип группы
 *     Реализован принцип единственной ответственности:
 *  Класс отвечает лишь за просмотр информации о пользователях
 */
public class GetterGroupList<U extends Group> implements GetterGroupImpl{
    List<U> groups;

    public GetterGroupList(List<U> groups) {
        this.groups = groups;
    }

    @Override
    public String showGroupList(int index) {
        StringBuilder sb = new StringBuilder();
        U group = groups.get(index);
        sb.append("Руководит: ").append(group.getLeader().toString()).append("\n");
        sb.append("Состав:\n").append(group.groupToString());
        return sb.toString();
    }
}
