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

    public Double binary(Object num){
        String line = num.toString();
        int n = 0;
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '1')
                n += (int) Math.pow(2.0,line.length() - 1 - i);
        }
        return res = (double) n;
    }

    public String toBinary (Object num){
        String line = num.toString();
        if (line.contains("."))
            line = line.replace('.', ' ').split(" ")[0];
        int n = Integer.parseInt(line);
        res = (double) n;
        return toBinary();
    }

    public String toBinary(){
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
