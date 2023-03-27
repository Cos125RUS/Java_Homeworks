package org.example.ComplexCalc.Model;

import java.io.IOException;

public class CalcWithLog extends Calculable {
    private Logger logger;

    public CalcWithLog(ImaginaryNumber primaryArg) throws IOException {
        super(primaryArg);
        this.logger = new Logger();
        logger.newLog(primaryArg.toString());
    }

    @Override
    public Calculable sum(ImaginaryNumber number) {
        try {
            logger.newLog(" + " + number.toString());

        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            primaryArg = new ImaginaryNumber(primaryArg.getReal() + number.getReal(),
                    primaryArg.getImaginary() + number.getImaginary());
        }
        return this;
    }

    @Override
    public Calculable difference(ImaginaryNumber number) {
        try {
            logger.newLog(" - " + number.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            primaryArg = new ImaginaryNumber(primaryArg.getReal() - number.getReal(),
                    primaryArg.getImaginary() - number.getImaginary());
        }
        return this;
    }

    @Override
    public Calculable multi(ImaginaryNumber number) {
        try {
            logger.newLog(" * " + number.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            primaryArg = new ImaginaryNumber(primaryArg.getReal() * number.getReal(),
                    primaryArg.getImaginary() * number.getImaginary());
        }
        return this;
    }

    @Override
    public Calculable quotient(ImaginaryNumber number) {
        try {
            logger.newLog(" / " + number.toString());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            primaryArg = new ImaginaryNumber(primaryArg.getReal() / number.getReal(),
                    primaryArg.getImaginary() / number.getImaginary());
        }
        return this;
    }

    @Override
    public ImaginaryNumber getResult() {
        try {
            logger.newLog(" = " + primaryArg.toString() + "\n");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return primaryArg;
    }
}
