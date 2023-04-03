package Binary;

import Binary.BinaryOperation;

public class mul implements BinaryOperation {

    @Override
    public double calculate(double num1, double num2) {
        return num1*num2;
    }
}
