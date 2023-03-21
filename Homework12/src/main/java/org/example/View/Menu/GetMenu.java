package org.example.View.Menu;

/**
 * Класс с информацией о меню
 * Реализован принцип единственной ответственности:
 * Класс генерации отделён от класса, отвечающего за предоставление меню
 */
public class GetMenu implements GetMenuImpl {
    Menu menu;
    String mainMenu;
    String choiceMember;
    String choiceGroup;
    String choiceWhoseMember;
    String choiceWhatsGroup;

    public GetMenu() {
        this.menu = new Menu();
        this.mainMenu = menu.addMainMenu();
        this.choiceMember = menu.addChoiceMember();
        this.choiceGroup = menu.addChoiceGroup();
        this.choiceWhoseMember = menu.addChoiceWhoseMember();
        this.choiceWhatsGroup = menu.addChoiceWhatsGroup();
    }


    @Override
    public String getMainMenu() {
        return mainMenu;
    }

    @Override
    public String getChoiceMember() {
        return choiceMember;
    }

    @Override
    public String getChoiceGroup() {
        return choiceGroup;
    }

    @Override
    public String getChoiceWhoseMember() {
        return choiceWhoseMember;
    }

    @Override
    public String getChoiceWhatsGroup() {
        return choiceWhatsGroup;
    }
}
