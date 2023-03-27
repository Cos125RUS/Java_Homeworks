package org.example.ComplexCalc.Model;

import java.io.IOException;

public interface ICalculable {
    Calculable sum(ImaginaryNumber number);
    Calculable difference(ImaginaryNumber number);
    Calculable multi(ImaginaryNumber number);
    Calculable quotient(ImaginaryNumber number);
    ImaginaryNumber getResult();
}
