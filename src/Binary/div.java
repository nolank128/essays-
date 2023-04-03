package Binary;

import Binary.BinaryOperation;

public class div implements BinaryOperation {

    @Override
    public double calculate(double num1, double num2) {
        if (num2==0){
            throw new IllegalArgumentException("除数不能为0");
        }
        return num1/num2;

    }
}
