// -----------------------------------------------------
// Part: 1 (UAV Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package UAVPackage;
import FlyingObjectsPackage.FlyingObjects;
/**
 * UAV Class
 */

public class UAV extends FlyingObjects{
    
    protected double weight;
    protected double price;

    /**
     * Default Constructor - Initializes all attributes to some valid type
     */
    public UAV(){
        this.weight = 0.0;
        this.price = 0.0;
    }

    /**
     * Parameterized Constructor - Initializes all attributes to values provided by the user
     * @param weight - double, the weight of the UAV
     * @param price - double, the price of the UAV
     */
    public UAV(double weight, double price){
        this.weight = weight;
        this.price = price;
    }

    /**
     * Copy Constructor - Intializes all attributes to values of another UAV provided by the user
     * @param anotherUAV - UAV, another UAV object to copy from
     */
    public UAV(UAV anotherUAV){
        this.weight = anotherUAV.weight;
        this.price = anotherUAV.price;
    }

    /**
     * Get back the weight attribute of an UAV
     * @return - int, the weight of the UAV
     */
    public double getWeight(){
        return(this.weight);
    }

    /**
     * Get back the price attribute of an UAV
     * @return - int, the price of the UAV
     */
    public double getPrice(){
        return(this.price);
    }

    /**
     * Change the weight attribute of an UAV to a new one
     * @param newWeight - int, the new weight attribute to change to
     */
    public void setWeight(double newWeight){
        this.weight = newWeight;
    }

    /**
     * Change the price attribute of an UAV to a new one
     * @param newPrice - double, the new price attribute to change to
     */
    public void setPrice(double newPrice){
        this.price = newPrice;
    }

    /**
     * A toString method to print the attributes of an UAV
     * @return - String, stating the attributes of an UAV
     */
    public String toString(){
        return("This " + this.getClass().getSimpleName() + " has a weight of " + this.getWeight() + " and a price of $" + this.getPrice());
    }

    /**
     * Checks the equality between two UAV objects
     * @param anotherObject - the UAV to be compared to the calling object
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
            UAV anotherUAV = (UAV)anotherObject;
            
            boolean boolWeight = this.weight == anotherUAV.weight;
            boolean boolPrice = this.price == anotherUAV.price;


            return(boolPrice&&boolWeight);
        }
    }

    /**
     * Method to deep copy an object of type FlyingObject (UAV)
     * @param anObject - The flying object that needs to be copied
     * @return copiedObject - The new copied object
     */
    public FlyingObjects copyObject(FlyingObjects anObject) {
        UAV toReturn = new UAV((UAV)anObject);
        return(toReturn);
    }

}