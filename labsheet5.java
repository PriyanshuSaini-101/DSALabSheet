import java.util.Scanner;
import java.util.Stack;

public class Main {

    // Operator priority
    static int priority(char op) {
        if (op == '+' || op == '-')
            return 1;
        if (op == '*' || op == '/')
            return 2;
        if (op == '^')
            return 3;

        return 0;
    }

    // Q1: Infix to Postfix
    static String infixToPostfix(String exp) {

        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            // Operand
            if (Character.isLetterOrDigit(ch)) {
                result = result + ch;
            }

            // Opening bracket
            else if (ch == '(') {
                stack.push(ch);
            }

            // Closing bracket
            else if (ch == ')') {

                while (!stack.isEmpty() && stack.peek() != '(') {
                    result = result + stack.pop();
                }

                stack.pop();
            }

            // Operator
            else {
                while (!stack.isEmpty()
                        && priority(stack.peek()) >= priority(ch)) {

                    result = result + stack.pop();
                }

                stack.push(ch);
            }
        }

        // Empty stack
        while (!stack.isEmpty()) {
            result = result + stack.pop();
        }

        return result;
    }

    // Q2: Postfix Evaluation
    static int evaluatePostfix(String exp) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {

            char ch = exp.charAt(i);

            // Number
            if (Character.isDigit(ch)) {
                stack.push(ch - '0');
            }

            // Operator
            else {

                int b = stack.pop();
                int a = stack.pop();

                switch (ch) {

                    case '+':
                        stack.push(a + b);
                        break;

                    case '-':
                        stack.push(a - b);
                        break;

                    case '*':
                        stack.push(a * b);
                        break;

                    case '/':
                        stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== EXPRESSION CONVERSION & EVALUATION =====");
            System.out.println("1. Infix to Postfix");
            System.out.println("2. Postfix Evaluation");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                System.out.print("Enter Infix Expression: ");
                String infix = sc.nextLine();

                String postfix = infixToPostfix(infix);

                System.out.println("Postfix Expression: " + postfix);
            }

            else if (choice == 2) {

                System.out.print("Enter Postfix Expression: ");
                String postfix = sc.nextLine();

                int result = evaluatePostfix(postfix);

                System.out.println("Final Result: " + result);
            }

            else if (choice == 3) {

                System.out.println("Program ended.");
                break;
            }

            else {
                System.out.println("Invalid choice");
            }
        }

        sc.close();
    }
}