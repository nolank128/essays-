package Binary;

import Binary.BinaryOperation;
import Binary.add;

public class BinaryOperationFactory {

    public BinaryOperation createBinaryOperation(String operator){
        switch (operator){
            case "+":
                return new add();
            case "-":
                return new sub();
            case "*":
                return new mul();
            case "/":
                return new div();
            default:
                throw new IllegalArgumentException("输入错误，请重新输入");
        }

    }
}
