package com.company;
// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (February 15th, 2022)

//scanner class
import java.util.Scanner;

public class Task1 {
    //main method that lets user select a method to call
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("1. Hypotenuse?");
        System.out.println("2. isMultiple?");
        System.out.println("1. Greatest common divisor (GCD)?");
        System.out.print("Please select a function to run: ");
        //user input
        int choice = input.nextInt();
        //switch statement to call methods
        switch (choice) {
            case 1:
                //prompt user for input
                System.out.println("Please enter the length of the first side: ");
                double side1 = input.nextDouble();
                System.out.println("Please enter the length of the second side: ");
                double side2 = input.nextDouble();
                //call hypotenuse method and print result
                System.out.println("The hypotenuse is " + hypotenuse(side1, side2));
                break;
            case 2:
                //prompt user for input
                System.out.println("Please enter the first integer: ");
                int num1 = input.nextInt();
                System.out.println("Please enter the second integer: ");
                int num2 = input.nextInt();
                //call isMultiple method and print result
                System.out.println("The second integer is a multiple of the first: " + isMultiple(num1, num2));
            case 3:
                //prompt user for input
                System.out.println("Please enter the first integer: ");
                int num3 = input.nextInt();
                System.out.println("Please enter the second integer: ");
                int num4 = input.nextInt();
                //call gcd method and print result
                System.out.println("The greatest common divisor is " + gcd(num3, num4));
                break;
            default:
                System.out.println("Invalid input");
        }
}
    //method hypotenuse that calculates the hypotenuse of a right triangle when the lengths of the other two sides are give
    public static double hypotenuse(double side1, double side2){
        return Math.sqrt(Math.pow(side1,2) + Math.pow(side2,2));
    }
    //method isMultiple that determines, for a pair of integers, whether the second integer is a multiple of the first
    public static boolean isMultiple(int num1, int num2){
        return num2 % num1 == 0;
    }
    //method gcd that returns the greatest common divisor of two integers using Euclid's algorithm
    public static int gcd(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        return gcd(num2, num1 % num2);
    }
}
