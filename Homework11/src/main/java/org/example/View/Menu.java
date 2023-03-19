package org.example.View;

public class Menu {
    StringBuilder sb = new StringBuilder();

    public String mainMenu() {
        sb.setLength(0);
        sb.append("Главное меню:\n");
        sb.append("1.Добавить мембера\n");
        sb.append("2.Добавить группу]\n");
        sb.append("3.Посмотреть список мемберов\n");
        sb.append("4.Посмотреть группу\n");
        sb.append("-1.Выйти\n\n");
        return sb.toString();
    }

    public String choiceMember() {
        sb.setLength(0);
        sb.append("Выбор нового пользователя:\n");
        sb.append("1.Добавить студента\n");
        sb.append("2.Добавить преподавателя\n");
        sb.append("3.Добавить зав.кафедрой\n");
        sb.append("4.Добавить ректора\n");
        sb.append("0.Назад\n\n");
        return sb.toString();
    }
}
