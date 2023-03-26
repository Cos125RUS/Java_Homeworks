package org.example.ComplexCalc.Controller;

import org.example.ComplexCalc.Model.Calculable;
import org.example.ComplexCalc.Model.ImaginaryNumber;
import org.example.ComplexCalc.View.ViewCalculator;

public class Calculator implements ICalculator{
    private ViewCalculator view;
    private Calculable calc;
    private String arg2;

    public Calculator() {
        this.view = new ViewCalculator();
        arg2 = "Введите второе вещественное число:";
    }

    @Override
    public void run() {
        while (true) {
            view.show("Введите первое вещественное число:\n");
            this.calc = new Calculable(newImgNum());
            while (true) {
                String cmd = view.prompt("Введите команду (+, -, *, /, =) : ");
                if (cmd.equals("*")) {
                    view.show(arg2);
                    calc.multi(newImgNum());
                    continue;
                }
                if (cmd.equals("-")) {
                    view.show(arg2);
                    calc.difference(newImgNum());
                    continue;
                }
                if (cmd.equals("+")) {
                    view.show(arg2);
                    calc.sum(newImgNum());
                    continue;
                }
                if (cmd.equals("/")) {
                    view.show(arg2);
                    calc.quotient(newImgNum());
                    continue;
                }
                if (cmd.equals("=")) {
                    view.show("Результат = " + calc.getResult().toString());
                    break;
                }
            }
            String cmd = view.prompt("\nЕще посчитать (Y/N)?");
            if (cmd.equals("Y")) {
                continue;
            }
            break;
        }
    }

    private ImaginaryNumber newImgNum(){
        return new ImaginaryNumber(view.promptInt("real = "),
                view.promptInt("imaginary = "));
    }
}
