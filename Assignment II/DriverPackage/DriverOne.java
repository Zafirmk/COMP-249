// -----------------------------------------------------
// Part: 1 (Driver Class)
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


package DriverPackage;

import AgriMAV.AgriculturalDrone;
import AgriMAV.MAV;
import AirplanePackage.Airplane;
import Copters.Helicopter;
import Copters.Quadcopter;
import FlyingObjectsPackage.FlyingObjects;
import MultirotorPackage.Multirotor;
import UAVPackage.UAV;
/**
 * Driver (Phase I) class
 */
public class DriverOne {
    
    /**
     * Main method
     * @param args -
     */
    public static void main(String[] args) {
        
        //Creating Objects of different types
        Airplane airplane1 = new Airplane("Boeing", 9999.99, 2000);
        Helicopter helicopter1 = new Helicopter("Air Bus", 799.99, 100, 2, 2020, 4);
        Quadcopter quadcopter1 = new Quadcopter("Air Bus", 299.99, 50, 1, 2018, 1, 90);
        Multirotor multirotor1 = new Multirotor("Samsung", 599.99, 20, 4, 2016, 4, 6);
        UAV uav1 = new UAV(200.0, 9999.99);
        AgriculturalDrone agriculturalDrone1 = new AgriculturalDrone(200, 599.99, "Apple", 20);
        MAV mav1 = new MAV(699.99, 1000, "H291DJ2", 99.9);

        Airplane airplane2 = new Airplane(airplane1);
        Airplane airplane3 = new Airplane("Boeing", 1.00, 2000);

        Multirotor multirotor2 = new Multirotor(multirotor1);
        Multirotor multirotor3 = new Multirotor("Apple", 599.99, 20, 4, 2016, 4, 6);

        //Printing to test toString and .equals methods
        System.out.println();
        System.out.println("~~~~~~~~ TESTING .equals() METHOD ~~~~~~~~");
        System.out.println();
        System.out.println("airplane1.equals(airplane2): " + airplane1.equals(airplane2));
        System.out.println();
        System.out.println("airplane1.equals(airplane3): " + airplane1.equals(airplane3));
        System.out.println();
        System.out.println("multirotor1.equals(multirotor2): " + multirotor1.equals(multirotor2));
        System.out.println();
        System.out.println("multirotor1.equals(multirotor3): " + multirotor1.equals(multirotor3));
        System.out.println();
        System.out.println("~~~~~~~~ PRINTING OBJECTS ~~~~~~~~");
        System.out.println();
        System.out.println(airplane1);
        System.out.println();
        System.out.println(helicopter1);
        System.out.println();
        System.out.println(quadcopter1);
        System.out.println();
        System.out.println(multirotor1);
        System.out.println();
        System.out.println(uav1);
        System.out.println();
        System.out.println(agriculturalDrone1);
        System.out.println();
        System.out.println(mav1);
        System.out.println();


        //Creating array with different types of flying objects
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

        //Maximum value of a double stored in firstmin and secondmin
        double firstmin = Double.MAX_VALUE; 
        double secmin = Double.MAX_VALUE;
        //Initializing index positiions of cheapest flying objects
        int firstmin_index = -1;
        int secmin_index = -1;

        //Loop through array
        for (int i = 0; i < arrayOfFlyingObjects.length; i++){ 

            //If current price lower than the cheapest price found
            if (arrayOfFlyingObjects[i].getPrice() < firstmin) 
            { 
                //Save current price into second cheapest and update cheapest and its index
                secmin = firstmin; 
                firstmin = arrayOfFlyingObjects[i].getPrice();
                firstmin_index = i;

            }
            //If cheaper than the second cheapest, update secmin and its index 
            else if (arrayOfFlyingObjects[i].getPrice() < secmin) 
            { 
                secmin = arrayOfFlyingObjects[i].getPrice();
                secmin_index = i;
            } 
        }
            

        //Print least expensive and second least expensive flying objects
        System.out.println();
        System.out.println("~~~~~~~~ LEAST EXPENSIVE FLYING OBJECT ~~~~~~~~");
        System.out.println();
        System.out.println(arrayOfFlyingObjects[firstmin_index]);
        System.out.println();
        System.out.println("~~~~~~~~ SECOND LEAST EXPENSIVE FLYING OBJECT ~~~~~~~~");
        System.out.println();
        System.out.println(arrayOfFlyingObjects[secmin_index]);
        System.out.println();

        System.out.println();
        System.out.println("~~~~~~~~~ END OF PROGRAM ~~~~~~~~~");
          

    } 




}
