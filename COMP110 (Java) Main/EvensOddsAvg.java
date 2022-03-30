// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (March 30th, 2022)

// Importing Scanner class
import java.util.Scanner;

// A program in a class EvensOddsAvg that counts the integers that are below the average of the even and odd numbers and below the average.
public class EvensOddsAvg {
    public static void main(String[] args) {
        // Declaring the array of integers with the size of 15
        int[] numbers = new int[15];
        // Creating a Scanner object
        Scanner scanner = new Scanner(System.in);
        // Looping through the array of integers
        for (int i = 0; i < 15; i++) {
            // Asking the user to enter the numbers
            numbers[i] = scanner.nextInt();
        }
        // Declaring the variables for the sum, even, and odd numbers
        int sum = 0;
        int even = 0;
        int odd = 0;
        // Looping through the array of integers
        for (int i = 0; i < 15; i++) {
            // Verifying if the number is even
            if (numbers[i] % 2 == 0) {
                // Incrementing the even number
                even++;
            } else {
                // Incrementing the odd number
                odd++;
            }
            // Adding the number to the sum
            sum = sum + numbers[i];
        }
        // Printing out the results
        System.out.println("Count of odd numbers " + odd);
        System.out.println("Count of even numbers: " + even);
        System.out.println("Numbers below average include: ");
        // Looping through the array of integers
        for (int i = 0; i < 15; i++) {
            // Verifying if the number is below the average
            if (numbers[i] < sum / 15) {
                // Printing out the number
                System.out.println("" + numbers[i]);
            }
        }
    }
}