// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (April 15th, 2022)

//import scanner class
import java.util.Scanner;

// A program that will keep track of the items sold in a multi-storied electronics showroom
public class GameStopProgram {
    // main method that asks user if they wish to check the list of items or add an item to the list
    public static void main(String[] args) {
        System.out.println("Welcome to GameStop!");
        System.out.println("Please enter 'add' to add an item to the list.");
        //create scanner object
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        if (userInput.equals("add")) {
            addItem();
        }
        else {
            System.out.println("Please enter 'check' or 'add'.");
            main(args);
        }
    }
//addItem method that creates a new item object using GameStopItem class and adds it to the list
    public static void addItem() {
        Scanner input = new Scanner(System.in);
        //asking for itemID
        System.out.println("Please enter the item ID.");
        int itemID = input.nextInt();
        System.out.println("Please enter the name of the item you wish to add.");
        String itemName = input.nextLine();
        System.out.println("Please enter the price of the item you wish to add.");
        double itemPrice = input.nextDouble();
        System.out.println("Please enter the quantity of the item you wish to add.");
        int itemQuantity = input.nextInt();
        //is it for sale
        System.out.println("Is the item for sale? (y/n)");
        String isForSale = input.nextLine();
        boolean isForSaleBool = false;
        if (isForSale.equals("y")) {
            isForSaleBool = true;
        } else if (isForSale.equals("n")) {
            isForSaleBool = false;
        }
        else {
            System.out.println("Please enter 'y' or 'n'.");
            addItem();
        }
        //creating new item object
        //ask the user the type of the item, dvd, digitalkey or device
        System.out.println("Please enter the type of the item you wish to add to the list.");
        System.out.println("Enter 'dvd' for a DVD or 'digitalkey' for a digital key or 'device' for a device.");
        //create scanner object
        String userInput = input.nextLine();
        //if statements that decide which class to create an object from
        if (userInput.equals("dvd")) {
            System.out.println("Please enter the platform of the DVD.");
            String platform = input.nextLine();
            System.out.println("Please enter the genre of the DVD.");
            String genre = input.nextLine();
            System.out.println("Please enter the release date of the DVD.");
            String releaseDate = input.nextLine();
            System.out.println("Please enter the region of the DVD.");
            String region = input.nextLine();
            //create new object using DVD class
            DVD newDVD = new DVD(itemID, itemName, itemPrice, itemQuantity, isForSaleBool, platform, genre, releaseDate, region);
        }
        else if (userInput.equals("digitalkey")) {
            System.out.println("Please enter the platform of the digital key.");
            String platform = input.nextLine();
            System.out.println("Please enter the region of the digital key.");
            String region = input.nextLine();
            System.out.println("Please enter the genre of the digital key.");
            String genre = input.nextLine();
            System.out.println("Please enter the release date of the digital key.");
            String releaseDate = input.nextLine();
            //create new object using digital key class
            DigitalKey newDigitalKey = new DigitalKey(itemID, itemName, itemPrice, itemQuantity, isForSaleBool, platform, region, genre, releaseDate);
        }
        else if (userInput.equals("device")) {
            System.out.println("Please enter the manufacturer of the device.");
            String manufacturer = input.nextLine();
            System.out.println("Please enter the type of the device.");
            String type = input.nextLine();
            System.out.println("Please enter the model of the device.");
            String model = input.nextLine();
            System.out.println("Please enter the storage available on the device.");
            String storage = input.nextLine();
            System.out.println("Please enter the year of manufacture of the device.");
            String yearOfManufacture = input.nextLine();
            System.out.println("Please enter the year of specifications of the device.");
            String specifications = input.nextLine();
            //create new object using device class
            Device newDevice = new Device(itemID, itemName, itemPrice, itemQuantity, isForSaleBool, manufacturer, type, model, storage, yearOfManufacture, specifications);
        }
        else {
            System.out.println("Invalid input. Please try again.");
        }
    }
}
class GameStopItem extends GameStopProgram {
    boolean forSale;
    int itemID;
    String itemName;
    double itemPrice;
    int itemQuantity;
    //constructor
    public GameStopItem(int itemID, String itemName, double itemPrice, int itemQuantity, boolean forSale) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemQuantity = itemQuantity;
    }
    //method to print out the information of an item
    public void printItemInfo(GameStopItem item) {
        System.out.println("Item ID: " + item.itemID);
        System.out.println("Item Name: " + item.itemName);
        System.out.println("Item Price: " + item.itemPrice);
        System.out.println("Item Quantity: " + item.itemQuantity);
        System.out.println("Item For Sale: " + item.forSale);
    }
    //getters and setters
    public int getItemID() {
        return itemID;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getItemQuantity() {
        return itemQuantity;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }
    public boolean isForSale() {
        return forSale;
    }
    //method to make an item not for sale by changing given object forSale boolean to false
    public void makeItemNotForSale(GameStopItem item) {
        item.forSale = false;
    }
    //method to make an item for sale by changing given object forSale boolean to true
    public void makeItemForSale(GameStopItem item) {
        item.forSale = true;
    }
}
class DVD extends GameStopItem {
    String platform;
    String genre;
    String releaseDate;
    String region;
    //constructor
    public DVD(int itemID, String itemName, double itemPrice, int itemQuantity, boolean forSale, String platform, String genre, String releaseDate, String region) {
        super(itemID, itemName, itemPrice, itemQuantity, forSale);
        this.platform = platform;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.region = region;
    }
}
class DigitalKey extends GameStopItem {
    String platform;
    String region;
    String genre;
    String releaseDate;
    //constructor
    public DigitalKey(int itemID, String itemName, double itemPrice, int itemQuantity, boolean forSale, String platform, String region, String genre, String releaseDate) {
        super(itemID, itemName, itemPrice, itemQuantity, forSale);
        this.platform = platform;
        this.region = region;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }
}
class Device extends GameStopItem {
    String manufacturer;
    String type;
    String model;
    String storage;
    String yearOfManufacture;
    String specifications;
    //constructor
    public Device(int itemID, String itemName, double itemPrice, int itemQuantity, boolean forSale, String manufacturer, String type, String model, String storage, String yearOfManufacture, String specifications) {
        super(itemID, itemName, itemPrice, itemQuantity, forSale);
        this.manufacturer = manufacturer;
        this.type = type;
        this.model = model;
        this.storage = storage;
        this.yearOfManufacture = yearOfManufacture;
        this.specifications = specifications;
    }
}
