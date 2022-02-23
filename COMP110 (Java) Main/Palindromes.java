// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (February 23rd, 2022)

import java.util.Scanner;

//A program that checks whether a given word is a palindrome
public class Palindromes {
    //main method that takes user input
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string that you want to check if it is a palindrome: ");
        String userInput = input.nextLine();
        System.out.println("The string is a palindrome?: " + isPalindrome(userInput));
    }
    //method that checks if the string is a palindrome
    public static boolean isPalindrome(String userInput) {
        //changing all characters to lowercase
        String lowercase = userInput.toLowerCase();
        //new string that will be used to reverse the user input
        String reverse = "";
        //for loop that reverses the user input
        for (int i = lowercase.length() - 1; i >= 0; i--) {
            reverse += lowercase.charAt(i);
        }
        //returns true if userInput is equal to reverse
        return lowercase.equals(reverse);
    }
}
