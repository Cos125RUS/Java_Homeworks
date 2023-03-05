package org.example;

import java.util.List;

public class Category {
    private String name;
    private List<Product> products;
    private static Integer count;

    static{
        count = 1;
    }

    public Category(String name, List<Product> products) {
        this.name = name;
        this.products = products;
        count++;
    }

    public Category(String name) {
        this(name,null);
    }

    public Category() {
        this(("newCategory_"+count), null);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < products.size();i++) {
            sb.append(products.get(i).toString()).append("\n");
        }
        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() > 0)
            this.name = name;
        else System.out.println("Название категории не введено");
    }

    public Product getProduct(int index) {
        if (products.size() == 0) {
            System.out.println("Товары в категории отсутствуют");
            return null;
        }
        else if (products.get(index) == null){
            System.out.println("Товар не найден");
            return null;
        }
        else {
            Product take = products.get(index);
            products.remove(index);
            return take;
        }
    }

//    public void setProducts(Product[] products) {
//        if (products.length > 0)
//            this.products = products;
//        else System.out.println("Список товаров пуст");
//    }

//    public String show (int index){
//        return products[index].toString();
//    }
}
