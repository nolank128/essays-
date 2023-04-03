package Unary;

public class squareboot implements UnaryOperation{
    public double calculates(double num){
        if (num<0){
            throw new IllegalArgumentException("负数不能求平方根");

        }
        return Math.sqrt(num);
    }
}
