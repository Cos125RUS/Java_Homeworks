package org.example;

public class Product {
    private String name;
    private int price;
    private int rating;
    private static Integer count;

    static{
        count = 1;
    }
    public Product(String name, int price, int rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        count++;
    }

    public Product(){
        this(("newProduct_" + count),0,0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0)
            this.name = name;
        else System.out.println("Назваие продукта не введено");
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price > 0)
            this.price = price;
        else System.out.println("Цена не может быть меньше нуля");
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating > 0)
            this.rating = rating;
        else System.out.println("Рейтинг не может быть меньше нуля");
    }

    @Override
    public String toString(){
        return String.format("%s, %d, %d", name, price, rating);
    }
}
