package org.example.ComplexCalc.Model;

public class Calculable implements ICalculable {
    protected ImaginaryNumber primaryArg;

    public Calculable(ImaginaryNumber primaryArg) {
        this.primaryArg = primaryArg;
    }

    @Override
    public Calculable sum(ImaginaryNumber number) {
        primaryArg = new ImaginaryNumber(primaryArg.getReal() + number.getReal(),
                primaryArg.getImaginary() + number.getImaginary());
        return this;
    }

    @Override
    public Calculable difference(ImaginaryNumber number) {
        primaryArg = new ImaginaryNumber(primaryArg.getReal() - number.getReal(),
                primaryArg.getImaginary() - number.getImaginary());
        return this;
    }

    @Override
    public Calculable multi(ImaginaryNumber number) {
        primaryArg = new ImaginaryNumber(primaryArg.getReal() * number.getReal(),
                primaryArg.getImaginary() * number.getImaginary());
        return this;
    }

    @Override
    public Calculable quotient(ImaginaryNumber number) {
        primaryArg = new ImaginaryNumber(primaryArg.getReal() / number.getReal(),
                primaryArg.getImaginary() / number.getImaginary());
        return this;
    }

    @Override
    public ImaginaryNumber getResult() {
        return primaryArg;
    }
}
