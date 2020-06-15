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
            real = Double.parseDouble(parts[0]);
            try {
                imaginary = Double.parseDouble(parts[1].substring(0, parts[1].length() - 1));
            } catch (NumberFormatException e) {
                imaginary = 1;
            }
        } else if (minusPattern.matcher(number.substring(1)).find()) {
            String[] parts = number.split(minusPattern.toString());

            if (number.charAt(0) == '-') {
                try {
                    real = -Double.parseDouble(parts[1]);
                    imaginary = -Double.parseDouble(parts[2].substring(0, parts[2].length() - 1));
                } catch (NumberFormatException e) {
                    imaginary = -1;
                }
            } else {
                try {
                    real = Double.parseDouble(parts[0]);
                    imaginary = -Double.parseDouble(parts[1].substring(0, parts[1].length() - 1));
                } catch (NumberFormatException e) {
                    imaginary = 1;
                }
            }
        } else {
            real = number.contains("i") ? 0 : Double.parseDouble(number);
            try {
                imaginary = number.contains("i") ? Double.parseDouble(number.substring(0, number.length() - 1)) : 0;
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
        double real1 = real * num.real;
        double real2 = -(imaginary * num.imaginary);

        double imaginary1 = real * num.imaginary;
        double imaginary2 = imaginary * num.real;

        return new Complex(real1 + real2, imaginary1 + imaginary2);
    }

    public Complex divide(Complex num) throws ArithmeticException {
        Complex top;
        Complex bottom;
        if (num.imaginary == 0) {
            top = this;
            bottom = num;
        } else {
            top = multiply(num.getConjugate());
            bottom = num.multiply(num.getConjugate());
        }

        double factor = Double.parseDouble(bottom.toString());
        return new Complex(top.real / factor, top.imaginary / factor);
    }

    private Complex getConjugate() {
        return new Complex(real, -imaginary);
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
        } else {
            complexNum.append("0");
        }

        return complexNum.toString();
    }
}
