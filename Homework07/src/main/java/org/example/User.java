package org.example;

public class User {
    private String name;
    private String password;
    private Basket userBasket;
    private static Integer count;

    static{
        count = 1;
    }

    private User(String name, String password, Basket userBasket) {
        this.name = name;
        this.password = password;
        this.userBasket = userBasket;
        count++;
    }

    public User(String name, String password) {
        this(name, password, new Basket());
    }

    public User() {
        this(("newUser_" + count), "password",new Basket());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0)
            this.name = name;
        else System.out.println("Имя не введено");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (name.length() > 0)
            this.password = password;
        else System.out.println("Пароль не введено");
    }

    public Basket getUserBasket() {
        return userBasket;
    }

    public void add (Product newProduct) {
        userBasket.add(newProduct);
    }

    @Override
    public String toString (){
        return userBasket.toString();
    }
}
