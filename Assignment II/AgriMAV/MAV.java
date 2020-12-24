// -----------------------------------------------------
// Part: 1 (MAV Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package AgriMAV;
import UAVPackage.UAV;
import FlyingObjectsPackage.FlyingObjects;
/**
 * MAV Class
 */

public class MAV extends UAV{

    protected String model;
    protected double size;

    /**
     * Default Constructor - Initializes all attributes to some valid type
     */
    public MAV(){
        super();
        this.model = "";
        this.size = 0.0;
    }

    /**
     * Parameterized Constructor - Initializes all attributes to values provided by the user
     * @param weight - double, the weight of the MAV
     * @param price - double, the price of the MAV
     * @param model - String, the model of the MAV
     * @param size - int, the size of the MAV
     */
    public MAV(double weight, double price, String model, double size){
        super(weight, price);
        this.model = model;
        this.size = size;
    }

    /**
     * Copy Constructor - Intializes all attributes to values of another MAV provided by the user
     * @param anotherMAV - MAV, another MAV object to copy from
     */
    public MAV(MAV anotherMAV){
        super(anotherMAV);
        this.model = anotherMAV.model;
        this.size = anotherMAV.size;
    }

    /**
     * Get back the model attribute of an MAV
     * @return - String, the model of the MAV
     */
    public String getModel(){
        return(this.model);
    }

    /**
     * Get back the size attribute of an MAV
     * @return - double, the size of the MAV
     */
    public double getSize(){
        return(this.size);
    }

     /**
     * Change the model attribute of an MAV to a new one
     * @param newModel - String, the new model attribute to change to
     */
    public void setModel(String newModel){
        this.model = newModel;
    }
    
    /**
     * Change the size attribute of an MAV to a new one
     * @param newSize - double, the new size attribute to change to
     */
    public void setSize(double newSize){
        this.size = newSize;
    }

    /**
     * A toString method to print the attributes of an MAV
     * @return - String, stating the attributes of an MAV
     */
    public String toString(){
        return(super.toString() + ". It has a model number of " + this.model + ", and a size of " + this.size);
    }

    /**
     * Checks the equality between two MAV objects
     * @param anotherObject - the MAV to be compared to the calling object
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
            MAV anotherMAV = (MAV)anotherObject;
            
            boolean boolModel = this.model.equals(anotherMAV.model);
            boolean boolSize = this.size == anotherMAV.size;

            return(super.equals(anotherMAV)&&boolModel&&boolSize);
        }
    }

    /**
     * Method to deep copy an object of type FlyingObject (MAV)
     * @param anObject - The flying object that needs to be copied
     * @return copiedObject - The new copied object
     */
    public FlyingObjects copyFlyingObject(FlyingObjects anObject) {
        MAV toReturn = new MAV((MAV)anObject);
        return(toReturn);
    }
}