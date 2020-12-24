/**
 * Zafir Khalid (40152164)
 * COMP 249
 * Assignment #1 Question #1
 * Due Date: 10/02/2020 (MM:DD:YYYY)
 */

 /*
 An Appliance class that stores information about various appliances
 Information includes serial number, type of appliance, brand of appliance and price of appliances
 Various methods allow for the safe modification of attributes of appliances, displaying attributes of appliances and checking equality 
 */

public class Appliance{

    
    private String type;
    private String brand;
    private long serialNumber = 1000000;
    private double price;
    private static int numOfAppliances = 0;
    private String[] validTypes = {"Fridge", "Air Conditioner", "Washer", "Dryer", "Freezer", "Stove", "Dishwasher", "Water Heater", "Microwave"};

    /**
     * Default Constructor - Initializes all values to some valid type
     */
    public Appliance(){
        this.type = "Fridge";
        this.brand = "";
        this.price = 1.00;
        this.serialNumber = serialNumber + numOfAppliances;
        increaseNumberOfCreatedAppliances();
    }
    
    /**
     * Constructor - Initializes all values (except serial number) to values that the user provides,
     * assigns a serial number and adds to the number of appliances created.
     * @param aType - String of the type of appliance
     * @param aBrand - String of the brand of the appliance 
     * @param aPrice - Double of the price of the appliance
     */
    public Appliance(String aType, String aBrand, double aPrice){
        this.type = capitalizeType(aType);
        checkType();
        this.brand = aBrand;
        this.price = aPrice;
        checkPrice();
        this.serialNumber = serialNumber + numOfAppliances;
        increaseNumberOfCreatedAppliances();
    }

    /**
     * Copy Constructor - Initializes all values (except serial number) to the same values of another Appliance object
     * @param anotherAppliance - Appliance object through which the attributes are taken
     */
    public Appliance(Appliance anotherAppliance){

        if(anotherAppliance==null){
            System.out.println("ERROR: Null object was passed to copy constructor");
            System.exit(0);
        }

        this.brand = anotherAppliance.brand;
        this.type = anotherAppliance.type;
        this.price = anotherAppliance.price;
        this.serialNumber = serialNumber + numOfAppliances;
        increaseNumberOfCreatedAppliances();

    }

    /**
     * Private function to ensure that the price value of any appliance is not less than $1.00
     */
    private void checkPrice(){
        if (this.getPrice() < 1.00){
            this.setPrice(2.00);
            System.out.println();
            System.out.println("Price can not be less than $1.00");
            System.out.println("Price has been automatically reset to $2.00");
            System.out.println();
        }
    }

    /**
     * Private function to ensure that the type of appliance is valid (ie: belongs to the list validTypes)
     */
    private void checkType(){
        boolean valid = false;
        //Searches list to check if the user entered type is in the list
        for(int i=0; i<(validTypes.length); i++){
            if(validTypes[i].equals(this.getType())){
                valid = true;
            }
        }
        if(!valid){
            System.out.println();
            System.out.println("The appliance type you entered is not valid.");
            System.out.println("The type is automatically reset to \"Fridge\" ");
            setType("Fridge");
            System.out.println("Please select from the options: ");
            System.out.println();
            for(int i=0; i<validTypes.length;i++){
                System.out.println(validTypes[i]);
            }
            System.out.println();
        }
    }

    /**
     * Private function to capitalize the type attribute of an appliance
     * Even if appliance has two words. Eg: Air Conditioner
     * @param aType - The type string to capitalize
     * @return - String of the type with first letters capitalized
     */
    private String capitalizeType(String aType){
        int spaceIndex = aType.indexOf(" ");
        if(spaceIndex == -1){
            return(aType.substring(0, 1).toUpperCase() + aType.substring(1).toLowerCase());
        }
        else{
            //Capitalizing first letter then separating at the " " position and capitalizing the first letter of the word after the " "
            return(aType.substring(0, 1).toUpperCase() + 
                    aType.substring(1, spaceIndex).toLowerCase() + 
                    aType.substring(spaceIndex, spaceIndex+2).toUpperCase() +
                    aType.substring(spaceIndex+2).toLowerCase());
        }
    }

    //Setters

    /**
     * Change the type attribute of an appliance to a new value
     * @param aType - String, the new type of the appliance
     */
    public void setType(String aType){
        this.type = capitalizeType(aType);
        checkType();
    }

    /**
     * Change the brand attribute of an appliance to a new value
     * @param aBrand - String, the new brand of the appliance
     */
    public void setBrand(String aBrand){
        this.brand = aBrand;
    }

    /**
     * Change the price attribute of an appliance to a new value
     * @param aPrice - Double, the new price of the appliance
     */
    public void setPrice(double aPrice){
        this.price = aPrice;
        checkPrice();
    }

    //Getters

    /**
     * Get back the type attribute of an appliance object
     * @return - String, type of the appliance
     */
    public String getType(){
        return(this.type);
    }

    /**
     * Get back the brand attribute of an appliance object
     * @return - String, brand of the appliance
     */
    public String getBrand(){
        return(this.brand);
    }

    /**
     * Get back the price attribute of an appliance object
     * @return - Double, price of the appliance
     */
    public double getPrice(){
        return(this.price);
    }

    /**
     * Get back the serial number attribute of an appliance object
     * @return - Long, serial number of the appliance
     */
    public long getSerialNumber(){
        return(this.serialNumber);
    }

    /**
     * Get back the number of appliance objects created
     * @return - Int, the static int representing the number of appliance objects created
     */
    public static int findNumberOfCreatedAppliances(){
        return(numOfAppliances);
    }



    /**
     * A toString method to print the attributes of the appliance
     * @return - String, stating the attributes of the appliance
     */
    public String toString(){
        return("Appliance Serial # " + getSerialNumber() + "\n" +
                "Brand: " + getBrand() + "\n" +
                "Type: " + getType() + "\n" +
                "Price: $" + getPrice() + "\n");
    }


    /**
     * Private method to increment the number of appliances created by 1
     */
    private static void increaseNumberOfCreatedAppliances(){
        numOfAppliances++;
    }

    /**
     * Checks the equality between two appliance objects
     * @param anotherObject - the appliance to be compared to the calling object
     * @return Boolean, true if the brand, price and type of both objects match
     */
    public boolean equals(Object anotherObject){

        if(anotherObject==null){
            return false;
        }
        else if(this.getClass() != anotherObject.getClass()){
            return false;
        }

        Appliance anotherAppliance = (Appliance)anotherObject;

        boolean bolBrand = (this.brand).equals(anotherAppliance.getBrand());
        boolean bolType = (this.type).equals(anotherAppliance.getType());
        boolean bolPrice = (this.price) == (anotherAppliance.getPrice());

        return(bolBrand && bolType && bolPrice);
    }


}