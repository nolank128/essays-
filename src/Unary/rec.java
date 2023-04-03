package Unary;

public class rec {
    public double calculartes(double num)
    {
        if (num==0){
            throw new IllegalArgumentException("除数不能为0");

        }
        return 1.0/num;
    }
}
