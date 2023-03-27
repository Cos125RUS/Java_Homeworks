package org.example.ComplexCalc.Model;

import java.io.IOException;

public class CalcWithLog extends Calculable {
    private Logger logger;

    public CalcWithLog(ImaginaryNumber primaryArg) throws IOException {
        super(primaryArg);
        this.logger = new Logger();
        logger.newLog(primaryArg.toString());
    }


}
