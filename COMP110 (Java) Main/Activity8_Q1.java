// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (April 20th, 2022)

// Code used to demonstrate the result.
public class Activity8_Q1 {
    // Main method
    public static void main(String[] args) {
        A();
    }
    // Method A
    public static void A() {
        try {
            B();    //Method A calls method B
        }
        catch (Exception e) {
            System.out.println("Exception caught in A");
        }
    }
    // Method B
    public static void B() throws Exception {
        C();    // Method B calls method C
    }
    // Method C
    public static void C() throws Exception {
        // Method C throws an Exception
        Exception e = new Exception();
        throw(e);
    }
}
/*
CONSOLE OUTPUT: Exception caught in A.
EXPLANATION:
All three methods can be declared as throws, and the exception can be caught outside all three methods when method A is invoked.
If method C does not catch the exception, it can be caught in methods B, A, or even outside A.
This is due to the fact that we may specify throws for method C and catch the exception in method B.
We may add throws declarations to methods C and B, and then catch the Exception in A.
 */