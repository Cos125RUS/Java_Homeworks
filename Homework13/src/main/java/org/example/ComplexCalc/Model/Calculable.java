package org.example.ComplexCalc.Model;

import java.io.FileWriter;
import java.io.IOException;

public class Calculable implements ICalculable {
    private ImaginaryNumber primaryArg;
    private Logger logger;

    public Calculable(ImaginaryNumber primaryArg) throws IOException {
        this.primaryArg = primaryArg;
        this.logger = new Logger();
        logger.newLog(primaryArg.toString());
    }

    @Override
    public Calculable sum(ImaginaryNumber number) throws IOException{
        logger.newLog(" + " + number.toString());
        primaryArg = new ImaginaryNumber(primaryArg.getReal() + number.getReal(),
                primaryArg.getImaginary() + number.getImaginary());
        return this;
    }

    @Override
    public Calculable difference(ImaginaryNumber number) throws IOException{
        logger.newLog(" - " + number.toString());
        primaryArg = new ImaginaryNumber(primaryArg.getReal() - number.getReal(),
                primaryArg.getImaginary() - number.getImaginary());
        return this;
    }

    @Override
    public Calculable multi(ImaginaryNumber number) throws IOException{
        logger.newLog(" * " + number.toString());
        primaryArg = new ImaginaryNumber(primaryArg.getReal() * number.getReal(),
                primaryArg.getImaginary() * number.getImaginary());
        return this;
    }

    @Override
    public Calculable quotient(ImaginaryNumber number) throws IOException{
        logger.newLog(" / " + number.toString());
        primaryArg = new ImaginaryNumber(primaryArg.getReal() / number.getReal(),
                primaryArg.getImaginary() / number.getImaginary());
        return this;
    }

    @Override
    public ImaginaryNumber getResult() throws IOException{
        logger.newLog(" = " + primaryArg.toString() + "\n");
        return primaryArg;
    }
}
