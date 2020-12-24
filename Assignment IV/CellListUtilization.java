// -----------------------------------------------------
// Assignment 4
// Question: 2
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------

import java.io.*;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Zafir Khalid - 40152164 COMP 249 Assignment 4 Due Date: Friday Dec 4, 2020
 */

// Testing the linked list class and its methods
// Also takes in node data values from txt file and initializes a linked list

public class CellListUtilization {

    public static void main(String[] args) {

        //Creates the two linked list objects
        CellList list1 = new CellList();
        CellList list2 = new CellList();

        //Initializes variables to use throughout
        long userSerialNum = 0;
        Scanner fileReader = null;
        Scanner keyboard = new Scanner(System.in);
        Scanner sentenceParser = null;

        try {
        //Opens the Cell_Info.txt file
        fileReader = new Scanner(new FileInputStream("Cell_Info.txt"));
        } catch (FileNotFoundException e) {
        System.out.println("ERROR OPENING FILE");
        }

        //While not EOF
        while (fileReader.hasNextLine()) {

            //Reads the current line
            String currLine = fileReader.nextLine();
            //Parses each sentence
            sentenceParser = new Scanner(currLine);

            //Stores each value from the sentence into variables
            while (sentenceParser.hasNext()) {
                long serialNum = Long.parseLong(sentenceParser.next());
                String brand = sentenceParser.next();
                double price = Double.parseDouble(sentenceParser.next());
                int year = Integer.parseInt(sentenceParser.next());

                //Creates new Cellphone with the read values and adds it to linked list
                if (!(list1.contains(serialNum))) {
                    list1.addToStart(new Cellphone(serialNum, brand, year, price));
                }
            }
        }

        System.out.println(list1.showContents());

        // TESTING THE FIND METHOD
        for (int i = 0; i <= 2; i++) {
            System.out.println("Enter a serial number to search: ");
            try {
                userSerialNum = keyboard.nextLong();
            } catch (Exception e) {
                System.out.println("ERROR: Wrong input! Program shutting down");
                System.exit(0);
            }

            list1.find(userSerialNum);
        }

        //TESTING THE METHODS IN THE LINKED LIST CLASS

        CellList list_copy = new CellList(list1);

        System.out.println();
        System.out.println();

        System.out.println("~~~~~~~ TESTING COPY CONSTRUCTOR ~~~~~~~");
        System.out.println(list_copy.showContents());

        System.out.println();
        System.out.println();

        System.out.println("~~~~~~~ TESTING equals() METHOD ~~~~~~~");
        System.out.println();
        System.out.println("list_copy.equals(list1): " + list_copy.equals(list1));
        System.out.println();

        System.out.println("~~~~~~~ TESTING insertAtIndex() METHOD ~~~~~~~");
        Cellphone cellphoneToAdd = new Cellphone(123456, "XYZ", 2020, 1.00);
        try{
            list_copy.insertAtIndex(cellphoneToAdd, 2);
        }catch(NoSuchElementException e){
            System.out.println("Invalid index position! ");
            System.exit(0);
        }
        System.out.println(list_copy.showContents());
        System.out.println();

        System.out.println("~~~~~~~ TESTING deleteAtIndex() METHOD ~~~~~~~");
        try{
            list_copy.deleteFromIndex(0);
        }catch(NoSuchElementException e){
            System.out.println("Invalid index position! ");
            System.exit(0);
        }
        System.out.println(list_copy.showContents());
        System.out.println();

        System.out.println("~~~~~~~ TESTING deleteFromStart() METHOD ~~~~~~~");
        list_copy.deleteFromStart();
        System.out.println(list_copy.showContents());
        System.out.println();

        System.out.println("~~~~~~~ TESTING replaceAtIndex() METHOD ~~~~~~~");
        Cellphone cellphoneToAdd2 = new Cellphone(78910, "ABC", 2021, 2.00);
        try{
            list_copy.replaceAtIndex(cellphoneToAdd2, 0);
        }catch(NoSuchElementException e){
            System.out.println("Invalid index position! ");
            System.exit(0);
        }
        System.out.println(list_copy.showContents());
        System.out.println();

        System.out.println("~~~~~~~ TESTING find() METHOD ~~~~~~~");
        System.out.println();
        System.out.println("list_copy.find(78910): " + (list_copy.find(78910)));
        System.out.println();

        System.out.println("~~~~~~~ TESTING contains() METHOD ~~~~~~~");
        System.out.println();
        System.out.println("list_copy.contains(78910): " +
        list_copy.contains(78910));
        System.out.println();

        keyboard.close();
        sentenceParser.close();

    }





}
