package Unary;

public class UnaryOperationFactory {
        public UnaryOperation createUnaryOperation(String operator) {
            switch (operator) {
                case "|":
                    return new abs();
                case "-":
                    return new neg();
                case "/":
                    return (UnaryOperation) new rec();
                case "sqrt":
                    return new squareboot();
                case "^":
                    return new square();
                default:
                    throw new IllegalArgumentException("无效的运算符");
            }
        }

}
