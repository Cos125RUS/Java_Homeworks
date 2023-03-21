package org.example.View;

public class Menu implements MenuImpl{
    StringBuilder sb = new StringBuilder();

    @Override
    public String mainMenu() {
        sb.setLength(0);
        sb.append("Главное меню:\n");
        sb.append("1.Добавить мембера\n");
        sb.append("2.Добавить группу\n");
        sb.append("3.Посмотреть список мемберов\n");
        sb.append("4.Посмотреть группу\n");
        sb.append("0.Выйти\n\n");
        return sb.toString();
    }

    @Override
    public String choiceMember() {
        sb.setLength(0);
        sb.append("Выбор нового пользователя:\n");
        sb.append("1.Добавить студента\n");
        sb.append("2.Добавить преподавателя\n");
        sb.append("3.Добавить зав.кафедрой\n");
        sb.append("4.Добавить ректора\n");
        sb.append("0.Выйти\n\n");
        return sb.toString();
    }

    @Override
    public String choiceGroup() {
        sb.setLength(0);
        sb.append("Выбор Группы:\n");
        sb.append("1.Добавить учебную группу\n");
        sb.append("2.Добавить кафедру\n");
        sb.append("3.Добавить институт\n");
        sb.append("0.Выйти\n\n");
        return sb.toString();
    }

    @Override
    public String choiceWhoseMember() {
        sb.setLength(0);
        sb.append("Какую группу смотрим:\n");
        sb.append("1.Учащиеся\n");
        sb.append("2.Преподаватели\n");
        sb.append("3.Зав.кафедр\n");
        sb.append("4.Ректор\n");
        sb.append("0.Выйти\n\n");
        return sb.toString();
    }

    @Override
    public String choiceWhatsGroup() {
        sb.setLength(0);
        sb.append("Выбор Группы:\n");
        sb.append("1.Группа учащихся\n");
        sb.append("2.Кафедра\n");
        sb.append("3.Институт\n");
        sb.append("0.Выйти\n\n");
        return sb.toString();
    }

}
