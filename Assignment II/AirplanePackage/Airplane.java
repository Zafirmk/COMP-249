// -----------------------------------------------------
// Part: 1 (Airplane Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package AirplanePackage;
import FlyingObjectsPackage.FlyingObjects;
/**
 * Airplane Class
 */

public class Airplane extends FlyingObjects{

    protected String brand;
    protected double price;
    protected int horsePower;

    /**
     * Default Constructor - Initializes all attributes to some valid type
     */
    public Airplane(){
        this.brand = "";
        this.price = 0.0;
        this.horsePower = 0;
    }

    /**
     * Parameterized Constructor - Initializes all attributes to values provided by the user
     * @param brand - String, the brand of the Airplane
     * @param price - double, the price of the Airplane
     * @param horsePower - int, the horse power of the Airplane
     */
    public Airplane(String brand, double price, int horsePower){
        this.brand = brand;
        this.price = price;
        this.horsePower = horsePower;
    }

    /**
     * Copy Constructor - Intializes all attributes to values of another Airplane provided by the user
     * @param anotherAirplane - Airplane, another Airplane object to copy from
     */
    public Airplane(Airplane anotherAirplane){
        this.brand = anotherAirplane.brand;
        this.price = anotherAirplane.price;
        this.horsePower = anotherAirplane.horsePower;
    }

    /**
     * Get back the brand attribute of an Airplane
     * @return - String, the brand of the Airplane
     */
    public String getBrand(){
        return(this.brand);
    }

    /**
     * Get back the price attribute of an Airplane
     * @return - double, the price of the Airplane
     */
    public double getPrice(){
        return(this.price);
    }

    /**
     * Get back the horse power attribute of an Airplane
     * @return - int, the horse power of the Airplane
     */
    public int getHorsePower(){
        return(this.horsePower);
    } 

     /**
     * Change the brand attribute of an Airplane to a new one
     * @param newBrand - String, the new brand attribute to change to
     */
    public void setBrand(String newBrand){
        this.brand = newBrand;
    }

     /**
     * Change the price attribute of an Airplane to a new one
     * @param newPrice - double, the new price attribute to change to
     */
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

     /**
     * Change the horsePower attribute of an Airplane to a new one
     * @param newHorsePower - int, the new horse power attribute to change to
     */
    public void setHorsePower(int newHorsePower){
        this.horsePower = newHorsePower;
    }

    /**
     * A toString method to print the attributes of an Airplane
     * @return - String, stating the attributes of an Airplane
     */
    public String toString(){
        return("This " + this.getClass().getSimpleName() + " is manufactured by " + this.getBrand() + ". It costs " + this.getPrice() + " and has horse power of " + this.getHorsePower());
    }

    /**
     * Checks the equality between two Airplane objects
     * @param anotherObject - the Airplane to be compared to the calling object
     * @return Boolean, true if the all the attributes of the two objects match
     */
    public boolean equals(Object anotherObject){
        if(anotherObject == (null)){
            return(false);
        }
        else if(this.getClass() != anotherObject.getClass()){
            return(false);
        }
        else{
            Airplane anotherAirplane = (Airplane)anotherObject;
            
            boolean boolBrand = this.brand.equals(anotherAirplane.brand);
            boolean boolPrice = this.price == anotherAirplane.price;
            boolean boolHorsePower = this.horsePower == anotherAirplane.horsePower;

            return(boolBrand&&boolPrice&&boolHorsePower);
        }
    }

    /**
     * Method to deep copy an object of type FlyingObject (Airplane)
     * @param anObject - The flying object that needs to be copied
     * @return copiedObject - The new copied object
     */
    public FlyingObjects copyObject(FlyingObjects anObject) {
        Airplane toReturn = new Airplane((Airplane)anObject);
        return(toReturn);
    }
}