package se.lexicon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //calculatorInterFace();
        OptionalCalculator();
    }

    public static void OptionalCalculator() {
        boolean wantToContinue = true;
        String equation = "";
        int result, number1;
        char operator;
        while (wantToContinue) {
            System.out.println("Start your calcualtion");
            result = newNumber();
            equation += result + " ";
            System.out.print(equation);
            while (true) {
                operator = newChar();
                if (operator == '=') {
                    break;
                } else if (!isAnOperator(operator)){
                    System.out.println("Not a valid input");
                    continue;
                }
                System.out.print(equation + operator + " ");
                number1 = newNumber();
                equation += operator + " " + number1 + " ";
                System.out.print(equation);
                result = (int) calculation(result,operator,number1);
            }
            System.out.println(equation + "= " +result);
            equation = "";
            wantToContinue = !newCalculation();
        }
    }

    public static boolean isAnOperator (char operator) {
        return  operator == '+' || operator == '-' || operator == '/' || operator == '*';
    }

   // public static boolean notANumber (int number)


    public static char newChar () {
        Scanner sc = new Scanner(System.in);
        //System.out.print("For adding a new operator enter one, or to get your result enter \"=\": ");
        char operator = sc.next().charAt(0);
        return operator;
    }

    public static int newNumber() {
        Scanner sc = new Scanner(System.in);
        //System.out.print("Enter a number: ");
        return sc.nextInt();
    }

    public static boolean newCalculation() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to do a new calculation?");
        return sc.next().charAt(0) == 'n' || sc.next().charAt(0) == 'N';
    }

    public static double calculation(double firstNumber, char operator, double secondNumber) {
        return switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> 0;
        };
    }

}































/*


    public static void calculatorInterFace() {
        Scanner sc = new Scanner(System.in);
        boolean wantToContinue = true;
        while (wantToContinue) {
            System.out.print("Enter the first number: ");
            int firstNumber = sc.nextInt();
            System.out.print("Enter the operator: ");
            char operator = sc.next().charAt(0);
            if (!isAChar(operator)) {
                System.out.println("Invalid operator, try again.");
                continue;
            }
            System.out.print("Enter the second number: ");
            int secondNumber = sc.nextInt();
            System.out.println("= " + calculation(firstNumber, operator, secondNumber));
            wantToContinue = newCalculation();
        }
    }

    public static boolean isAChar (char ch) {
        return  ch == '+' || ch == '-' || ch == '/' || ch == '*';
    }

    public static boolean newCalculation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Do you want to do a new calculation? :");
        return switch (scanner.next().charAt(0)) {
            case 'n', 'N' -> false;
            default -> true;
        };
    }

    public static double calculation(double firstNumber, char operator, double secondNumber) {
        return switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> 0;
        };
    }

    public static boolean operatorValidator(char operator) {
        return switch (operator) {
            case '+', '-', '*', '/' -> true;
            default -> false;
        };
    }
}

*/
