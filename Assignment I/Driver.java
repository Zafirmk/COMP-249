import java.util.Scanner;
/**
 * Zafir Khalid (40152164)
 * COMP 249
 * Assignment #1 Question #2
 * Due Date: 10/02/2020 (MM:DD:YYYY)
 */

 /*
 An appliance tracking software that gives the user various options such as
 Adding appliances to an inventory
 Modifiying appliances information
 Displaying appliances of a specific brand
 Displaying appliances under a certain price
 */


public class Driver {
    
    /**
     * Method that prints the main menu options to the console
     * @param keyboard - Scanner object used to get user input
     * @return - Int, representing the menu choice the user made
     */
    public static int mainMenu(Scanner keyboard) {
        int mainMenuInput = 0;
        
        //Loops through main menu options
        //Returns the value needed for the main menu switch-case 
        do {
        System.out.println();
        System.out.println("What do you want to do?");
        System.out.println("\t 1. Enter new appliances (password required)");
        System.out.println("\t 2. Change information of an appliance (password required)");
        System.out.println("\t 3. Display all appliances by a specific brand");
        System.out.println("\t 4. Display all appliances under a certain price.");
        System.out.println("\t 5. Quit");
        System.out.print("Please enter your choice > ");
        System.out.println();
        
        mainMenuInput = keyboard.nextInt();
        
        }while(mainMenuInput > 5 || mainMenuInput < 1);
        return(mainMenuInput);
    }

    /**
     * Method that prints the menu for option 2
     * @param keyboard - Scanner object used to get user input
     * @return - Int, representing the menu choice the user made
     */
    public static int option2MainMenu(Scanner keyboard){
        int option2MainMenuInput = 0;
        
        //Loops through option 2 menu options
        //Returns the value needed for the option 2 menu switch-case 
        do {
        System.out.println();
        System.out.println("What information would you like to change?");
        System.out.println("\t 1. Brand");
        System.out.println("\t 2. Type");
        System.out.println("\t 3. Price");
        System.out.println("\t 4. Quit");
        System.out.print("Enter your choice > ");
        System.out.println();
        
        option2MainMenuInput = keyboard.nextInt();
        
        }while(option2MainMenuInput > 4 || option2MainMenuInput < 1);
        return(option2MainMenuInput);
    }
    
    /**
     * Method to find all appliance objects with the same brand name as the one provided by the user (brand)
     * @param brand - String, the brand name which is searched for in the inventory
     * @param inventoryToSearch - Appliance[], a list of Appliance objects through which the search is made
     */
    public static void findAppliancesBy(String brand, Appliance[] inventoryToSearch){
        System.out.println();
        //Checks if inventory is empty
        if(Appliance.findNumberOfCreatedAppliances() == 0){
            System.out.println("No appliances present in the inventory");
        }
        //Loops through inventory and checks if brand of appliance object is equal to the brand parameter
        //If equal appliance object is printed
        else{
            boolean found = false;
            for(int i=0; i<Appliance.findNumberOfCreatedAppliances();i++){
                if((inventoryToSearch[i].getBrand()).equalsIgnoreCase(brand)){
                    found = true;
                    System.out.println(inventoryToSearch[i]);
                }
            }
            if(found == false){
                System.out.println("No appliances found with the brand name " + brand);
            }
        }
    }

    /**
     * Method to find all appliance objects cheaper than a certain price provided by the user (price)
     * @param price - Double, the max price - all Appliance objects cheaper than this price are returned
     * @param inventoryToSearch - Appliance[], a list of Appliance objects through which the search is made
     */
    public static void findCheaperThan(double price, Appliance[] inventoryToSearch){
        System.out.println();
        //Checks if inventory is empty
        if(Appliance.findNumberOfCreatedAppliances() == 0){
            System.out.println("No appliances present in the inventory");
        }
        //Loops through inventory and checks if brand of appliance object is equal to the brand parameter
        //If equal appliance object is printed
        else{
            boolean found = false;
            for(int i=0; i<Appliance.findNumberOfCreatedAppliances();i++){
                if(inventoryToSearch[i].getPrice() < price){
                    found = true;
                    System.out.println(inventoryToSearch[i]);
                }
            }
            if(found == false){
                System.out.println("No appliances found with the price under " + price);
            }
        }
    } 

    /**
     * Main method
     * @param args - Default term used in construction of main method
     */
    public static void main(String[] args){


        //Declaring variables used in password checking
        final String password = "c249";

        //Separate variables used to make sure failed attempts are independant of one another
        int passwordFailedAttemptsOption1 = 0;
        int passwordFailedAttemptsOption2 = 0;

        String userInputPassword;

        //User input on main menu selection
        int mainMenuInput = 0;

        Scanner keyboard = new Scanner(System.in);

        //Welcome Message
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Welcome to Zafir's Appliance Tracking Software");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
        System.out.println("What is the maximum number of appliances your store can contain?");

        //Saving max appliances possible and declaring empty array of the same size
        int maxAppliances = keyboard.nextInt();

        Appliance[] inventory = new Appliance[maxAppliances];

        

        //Main Menu loop
        do {

            //Getting user input for main menu and calling a switch statement
            mainMenuInput = mainMenu(keyboard);

            switch(mainMenuInput){

                //Enter new appliances
                case 1:

                    //HANDLING OF PASSWORD
                    //Password checking loop
                    do {
                        System.out.println();
                        System.out.println("Enter your password: ");
                        userInputPassword = keyboard.next();
                        passwordFailedAttemptsOption1++;

                        //Breaks password loop if attempts is a multiple of 3,
                        //If 12 attempts then terminate full program 
                        if (passwordFailedAttemptsOption1%3 == 0){
                            if (passwordFailedAttemptsOption1 == 12){
                                System.out.println();
                                System.out.println("Program detected suspicious activities and will terminate immediately!");
                                System.exit(0);
                            }
                        break;
                        }
                    } while (!(userInputPassword.equals(password)));

                    //Successful password authentication
                    if (userInputPassword.equals(password)){

                        //Reset password count
                        passwordFailedAttemptsOption1 = 0;

                        //Save locally, the number of appliances currently in inventory
                        int currentNumberOfAppliances = Appliance.findNumberOfCreatedAppliances();

                        System.out.println();
                        System.out.println("How many appliances do you want to enter?");
                        int userInputNumOfAppliances = keyboard.nextInt();

                        //Check if user input is invalid (ie: Less than or equal to 0 OR there is no space in inventory)
                        if(userInputNumOfAppliances > (maxAppliances - currentNumberOfAppliances) || userInputNumOfAppliances<=0) {
                            System.out.println();
                            System.out.println("Sorry there is no space left in the inventory");
                            break;
                        }

                        //Run for loop to insert objects into inventory
                        for(int i=currentNumberOfAppliances; i<(currentNumberOfAppliances+userInputNumOfAppliances);i++){

                            System.out.println("Enter the type of the appliance: ");
                            String applianceType = keyboard.next();
                            applianceType += keyboard.nextLine();


                            System.out.println("Enter the brand of the appliance: ");
                            String applianceBrand = keyboard.next();
                            applianceBrand += keyboard.nextLine();


                            System.out.println("Enter the price of the appliance: ");
                            double appliancePrice = keyboard.nextDouble();

                            inventory[i] = new Appliance(applianceType, applianceBrand, appliancePrice);
                            
                            //Printing details once appliance object is created and added to inventory
                            System.out.println();
                            System.out.println(inventory[i]);
                            System.out.println();
                            System.out.println("Appliance Successfully Added!");
                            System.out.println();
                        }

                        //Update local variable with number of appliances
                        currentNumberOfAppliances = currentNumberOfAppliances+userInputNumOfAppliances;

                        

                    }
                break;
                

                //Change information of appliances
                case 2:

                    //HANDLING OF PASSWORD
                    //Password checking loop
                    do {
                        System.out.println();
                        System.out.println("Enter your password: ");
                        userInputPassword = keyboard.next();
                        passwordFailedAttemptsOption2++;
                        //Loop breaks every 3 failed attempts
                        if (passwordFailedAttemptsOption2%3 == 0){
                            break;
                        }
                    } while (!(userInputPassword.equals(password)));

                    //Successfully authenticate password
                    if(userInputPassword.equals(password)){

                        //Reset failed attempts
                        passwordFailedAttemptsOption2 = 0;

                        //indexOfItem stores index of appliance object to be updated
                        int indexOfItem = -1;
                        //Quit decision stores the value of the user for the response "Do you want to quit to the main menu?"
                        String quitDecision = "No";

                        //Loop to keep asking user if they want to update an item
                        //Or if they want to quit
                        do {

                            //Get user input of serial number of appliance to update
                            System.out.println();
                            System.out.println("Enter the serial number of the appliance you wish to update");
                            long userInputSerialNumber = keyboard.nextLong();
                            
                            //Search inventory array to find appliance object
                            for(int i=0; i<Appliance.findNumberOfCreatedAppliances(); i++){
                                if(inventory[i].getSerialNumber() == userInputSerialNumber){
                                    indexOfItem = i;
                                    break;
                                }
                            }

                            //If object doesn't exist
                            if (indexOfItem == -1){

                                //Getting user input if they want to re-enter serial number or if they want to quit
                                System.out.println();
                                System.out.println("No object with that serial number was found");
                                System.out.println("Do you want to re-enter another serial number?");
                                System.out.println();

                                String reEntryDecision = keyboard.next();

                                if(reEntryDecision.equals("No") || reEntryDecision.equals("no")){
                                    System.out.println("Do you want to quit to the main menu?");

                                    quitDecision = keyboard.next();

                                }
                            }

                            //If object exists
                            else{

                                //Print details of the object
                                System.out.println();
                                System.out.println(inventory[indexOfItem]);
                                System.out.println();

                                //Declaring variables used in option 2 menu loop
                                String userInputBrand;
                                String userInputType;
                                double userInputPrice;
                                int option2MainMenuInput;

                                //Option 2 menu loop
                                do {

                                    //Print menu options and get user input using option2MainMenu function
                                    //Then run switch statement based on user input
                                    option2MainMenuInput = option2MainMenu(keyboard);
                                    switch(option2MainMenuInput){
                                        
                                        //Change brand of appliance
                                        case 1:
                                            System.out.println();
                                            System.out.println("Enter the new brand name: ");
                                            userInputBrand = keyboard.next();
                                            userInputBrand += keyboard.nextLine();


                                            inventory[indexOfItem].setBrand(userInputBrand);
                                            System.out.println();
                                            System.out.println(inventory[indexOfItem]);
                                            break;
                                        
                                        //Change type of appliance
                                        case 2:
                                            System.out.println();
                                            System.out.println("Enter the new type: ");
                                            userInputType = keyboard.next();
                                            userInputType += keyboard.nextLine();

                                            inventory[indexOfItem].setType(userInputType);
                                            System.out.println();
                                            System.out.println(inventory[indexOfItem]);
                                            break;
                                        
                                        //Change price of appliance
                                        case 3:
                                            System.out.println();
                                            System.out.println("Enter the new price: ");
                                            userInputPrice = keyboard.nextDouble();
                                            inventory[indexOfItem].setPrice(userInputPrice); 
                                            System.out.println();  
                                            System.out.println(inventory[indexOfItem]);
                                            break;
                                    }
                                //Looping while the user doesn't quit the option 2 menu selection
                                } while (option2MainMenuInput != 4);

                            }
                        //Looping while object is not found
                        } while (indexOfItem == -1 && (quitDecision.equals("No")||quitDecision.equals("no")));

                    }
                    break;
                
                //Display appliances of specific brand
                case 3:
                    System.out.println();
                    System.out.println("Enter the brand name to search: ");
                    String brandToSearch = keyboard.next();
                    brandToSearch += keyboard.nextLine();

                    //Running method findAppliancesBy
                    findAppliancesBy(brandToSearch, inventory);
                    break;
                
                //Display appliances below certain price
                case 4:
                    System.out.println();
                    System.out.println("Enter the price to search below: ");
                    double priceToSearch = keyboard.nextDouble();
                    
                    //Running method findCheaperThan
                    findCheaperThan(priceToSearch, inventory);
                    break;
            }
        
        //Looping while the menu option is not 5
        } while (mainMenuInput > 0 && mainMenuInput < 5);

        //Closing message
        System.out.println();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Thank you for using The Appliance Tracking Software");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();

        
    }
}
