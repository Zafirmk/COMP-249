// -----------------------------------------------------
// Assignment 3
// Question: 1 Part 2
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------


/**
 * Zafir Khalid - 40152164
 * COMP 249
 * Assignment 3
 * Due Date: Friday Nov 13, 2020
 */

// FileInvalidException class

public class FileInvalidException extends Exception {
    
    /**
     * Default Constructor
     */
    public FileInvalidException(){
        super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
    }

    /**
     * Parameterized Constructor
     * @param customMessage - Message to output to the user when exception is caught
     */
    public FileInvalidException(String customMessage){
        super(customMessage);
    }
}
