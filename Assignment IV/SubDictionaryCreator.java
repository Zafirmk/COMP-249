// -----------------------------------------------------
// Assignment 4
// Question: 1
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------

import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Zafir Khalid - 40152164
 * COMP 249
 * Assignment 4
 * Due Date: Friday Dec 4, 2020
 */

 //Creating a dictionary of words from a txt file
 
public class SubDictionaryCreator{


    public static void main(String[] args) {
        
        //Printing welcome message
        System.out.println();
        System.out.println("~~~~~~~~ ZAFIR'S SUBDICTIONARY GENERATOR ~~~~~~~~");
        System.out.println();


        //Declaring inputstream and outputstream
        Scanner sc = null;
        Scanner keyboard = new Scanner(System.in);
        PrintWriter outputStream = null;


        //Instantiating scanner object to read files
        try {
            System.out.println("Please enter the name of the file you would like to create a sub-dictionary of: ");
            String temp = keyboard.nextLine();
            sc = new Scanner(new FileInputStream(temp));
        } catch (FileNotFoundException e) {
            System.out.println("Sorry! the file you entered was not found");
            System.exit(0);
        }

        //Arraylist to store every word in .txt file
        ArrayList<String> words = new ArrayList<String>();

        //Reads .txt file word by word
        while(sc.hasNext()){

            //Boolean values to check if word should be added and if it has been added
            boolean toAdd = true;
            boolean added = false;

            //Current word read in
            String currentWord = sc.next();

            //Last character of the current word
            char lastCharacter = currentWord.charAt(currentWord.length()-1);

            //Omits last character if it isn't a valid letter
            if(!(Character.isLetter(lastCharacter))){
                currentWord = currentWord.substring(0, currentWord.length()-1);
                toAdd = true;
            }

            //Checks if the current word has a digit anywhere in it
            for(int i=0; i<currentWord.length(); i++){
                char currentLetter = currentWord.charAt(i);
                if(Character.isDigit(currentLetter)){
                    toAdd = false;
                    break;
                }
            }

            //Removes 'S, 's, 'M, 'm from the current word
            if((currentWord.contains("'S")) || (currentWord.contains("'M"))
                || (currentWord.contains("'s")) || (currentWord.contains("'m"))){

                    currentWord = currentWord.substring(0, currentWord.indexOf("'"));
                    toAdd = true;

            }


            //Checks if a single character word is either I, i, A or a
            if(currentWord.length() == 1){
                if(((currentWord.equals("I") || currentWord.equals("A") || currentWord.equals("i")|| currentWord.equals("a")))){
                    toAdd = true;
                }
                else{
                    toAdd = false;
                }
            }


            //Adds each word to arraylist in lexicographical order
            if(!words.contains(currentWord.toUpperCase()) && currentWord.length()>0 && toAdd){

                //Converts word to uppercase
                currentWord = currentWord.toUpperCase();

                //If arraylist is empty add straight away
                if(words.size()==0){
                    words.add(currentWord);
                }

                //Checks to see if the word isn't already in the arraylist
                if(!words.contains(currentWord)){

                    //Loops over current arraylist
                    for(int i=0; i<words.size(); i++){

                        //If the word has already been added, break
                        if(added){
                            break;
                        }

                        //Checks to see if the word found the correct position to be inserted
                        if(currentWord.compareTo(words.get(i)) < 0){
                            words.add(i, currentWord);
                            added = true;
                        }
                    }

                    //If the loop reaches the end of arraylist add the word at the end
                    if(!added){
                        words.add(currentWord);
                    }
                }


            }

        }

        
        //Create outputStream object
        try {
            outputStream = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }


        outputStream.println("The document produced this sub-dictionary, which includes "+words.size()+" entries.");
        String currentLetter = null;
        String prevLetter = null;




        //Loop through words array and write each word to the file
        for(int i=0; i<words.size();i++){
            currentLetter = words.get(i).substring(0, 1);
            if(i>=1){
                prevLetter = words.get(i-1).substring(0, 1);
            }

            if(!(currentLetter.equals(prevLetter))){
                outputStream.println();
                outputStream.println(currentLetter);
                outputStream.println("==");
            }

            outputStream.println(words.get(i));


        }

        System.out.println();
        System.out.println("~~~~~~~~ PROGRAM HAS FINISHED ~~~~~~~~");
        System.out.println();
        outputStream.close();
        keyboard.close();


    }

}