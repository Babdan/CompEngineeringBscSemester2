// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (March 30th, 2022)

// Importing the Scanner class
import java.util.Scanner;

// A program in a class StudentCount that counts the number of students who obtained marks above 50% in a test.
public class StudentCount {
    public static void main(String[] args) {
        // Initializing the Scanner object
        Scanner scanner = new Scanner(System.in);
        // Prompting the user to enter the number of students
        System.out.print("Enter the amount of students: ");
        int count = scanner.nextInt();
        // Initializing array used to store the marks
        double[] marks = new double[count];
        // Looping through each student
        for (int i = 0; i < count; i++) {
            System.out.print("Enter the marks for student №." + (i + 1) + ": ");
            marks[i] = scanner.nextDouble();
        }
        // Initializing the counter
        int minIndex = 0, maxIndex = 0;
        for (int i = 0; i < count; i++) {
            // Finding the index of the minimum and maximum marks
            if (marks[i] > marks[maxIndex]) maxIndex = i;
            if (marks[i] < marks[minIndex]) minIndex = i;
        }
        // Printing the results
        System.out.println("Highest among marks: " + marks[maxIndex]);
        System.out.println("Lowest among marks: " + marks[minIndex]);
        // Initializing the counter
        int countStudent =0;
        System.out.println("Marks above 50% of 500");
        // Looping through each student
        for (int i = 0; i < count; i++) {
            if (marks[i] >= 250) {
                System.out.println(marks[i]);
                countStudent+=1;
            }
        }
        System.out.println("In total "+countStudent+" student obtained marks above 50%");
    }
}