// -----------------------------------------------------
// Part: 2 (Driver Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package DriverPackage;

import FlyingObjectsPackage.FlyingObjects;
import AgriMAV.AgriculturalDrone;
import AgriMAV.MAV;
import AirplanePackage.Airplane;
import Copters.Helicopter;
import Copters.Quadcopter;
import MultirotorPackage.Multirotor;
import UAVPackage.UAV;
/**
 * Driver (Phase II) class
 */

public class DriverTwo {
    
    /**
     * Create a copy of an array of flying objects
     * @param arrayOfFlyingObjects - FlyingObjects[], an array of different flying objects
     * @return FlyingObjects[] - a flying objects array with copies of the same objects from the input array
     */
    public static FlyingObjects[] copyFlyingObjects(FlyingObjects[] arrayOfFlyingObjects){
        FlyingObjects[] arrayToReturn = new FlyingObjects[arrayOfFlyingObjects.length];

        for(int i = 0; i<arrayToReturn.length; i++){
            arrayToReturn[i] = arrayOfFlyingObjects[i].copyObject(arrayOfFlyingObjects[i]);
        }
        return(arrayToReturn);
    }



    public static void main(String[] args) {
        
        //Create sample array of flying objects
        FlyingObjects[] arrayOfFlyingObjects = new FlyingObjects[20];
        arrayOfFlyingObjects[0] = new Airplane("Boeing2", 20, 2000);
        arrayOfFlyingObjects[1] = new Airplane("Boeing", 9999.99, 2000);
        arrayOfFlyingObjects[2] = new Airplane((Airplane)arrayOfFlyingObjects[0]);
        arrayOfFlyingObjects[3] = new Helicopter("Airbus2", 3000.99, 50, 10, 2020, 4);
        arrayOfFlyingObjects[4] = new Helicopter("Airbus", 2000, 50, 10, 2020, 4);
        arrayOfFlyingObjects[5] = new Helicopter((Helicopter)arrayOfFlyingObjects[3]);
        arrayOfFlyingObjects[6] = new Quadcopter("Airbus3", 2000.1, 35, 2, 2019, 2, 90);
        arrayOfFlyingObjects[7] = new Quadcopter("Airbus", 10, 35, 2, 2019, 2, 90);
        arrayOfFlyingObjects[8] = new Quadcopter((Quadcopter)arrayOfFlyingObjects[6]);
        arrayOfFlyingObjects[9] = new Multirotor("Samsung2", 100, 99, 1, 2015, 1, 4);
        arrayOfFlyingObjects[10] = new Multirotor("Samsung", 2000, 99, 1, 2015, 1, 4);
        arrayOfFlyingObjects[11] = new Multirotor((Multirotor)arrayOfFlyingObjects[9]);
        arrayOfFlyingObjects[12] = new UAV(2000, 9000.00);
        arrayOfFlyingObjects[13] = new UAV(2000, 8999.99);
        arrayOfFlyingObjects[14] = new UAV((UAV)arrayOfFlyingObjects[12]);
        arrayOfFlyingObjects[15] = new AgriculturalDrone(2000, 999.99, "Apple2", 2);
        arrayOfFlyingObjects[16] = new AgriculturalDrone(2000, 799.99, "Apple", 2);
        arrayOfFlyingObjects[17] = new AgriculturalDrone((AgriculturalDrone)arrayOfFlyingObjects[15]);
        arrayOfFlyingObjects[18] = new MAV(999, 2000, "H33TBN", 80);
        arrayOfFlyingObjects[19] = new MAV(999, 11, "H32DNQ", 80);


        //Call method
        FlyingObjects[] sampleArray = copyFlyingObjects(arrayOfFlyingObjects);



        //Print original and copied array of flying objects
        System.out.println();
        System.out.println("~~~~~~~~~ ORIGINAL ARRAY OF FLYING OBJECTS ~~~~~~~~~");
        System.out.println();
        for(int i=0; i<arrayOfFlyingObjects.length; i++){
            System.out.println(arrayOfFlyingObjects[i]);
            System.out.println();
        }
        System.out.println();
        System.out.println("~~~~~~~~~ COPIED ARRAY OF FLYING OBJECTS ~~~~~~~~~");
        System.out.println();
        for(int i=0; i<sampleArray.length; i++){
            System.out.println(sampleArray[i]);
            System.out.println();


        }

        System.out.println();
        System.out.println("~~~~~~~~~ END OF PROGRAM ~~~~~~~~~");

        /*
        The copyFlying objects method works as expected.
        It creates new objects with the same attributes as the objects in the array passed to it.


        //Takes the first object in the original array 
        Airplane a1 = (Airplane)arrayOfFlyingObjects[0];

        //Takes the first object in the new array
        Airplane a2 = (Airplane)sampleArray[0];

        //Changes brand of the Original object
        a1.setBrand("Zafir");

        //Prints "Zafir" (The new value)
        System.out.println(a1.getBrand());

        //Prints "Boeing2" (The original value)
        System.out.println(a2.getBrand());

        This shows that the new array of flying objects that is created has brand new objects that are created.
        ie: The objects in the original array are deep copied
        */

}
}