// -----------------------------------------------------
// Part: 1 (Agricultural Drone Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package AgriMAV;

import UAVPackage.UAV;
import FlyingObjectsPackage.FlyingObjects;
/**
 * Agricultural Drone Class
 */

public class AgriculturalDrone extends UAV{
    
    protected String brand;
    protected int carryCapacity;

    /**
     * Default Constructor - Initializes all attributes to some valid type
     */
    public AgriculturalDrone(){
        super();
        this.brand = "";
        this.carryCapacity = 0;
    }

    /**
     * Parameterized Constructor - Initializes all attributes to values provided by the user
     * @param weight - double, the weight of the agricultural drone
     * @param price - double, the price of the agricultural drone
     * @param brand - String, the brand of the agricultural drone
     * @param carryCapacity - int, the carry capacity of the agricultural drone
     */
    public AgriculturalDrone(double weight, double price, String brand, int carryCapacity){
        super(weight, price);
        this.brand = brand;
        this.carryCapacity = carryCapacity;
    }

    /**
     * Copy Constructor - Intializes all attributes to values of another agricultural drone provided by the user
     * @param anotherAgriculturalDrone - AgriculturalDrone, another agricultural drone object to copy from
     */
    public AgriculturalDrone(AgriculturalDrone anotherAgriculturalDrone){
        super(anotherAgriculturalDrone);
        this.brand = anotherAgriculturalDrone.brand;
        this.carryCapacity = anotherAgriculturalDrone.carryCapacity;
    }

    /**
     * Get back the brand attribute of an agricultural drone
     * @return - String, the brand of the agricultural drone
     */
    public String getBrand(){
        return(this.brand);
    }

    /**
     * Get back the carry capacity attribute of an agricultural drone
     * @return - int, the carry capacity of the agricultural drone
     */
    public int getCarryCapacity(){
        return(this.carryCapacity);
    }

    /**
     * Change the brand attribute of an agricultural drone to a new one
     * @param newBrand - String, the new brand attribute to change to
     */
    public void setBrand(String newBrand){
        this.brand = newBrand;
    }

    /**
     * Change the carry capacity attribute of an agricultural drone to a new one
     * @param newCarryCapacity - int, the new carry capacity attribute to change to
     */
    public void setCarryCapacity(int newCarryCapacity){
        this.carryCapacity = newCarryCapacity;
    }

    
    /**
     * A toString method to print the attributes of an agricultural drone
     * @return - String, stating the attributes of an agricultural drone
     */
    public String toString(){
        return(super.toString() + ". It is made by " + this.brand + " and has a carry capacity of " + this.carryCapacity);
    }

    /**
     * Checks the equality between two agricultural drone objects
     * @param anotherObject - the agricultural drone to be compared to the calling object
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
            AgriculturalDrone anotherAgriculturalDrone = (AgriculturalDrone)anotherObject;
            
            boolean boolBrand = this.brand.equals(anotherAgriculturalDrone.brand);
            boolean boolCarryCapacity = this.carryCapacity == anotherAgriculturalDrone.carryCapacity;


            return(super.equals(anotherAgriculturalDrone)&&boolBrand&&boolCarryCapacity);
        }
    }

    /**
     * Method to deep copy an object of type FlyingObject (AgriculturalDrone)
     * @param anObject - The flying object that needs to be copied
     * @return copiedObject - The new copied object
     */
    public FlyingObjects copyObject(FlyingObjects anObject) {
        AgriculturalDrone copiedObject = new AgriculturalDrone((AgriculturalDrone)anObject);
        return(copiedObject);
    }
}