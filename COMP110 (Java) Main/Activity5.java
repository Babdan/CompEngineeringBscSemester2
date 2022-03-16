// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (March 16th, 2022)

// Test code for Activity 5
class TestSample {
    public static void main (String[] args) {
        Employee emp = new Employee("John Appleseed",24650,1984,"M0001");
        System.out.println(emp);
    }
}
// Employee class whose objects are records for employees
class Employee extends Person {
    // Private fields
    private double annualSalary;
    private int yearHired;
    private String id;
    // Constructor
    public Employee(String name,double annualSalary,int yearHired,String id) {
        super(name);
        this.annualSalary = annualSalary;
        this.yearHired = yearHired;
        this.id = id;
    }
    // Get annual salary
    public double getAnnualSalary() {
        return annualSalary;
    }// Get year hired
    public int getYearHired() {
        return yearHired;
    }
    // Get ID
    public String getID() {
        return id;
    }
    // Override equals method
    public void setId(String id) {
        this.id = id;
    }
    // Override annual salary
    public void setAnnualSalary() {
        this.annualSalary = annualSalary;
    }
    // Override years hired
    public void setYearHired(int yearHired) {
        this.yearHired = yearHired;
    }
    // Used to print the employee's information by converting to string
    public String toString() {
        return "Employee ID: "+id+" Name: "+getName()+" Annual salary: $"+annualSalary+
                " Year Hired: "+yearHired;
    }
}
// Person class
class Person {
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}