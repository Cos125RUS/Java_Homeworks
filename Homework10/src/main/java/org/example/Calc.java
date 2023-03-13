package org.example;

import java.util.List;

public class Calc {
    private Double res = 0.0;

    public void clear(){
        res = 0.0;
    }

    public void add (Double num){
        this.res = num;
    }

    public Double sum (List<? extends Number> items){
        for (Number i: items)
            res += i.doubleValue();
        return res;
    }

    public Double sub (List<? extends Number> items){
        for (Number i: items)
            res -= i.doubleValue();
        return res;
    }

    public Double multy (List<? extends Number> items){
        for (Number i: items)
            res *= i.doubleValue();
        return res;
    }

    public Double div (List<? extends Number> items){
        if (res == 0) {
            System.out.println("Нельзя делить на ноль!");
        }
        else
            for (Number i: items)
                res /= i.doubleValue();
        return res;
    }

    public Double getRes() {
        return res;
    }

    public String binary(Double num){
        res = num;
        Integer n = num.intValue();
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            sb.append(n % 2);
            n /= 2;
        }
        sb.append(n);
        return sb.reverse().toString();
    }

    public String binary(String line){
        int num;
        try {
            num = Integer.parseInt(line);
        }
        catch (Exception e){
            Double d = Double.parseDouble(line);
            num = d.intValue();
        }
        res = (double) num;
        StringBuilder sb = new StringBuilder();
        while (num > 1) {
            sb.append(num % 2);
            num /= 2;
        }
        sb.append(num);
        return sb.reverse().toString();
    }

    public String binary(Integer num){
        res = num.doubleValue();
        StringBuilder sb = new StringBuilder();
        while (num > 1) {
            sb.append(num % 2);
            num /= 2;
        }
        sb.append(num);
        return sb.reverse().toString();
    }

    public String binary(){
        Integer n = res.intValue();
        StringBuilder sb = new StringBuilder();
        while (n > 1) {
            sb.append(n % 2);
            n /= 2;
        }
        sb.append(n);
        return sb.reverse().toString();
    }
}
