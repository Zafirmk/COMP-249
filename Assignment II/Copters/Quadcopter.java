// -----------------------------------------------------
// Part: 1 (Quadcopter Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package Copters;
import FlyingObjectsPackage.FlyingObjects;
/**
 * Quadcopter Class
 */

public class Quadcopter extends Helicopter{
    
    protected int maxFlyingSpeed;

    /**
     * Default Constructor - Initializes all attributes to some valid type
     */
    public Quadcopter(){
        super();
        this.maxFlyingSpeed = 0;
    }

    /**
     * Parameterized Constructor - Initializes all attributes to values provided by the user
     * @param brand - String, the brand of the Quadcopter
     * @param price - double, the price of the Quadcopter
     * @param horsePower - int, the horse power of the Quadcopter
     * @param numberOfCylinders - int, the number of cylinders on the Quadcopter
     * @param creationYear - int, the manufacturing year of the Quadcopter
     * @param passengerCapacity - int, the passenger capacity of the Quadcopter
     * @param maxFlyingSpeed - int, maximum flying speed of the Quadcopter
     */
    public Quadcopter(String brand, double price, int horsePower, int numberOfCylinders, int creationYear, int passengerCapacity, int maxFlyingSpeed){
        super(brand, price, horsePower, numberOfCylinders, creationYear, passengerCapacity);
        this.maxFlyingSpeed = maxFlyingSpeed;
    }

    /**
     * Copy Constructor - Intializes all attributes to values of another Quadcopter provided by the user
     * @param anotherQuadcopter - Quadcopter, another Quadcopter object to copy from
     */
    public Quadcopter(Quadcopter anotherQuadcopter){
        super(anotherQuadcopter);
        this.maxFlyingSpeed = anotherQuadcopter.maxFlyingSpeed;
    }

    /**
     * Get back the maxFlyingSpeed attribute of an Quadcopter
     * @return - int, the max flying speed of the Quadcopter
     */
    public int getMaxFlyingSpeed(){
        return(this.maxFlyingSpeed);
    }

    /**
     * Change the maxFlyingSpeed attribute of an Quadcopter to a new one
     * @param newMaxFlyingSpeed - int, the new maxFlyingSpeed attribute to change to
     */
    public void setMaxFlyingSpeed(int newMaxFlyingSpeed){
        this.maxFlyingSpeed = newMaxFlyingSpeed;
    }

    /**
     * A toString method to print the attributes of an Quadcopter
     * @return - String, stating the attributes of an Quadcopter
     */
    public String toString(){
        return(super.toString() + ". It has a max flying speed of " + this.maxFlyingSpeed);
    }

    /**
     * Checks the equality between two Quadcopter objects
     * @param anotherObject - the Quadcopter to be compared to the calling object
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
            Quadcopter anotherQuadcopter = (Quadcopter)anotherObject;
            
            boolean boolMaxFlyingSpeed = this.maxFlyingSpeed == anotherQuadcopter.maxFlyingSpeed;


            return(super.equals(anotherQuadcopter)&&boolMaxFlyingSpeed);
        }
    }

    /**
     * Method to deep copy an object of type FlyingObject (Quadcopter)
     * @param anObject - The flying object that needs to be copied
     * @return copiedObject - The new copied object
     */
    public FlyingObjects copyFlyingObject(FlyingObjects anObject) {
        Quadcopter toReturn = new Quadcopter((Quadcopter)anObject);
        return(toReturn);
    }


}
