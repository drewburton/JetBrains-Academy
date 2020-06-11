package solver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Complex {
    private double real;
    private double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex(String number) {
        Pattern plusPattern = Pattern.compile("\\+");
        Pattern minusPattern = Pattern.compile("-");
        if (plusPattern.matcher(number).find()) {
            String[] parts = number.split(plusPattern.toString());
            real = Integer.parseInt(parts[0]);
            try {
                imaginary = Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
            } catch (NumberFormatException e) {
                imaginary = 1;
            }
        } else if (minusPattern.matcher(number.substring(1)).find()) {
            String[] parts = number.split(minusPattern.toString());

            if (number.charAt(0) == '-') {
                try {
                    real = -Integer.parseInt(parts[1]);
                    imaginary = -Integer.parseInt(parts[2].substring(0, parts[2].length() - 1));
                } catch (NumberFormatException e) {
                    imaginary = -1;
                }
            } else {
                try {
                    real = Integer.parseInt(parts[0]);
                    imaginary = -Integer.parseInt(parts[1].substring(0, parts[1].length() - 1));
                } catch (NumberFormatException e) {
                    imaginary = 1;
                }
            }
        } else {
            real = number.contains("i") ? 0 : Integer.parseInt(number);
            try {
                imaginary = number.contains("i") ? Integer.parseInt(number.substring(0, number.length() - 1)) : 0;
            } catch (NumberFormatException e) {
                if (number.contains("-")) {
                   imaginary = -1;
                } else {
                    imaginary = 1;
                }
            }
        }
    }

    public Complex add(Complex num) {
        double real = this.real + num.real;
        double imaginary = this.imaginary + num.imaginary;

        return new Complex(real, imaginary);
    }

    public Complex subtract(Complex num) {
        double real = this.real - num.real;
        double imaginary = this.imaginary - num.imaginary;

        return new Complex(real, imaginary);
    }

    public Complex multiply(Complex num) {
        double real = this.real * num.real;
        double imaginary = this.imaginary * num.imaginary;

        return new Complex(real, imaginary);
    }

    public Complex divide(Complex num) throws ArithmeticException {
        double real = this.real / num.real;
        double imaginary = this.imaginary / num.imaginary;

        return new Complex(real, imaginary);
    }

    @Override
    public String toString() {
        StringBuilder complexNum = new StringBuilder();
        if (real != 0) {
            complexNum.append(real);
        }

        if (imaginary == 1 && real != 0) {
            complexNum.append("+i");
        } else if (imaginary == -1) {
            complexNum.append("-i");
        } else if (imaginary == 1) {
            complexNum.append("i");
        } else if (imaginary != 0 && imaginary < 0) {
            complexNum.append(imaginary + "i");
        } else if (imaginary != 0 && complexNum.length() > 0){
            complexNum.append("+" + imaginary + "i");
        } else if (imaginary != 0) {
            complexNum.append(imaginary + "i");
        }

        return complexNum.toString();
    }
}
