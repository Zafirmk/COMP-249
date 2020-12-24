// -----------------------------------------------------
// Part: 1 (Multirotor Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package MultirotorPackage;
import Copters.Helicopter;
import FlyingObjectsPackage.FlyingObjects;
/**
 * Multirotor Class
 */

public class Multirotor extends Helicopter{

    protected int numberOfRotors;

    /**
     * Default Constructor - Initializes all attributes to some valid type
     */
    public Multirotor(){
        super();
        this.numberOfRotors = 0;
    }

    /**
     * Parameterized Constructor - Initializes all attributes to values provided by the user
     * @param brand - String, the brand of the Helicopter
     * @param price - double, the price of the Helicopter
     * @param horsePower - int, the horse power of the Helicopter
     * @param numberOfCylinders - int, the number of cylinders on the Helicopter
     * @param creationYear - int, the manufacturing year of the Helicopter
     * @param passengerCapacity - int, the passenger capacity of the Helicopter
     * @param numberOfRotors - int, the number of Rotors on the multirotor
     */
    public Multirotor(String brand, double price, int horsePower, int numberOfCylinders, int creationYear, int passengerCapacity, int numberOfRotors){
        super(brand, price, horsePower, numberOfCylinders, creationYear, passengerCapacity);
        this.numberOfRotors = numberOfRotors;
    }

    /**
     * Copy Constructor - Intializes all attributes to values of another Helicopter provided by the user
     * @param anotherMultirotor - Helicopter, another Helicopter object to copy from
     */
    public Multirotor(Multirotor anotherMultirotor){
        super(anotherMultirotor);
        this.numberOfRotors = anotherMultirotor.numberOfRotors;
    }

    /**
     * Get back the numberOfRotors attribute of a Helicopter
     * @return - int, the number of Rotors of the Helicopter
     */
    public int getNumberOfRotors(){
        return(this.numberOfRotors);
    }

    /**
     * Change the numberOfRotors attribute of a Helicopter to a new one
     * @param newNumberOfRotors - int, the new numberOfRotors attribute to change to
     */
    public void setNumberOfRotors(int newNumberOfRotors){
        this.numberOfRotors = newNumberOfRotors;
    }

    /**
     * A toString method to print the attributes of an Helicopter
     * @return - String, stating the attributes of an Helicopter
     */
    public String toString(){
        return(super.toString() + ". It also has " + this.numberOfRotors + " rotors.");
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
            Multirotor anotherMultirotor = (Multirotor)anotherObject;
            
            boolean boolNumberOfMultiRotors = this.numberOfRotors == anotherMultirotor.numberOfRotors;

            return(super.equals(anotherMultirotor)&&boolNumberOfMultiRotors);
        }
    }

    /**
     * Method to deep copy an object of type FlyingObject (Helicopter)
     * @param anObject - The flying object that needs to be copied
     * @return copiedObject - The new copied object
     */
    public FlyingObjects copyFlyingObject(FlyingObjects anObject) {
        Multirotor toReturn = new Multirotor((Multirotor)anObject);
        return(toReturn);
    }
}