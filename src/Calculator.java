import Binary.BinaryOperation;
import Binary.BinaryOperationFactory;
import Unary.UnaryOperation;
import Unary.UnaryOperationFactory;
import Logger.*;

import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinaryOperationFactory factory = new BinaryOperationFactory();

        System.out.print("请输入第一个数字：");
        double num1 = scanner.nextDouble();

        System.out.print("请输入第二个数字：");
        double num2 = scanner.nextDouble();

        System.out.print("请输入运算符（+、-、*、/）：");
        String operator = scanner.next();

        BinaryOperation operation = factory.createBinaryOperation(operator);
        double result = operation.calculate(num1, num2);

        System.out.println("计算结果是：" + result);


        UnaryOperationFactory factorys = new UnaryOperationFactory();
        System.out.print("请输入一个数字：");
        double num = scanner.nextDouble();

        System.out.print("请输入一元运算符（|、-、/、sqrt、^）：");
        String operators = scanner.next();

        UnaryOperation operations = factorys.createUnaryOperation(operator);
        double results = operations.calculates(num);

        System.out.println("计算结果是：" + result);

        LoggerFactory factory1=new LoggerFactory();
        Logger logger = factory1.createLogger();
        logger.log(num1 + " " + operator + " " + num2 + " = " + result);


    }
}

