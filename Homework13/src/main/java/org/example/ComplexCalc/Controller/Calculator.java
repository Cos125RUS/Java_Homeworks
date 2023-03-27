package org.example.ComplexCalc.Controller;

import org.example.ComplexCalc.Model.CalcWithLog;
import org.example.ComplexCalc.Model.Calculable;
import org.example.ComplexCalc.Model.ImaginaryNumber;
import org.example.ComplexCalc.View.ViewCalculator;

import java.io.IOException;
import java.util.Locale;

public class Calculator implements ICalculator{
    private final ViewCalculator view;
    private Calculable calc;
    private final String arg1;
    private final String arg2;

    public Calculator() {
        this.view = new ViewCalculator();
        arg1 = "Введите первое вещественное число:\n";
        arg2 = "Введите второе вещественное число:\n";
    }

    @Override
    public void run() throws IOException {
        while (true) {
            view.show(arg1);
            this.calc = new CalcWithLog(newImgNum());
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
            if (cmd.toLowerCase().equals("y")) {
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
