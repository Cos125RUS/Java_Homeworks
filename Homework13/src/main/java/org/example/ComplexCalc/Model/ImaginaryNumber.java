package org.example.ComplexCalc.Model;

public class ImaginaryNumber {
    private int real;
    private int imaginary;

    public ImaginaryNumber(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }


    public int getReal() {
        return real;
    }

    public int getImaginary() {
        return imaginary;
    }

    @Override
    public String toString() {
        return String.format("%d + %di", real, imaginary);
    }
}
