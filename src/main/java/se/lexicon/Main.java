package se.lexicon;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calculatorInterFace();
    }

    public static void calculatorInterFace() {
        Scanner sc = new Scanner(System.in);
        boolean wantToContinue = true;
        while (wantToContinue) {
            System.out.print("Enter the first number: ");
            int firstNumber = sc.nextInt();
            System.out.print("Enter the operator: ");
            char operator = sc.next().charAt(0);
            if (!operatorValidator(operator)) {
                System.out.println("Invalid operator, try again.");
                continue;
            }
            System.out.print("Enter the second number: ");
            int secondNumber = sc.nextInt();
            System.out.println("Do you want to do another calculation?");
            calculation(firstNumber, operator, secondNumber);
        }
    }

    public static int calculation (int firstNumber, char operator, int secondNumber) {
         return switch (operator) {
            case '+' -> firstNumber + secondNumber;
            case '-' -> firstNumber - secondNumber;
            case '*' -> firstNumber * secondNumber;
            case '/' -> firstNumber / secondNumber;
            default -> 0;
            };
    }
     public static boolean operatorValidator (char operator) {
        return switch (operator) {
            case '+', '-', '*', '/' -> true;
            default -> false;
        };
     }



}