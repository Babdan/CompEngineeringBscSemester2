// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (March 31st, 2022)

// Importing necessary libraries
import java.util.*;

// A program in a class RichCount that counts the number of families that are considered rich
public class RichCount {
    // Main method
    public static void main(String[] args) {
        // Creating a scanner
    Scanner in=new Scanner(System.in);
    // Initializing variables
    int n,i,s;
    double income,savings,expenditure;
    // Asking the user for the number of families
    System.out.print("Enter the number of families: ");
    n=in.nextInt();
    Family[] fam=new Family[n];
    // Asking the user for the family's income, savings, and expenditure for each family looping through the array
    for(i=0;i<n;i++) {
        System.out.println("Family №."+(i+1)+": ");
        System.out.print("Enter family size: ");
        s=in.nextInt();
        System.out.print("Enter family income: ");
        income=in.nextDouble();
        fam[i]=new Family(income,s);
    }
    // Asking the user for the family's savings expenditures for each family looping through the array
    System.out.println("For all families");
    System.out.print("Enter average savings per person: ");
    savings=in.nextDouble();
    System.out.print("Enter family expenditures :");
    expenditure=in.nextDouble();
    System.out.println("The rich families are: ");
    for(i=0;i<n;i++)
        if(fam[i].isRich(savings,expenditure))
            System.out.println("Family "+(i+1)+" "+fam[i].toString());
    }
}

// A class Family that contains attributes of a family and methods to check if the family is considered rich
class Family extends RichCount {
    private double income;
    private int size;
    // Constructor
    public Family(double i, int s) {
        income=i;
        size=s;
    }
    // A method isRich that checks if the family is considered rich
    public boolean isRich(double exp, double sav) {
        if((exp+sav*size)>(0.6*income))
            return true;
        else
            return false;
    }
    // A method toString that returns the family's income and size
    public String toString() {
        return ("Income: " + income + "\nFamily size: " + size);
    }
}