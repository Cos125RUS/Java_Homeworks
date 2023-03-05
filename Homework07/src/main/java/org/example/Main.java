package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Product apple = new Product("apple", 100, 7);
        Product banana = new Product("banana", 110, 5);
        Product pear = new Product("pear", 90, 10);

        Product milk = new Product("milk", 70, 9);
        Product cottage = new Product("cottage", 120, 8);

        Product beef = new Product("beef", 200, 6);
        Product chicken = new Product("chicken", 150, 7);

//        Product[] fruitsProduct = {apple, banana, pear};
//        Product[] dairyProduct = {milk, cottage};
//        Product[] meetProduct = {beef, chicken};

        List<Product> fruitsProduct = new ArrayList<>();
        List<Product> dairyProduct = new ArrayList<>();
        List<Product> meetProduct = new ArrayList<>();

        fruitsProduct.add(apple);
        fruitsProduct.add(banana);
        fruitsProduct.add(pear);

        dairyProduct.add(milk);
        dairyProduct.add(cottage);

        meetProduct.add(beef);
        meetProduct.add(chicken);

        Category fruits = new Category("fruits", fruitsProduct);
        Category dairy = new Category("dairy", dairyProduct);
        Category meet = new Category("meet", meetProduct);

        show(fruits, dairy, meet);

        User user1 = new User();
//        User user2 = new User();
//        User user3 = new User();

        System.out.println("==================================");
        user1.add(fruits.getProduct(0));
        user1.add(dairy.getProduct(1));

        System.out.println(user1.getName() + ":");
        System.out.println(user1.toString());

        System.out.println("==================================");
        show(fruits, dairy, meet);

    }


    public static void show(Category fruits, Category dairy, Category meet) {
        System.out.println(fruits.getName() + ":");
        System.out.println(fruits.toString());
        System.out.println(dairy.getName() + ":");
        System.out.println(dairy.toString());
        System.out.println(meet.getName() + ":");
        System.out.println(meet.toString());
    }
}