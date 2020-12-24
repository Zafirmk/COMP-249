// -----------------------------------------------------
// Part: 1 (Flying Objects Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package FlyingObjectsPackage;
/**
 * Abstract parent class to encompass heirarchy of flying objects
 */

public abstract class FlyingObjects {
    
    /**
     * Abstract getPrice method, overridden in each class
     * @return double, price of a flying object
     */
    public abstract double getPrice();

    /**
     * Method to call the copy constructor of a flying object 
     * @param anObject - FlyingObjects, object to be copied
     * @return FlyingObject object that is later downcasted
     */
    public abstract FlyingObjects copyObject(FlyingObjects anObject);
}
