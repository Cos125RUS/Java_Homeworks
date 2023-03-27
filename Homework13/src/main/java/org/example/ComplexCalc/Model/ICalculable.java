package org.example.ComplexCalc.Model;

import java.io.IOException;

public interface ICalculable {
    Calculable sum(ImaginaryNumber number)throws IOException;
    Calculable difference(ImaginaryNumber number)throws IOException;
    Calculable multi(ImaginaryNumber number)throws IOException;
    Calculable quotient(ImaginaryNumber number)throws IOException;
    ImaginaryNumber getResult()throws IOException;
}
