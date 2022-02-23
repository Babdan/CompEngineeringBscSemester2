// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (February 23rd, 2022)

import java.util.Scanner;

//A program that shows how many of each letter in the alphabet are used in a given sentence.
public class ProgrammingProjects {
//main method
   public static void main(String[] args) {
      //prompts user to enter a line of text ending with period
      System.out.print("Enter a line of text ending with period: ");
      // while loop to determine if the user entered a line of text ending with period
      while (true) {
         //creates a scanner object
         Scanner input = new Scanner(System.in);
         //stores the user input in a string variable
         String line = input.nextLine();
         //if statement to determine if the user entered a line of text ending with period
         if (line.endsWith(".")) {
            //calls the countLetters method
            countLetters(line);
            //breaks out of the while loop
            break;
         }
      }
   }
   //method to determine how many of each letter in alphabet is used in given string
   private static void countLetters(String userInput) {
    //creates a string array of the alphabet
      int[] arr = new int[26];
      //for loop to determine how many of each letter in alphabet is used in given string
      userInput = userInput.toLowerCase();
      for (int i = 0; i < userInput.length(); ++i)
         if (userInput.charAt(i) >= 'a' && userInput.charAt(i) <= 'z')
            ++arr[userInput.charAt(i) - 'a'];
      //prints out the number of each letter in alphabet
      for (int i = 0; i < 26; ++i)
         System.out.println((char)('a' + i) + ": " + arr[i]);
   }
}