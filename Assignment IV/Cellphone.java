// -----------------------------------------------------
// Assignment 4
// Question: 2
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------
import java.util.Scanner;

/**
 * Zafir Khalid - 40152164
 * COMP 249
 * Assignment 4
 * Due Date: Friday Dec 4, 2020
 */


 // This class creates cellphone objects that can store various information
 // such as Serial number, brand, year and price
 // It also has methods to support the user

public class Cellphone implements Cloneable{
    
    private long serialNum;
    private String brand;
    private int year;
    private double price;


    /**
     * Parameterized Constructor - Initializes all attributes to values provided by the user
     * @param serialNum - long, the serial number of the cellphone
     * @param brand - String, the brand name of the cellphone
     * @param year - int, the year the cellphone was manufactured
     * @param price - double, the market price of the cellphone
     */
    public Cellphone(long serialNum, String brand, int year, double price){
        this.brand = brand;
        this.year = year;
        this.price = price;
        this.serialNum = serialNum;
    }

    /**
     * Copy Constructor - Initializes all attributes to values from another Cellphone object
     * @param anotherCellphone - Cellphone, another cellphone object to copy values from
     * @param serialNum - long, the serial number the new cellphone object should have
     */
    public Cellphone(Cellphone anotherCellphone, long serialNum){
        this.brand = anotherCellphone.brand;
        this.year = anotherCellphone.year;
        this.price = anotherCellphone.price;
        this.serialNum = serialNum;
    }

    /**
     * Clone method to create a deep copy of another cellphone object
     * @return - Cellphone, returns a deep copy of the calling cellphone object
     */
    public Cellphone clone() throws CloneNotSupportedException{
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter the serial number of the cellphone to be created: ");
        long serialNum = keyboard.nextLong();
        Cellphone newCellphone = (Cellphone)super.clone();
        newCellphone.setSerialNum(serialNum);
        keyboard.close();
        return(newCellphone);
    }

    /**
     * A toString method to print the attributes of a Cellphone
     * @return - String, stating the attributes of a Cellphone
     */
    public String toString(){
        return(this.serialNum + ": " + this.brand + " " + this.price + "$ " + this.year);
    }


    /**
     * Checks the equality between two Cellphone objects
     * @param anotherObject - the Cellphone to be compared to the calling object
     * @return Boolean, true if the all the attributes (except serialNum) of the two objects match
     */
    public boolean equals(Object anotherObject){
        if(anotherObject == (null)){
            return(false);
        }
        else if(this.getClass() != anotherObject.getClass()){
            return(false);
        }
        else{
            Cellphone anotherCellphone = (Cellphone)anotherObject;
            
            boolean boolBrand = this.brand.equals(anotherCellphone.brand);
            boolean boolPrice = this.price == anotherCellphone.price;
            boolean boolYear = this.year == anotherCellphone.year;

            return(boolBrand&&boolPrice&&boolYear);
        }
    }

    /**
     * Get back the serialNum attribute of a Cellphone Object
     * @return - long, the serialNum of the calling Cellphone object
     */
    public long getSerialNum(){
        return(this.serialNum);
    }

    /**
     * Get back the brand attribute of a Cellphone Object
     * @return - String, the brand of the calling Cellphone object
     */
    public String getBrand(){
        return(this.brand);
    }

    /**
     * Get back the year attribute of a Cellphone Object
     * @return - int, the serialNum of the calling Cellphone object
     */
    public int getYear(){
        return(this.year);
    }

    /**
     * Get back the price attribute of a Cellphone Object
     * @return - double, the price of the calling Cellphone object
     */  
    public double getPrice(){
        return(this.price);
    }

    /**
     * Change the serialNum attribute of a Cellphone to a new one
     * @param serialNum - long, the new serialNum attribute to change to
     */
    public void setSerialNum(long serialNum){
        this.serialNum = serialNum;
    }

    /**
     * Change the brand attribute of a Cellphone to a new one
     * @param brand - String, the new brand attribute to change to
     */
    public void setBrand(String brand){
        this.brand = brand;
    }

    /**
     * Change the year attribute of a Cellphone to a new one
     * @param year - int, the new year attribute to change to
     */
    public void setYear(int year){
        this.year = year;
    }

    /**
     * Change the price attribute of a Cellphone to a new one
     * @param price - double, the new price attribute to change to
     */
    public void setPrice(double price){
        this.price = price;
    }






}
