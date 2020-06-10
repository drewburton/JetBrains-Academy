package solver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Complex {
    private double real;
    private double imaginary;
    private boolean conjugate;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = Math.abs(imaginary);
        conjugate = imaginary < 0 ? true : false;
    }

    public Complex(String number) {
        
    }
}
