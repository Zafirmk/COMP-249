// -----------------------------------------------------
// Part: 1 (Helicopter Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------

/**
 * Package containing Helicopter and Quadcopter classes
 */
package Copters;
import AirplanePackage.Airplane;
import FlyingObjectsPackage.FlyingObjects;
/**
 * Helicopter Class
 */

public class Helicopter extends Airplane{
    
    protected int numberOfCylinders;
    protected int creationYear;
    protected int passengerCapacity;

    /**
     * Default Constructor - Initializes all attributes to some valid type
     */
    public Helicopter(){
        super();
        this.numberOfCylinders = 0;
        this.creationYear = 2000;
        this.passengerCapacity = 0;
    }

    /**
     * Parameterized Constructor - Initializes all attributes to values provided by the user
     * @param brand - String, the brand of the Helicopter
     * @param price - double, the price of the Helicopter
     * @param horsePower - int, the horse power of the Helicopter
     * @param numberOfCylinders - int, the number of cylinders on the Helicopter
     * @param creationYear - int, the manufacturing year of the Helicopter
     * @param passengerCapacity - int, the passenger capacity of the Helicopter
     */
    public Helicopter(String brand, double price, int horsePower, int numberOfCylinders, int creationYear, int passengerCapacity){
        super(brand, price, horsePower);
        this.numberOfCylinders = numberOfCylinders;
        this.creationYear = creationYear;
        this.passengerCapacity = passengerCapacity;
    }

    /**
     * Copy Constructor - Intializes all attributes to values of another Helicopter provided by the user
     * @param anotherHelicopter - Helicopter, another Helicopter object to copy from
     */
    public Helicopter(Helicopter anotherHelicopter){
        super(anotherHelicopter);
        this.numberOfCylinders = anotherHelicopter.numberOfCylinders;
        this.creationYear = anotherHelicopter.creationYear;
        this.passengerCapacity = anotherHelicopter.passengerCapacity;
    }

    /**
     * Get back the brand attribute of an Helicopter
     * @return - int, the number of cylinders of the Helicopter
     */
    public int getNumberOfCylinders(){
        return(this.numberOfCylinders);
    }

    /**
     * Get back the creation year attribute of an Helicopter
     * @return - int, the creation year of the Helicopter
     */
    public int getCreationYear(){
        return(this.creationYear);
    }

    /**
     * Get back the passenger capacity attribute of an Helicopter
     * @return - int, passenger capacity of the Helicopter
     */
    public int getPassengerCapacity(){
        return(this.passengerCapacity);
    } 

    /**
     * Change the numberOfCylinders attribute of an Helicopter to a new one
     * @param newNumberOfCylinders - int, the new numberOfCylinders attribute to change to
     */
    public void setNumberOfCylinders(int newNumberOfCylinders){
        this.numberOfCylinders = newNumberOfCylinders;
    }
    
    /**
     * Change the creationYear attribute of an Helicopter to a new one
     * @param newCreationYear - int, the new creationYear attribute to change to
     */
    public void setCreationYear(int newCreationYear){
        this.creationYear = newCreationYear;
    }

    /**
     * Change the passengerCapacity attribute of an Helicopter to a new one
     * @param newPassengerCapacity - int, the new passengerCapacity attribute to change to
     */
    public void setPassengerCapacity(int newPassengerCapacity){
        this.passengerCapacity = newPassengerCapacity;
    }

    /**
     * A toString method to print the attributes of an Helicopter
     * @return - String, stating the attributes of an Helicopter
     */
    public String toString(){
        return(super.toString() + ". It has " + this.numberOfCylinders + " cylinders, created in " + this.creationYear + " with a passenger capacity of " + this.passengerCapacity);
    }
    
    /**
     * Checks the equality between two Helicopter objects
     * @param anotherObject - the Helicopter to be compared to the calling object
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
            Helicopter anotherHelicopter = (Helicopter)anotherObject;
            
            boolean boolNumberOfCylinders = this.numberOfCylinders == anotherHelicopter.numberOfCylinders;
            boolean boolCreationYear = this.creationYear == anotherHelicopter.creationYear;
            boolean boolPassengerCapacity = this.passengerCapacity == anotherHelicopter.passengerCapacity;

            return(super.equals(anotherHelicopter)&&boolNumberOfCylinders&&boolCreationYear&&boolPassengerCapacity);
        }
    }

    /**
     * Method to deep copy an object of type FlyingObject (Helicopter)
     * @param anObject - The flying object that needs to be copied
     * @return copiedObject - The new copied object
     */
    public FlyingObjects copyFlyingObject(FlyingObjects anObject) {
        Helicopter toReturn = new Helicopter((Helicopter)anObject);
        return(toReturn);
    }




}