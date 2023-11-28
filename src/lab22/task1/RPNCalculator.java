package lab22.task1;

import java.util.Stack;

public class RPNCalculator {
    public static double evaluateRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Double> stack = new Stack<>();

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                if (stack.size() < 2) {
                    throw new IllegalArgumentException("Invalid RPN expression");
                }

                double num2 = stack.pop();
                double num1 = stack.pop();

                switch (token) {
                    case "+":
                        stack.push(num1 + num2);
                        break;
                    case "-":
                        stack.push(num1 - num2);
                        break;
                    case "*":
                        stack.push(num1 * num2);
                        break;
                    case "/":
                        stack.push(num1 / num2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid RPN expression");
        }

        return stack.pop();
    }

    private static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] expression1 = {"2", "2", "+"};
        System.out.println("Результат: " + evaluateRPN(expression1));

        String[] expression2 = {"2", "2", "*", "6", "+"};
        System.out.println("Результат: " + evaluateRPN(expression2));

        String[] expression3 = {"5", "6", "10", "3", "+", "-11", "*", "/", "*", "8", "+", "2", "+"};
        System.out.println("Результат: " + evaluateRPN(expression3));
    }
}