// By Bogdan Itsam Dorantes-Nikolaev, COMP110, Instructor: Prof. Adem Karahoca (April 17th, 2022)

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
    // toString method
    @Override
    public String toString() {
        return "GameStopItem{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemQuantity=" + itemQuantity +
                ", forSale=" + forSale +
                '}';
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
    //toString method
    @Override
    public String toString() {
        return "DVD{" +
                "platform='" + platform + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", region='" + region + '\'' +
                '}';
    }
    //method to print out the information of a DVD
    public void printDVDInfo(DVD dvd) {
        System.out.println("DVD ID: " + dvd.itemID);
        System.out.println("DVD Name: " + dvd.itemName);
        System.out.println("DVD Price: " + dvd.itemPrice);
        System.out.println("DVD Quantity: " + dvd.itemQuantity);
        System.out.println("DVD For Sale: " + dvd.forSale);
        System.out.println("DVD Platform: " + dvd.platform);
        System.out.println("DVD Genre: " + dvd.genre);
        System.out.println("DVD Release Date: " + dvd.releaseDate);
        System.out.println("DVD Region: " + dvd.region);
    }
    //getters and setters
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
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
    //toString method
    @Override
    public String toString() {
        return "DigitalKey{" +
                "platform='" + platform + '\'' +
                ", region='" + region + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
    //method to print out the information of a DigitalKey
    public void printDigitalKeyInfo(DigitalKey digitalKey) {
        System.out.println("DigitalKey ID: " + digitalKey.itemID);
        System.out.println("DigitalKey Name: " + digitalKey.itemName);
        System.out.println("DigitalKey Price: " + digitalKey.itemPrice);
        System.out.println("DigitalKey Quantity: " + digitalKey.itemQuantity);
        System.out.println("DigitalKey For Sale: " + digitalKey.forSale);
        System.out.println("DigitalKey Platform: " + digitalKey.platform);
        System.out.println("DigitalKey Genre: " + digitalKey.genre);
        System.out.println("DigitalKey Release Date: " + digitalKey.releaseDate);
        System.out.println("DigitalKey Region: " + digitalKey.region);
    }
    //getters and setters
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public String getRegion() {
        return region;
    }
    public void setRegion(String region) {
        this.region = region;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
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
    //toString method
    @Override
    public String toString() {
        return "Device{" +
                "manufacturer='" + manufacturer + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", storage='" + storage + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", specifications='" + specifications + '\'' +
                '}';
    }
    //method to print out the information of a Device
    public void printDeviceInfo(Device device) {
        System.out.println("Device ID: " + device.itemID);
        System.out.println("Device Name: " + device.itemName);
        System.out.println("Device Price: " + device.itemPrice);
        System.out.println("Device Quantity: " + device.itemQuantity);
        System.out.println("Device For Sale: " + device.forSale);
        System.out.println("Device Manufacturer: " + device.manufacturer);
        System.out.println("Device Type: " + device.type);
        System.out.println("Device Model: " + device.model);
        System.out.println("Device Storage: " + device.storage);
        System.out.println("Device Year of Manufacture: " + device.yearOfManufacture);
        System.out.println("Device Specifications: " + device.specifications);
    }
    //getters and setters
    public String getManufacturer() {
        return manufacturer;
    }
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public String getStorage() {
        return storage;
    }
    public void setStorage(String storage) {
        this.storage = storage;
    }
    public String getYearOfManufacture() {
        return yearOfManufacture;
    }
    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }
    public String getSpecifications() {
        return specifications;
    }
    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
}
