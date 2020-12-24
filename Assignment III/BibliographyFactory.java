// -----------------------------------------------------
// Assignment 3
// Question: 1
// Written by: Zafir Khalid 40152164
// -----------------------------------------------------

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Zafir Khalid - 40152164
 * COMP 249
 * Assignment 3
 * Due Date: Friday Nov 13, 2020
 */


//  This program takes in JSON files of articles and their details (eg: author, year, title etc)
//  and then produces files containing 3 different types of citations. IEEE, ACM and NJ.
//  It outputs these citations .txt files that the user can view 
 
public class BibliographyFactory{

    /**
     * Creates citations of articles from .bib files containing articles and their details
     * @param sc - Scanner object, that reads the .bib file looking for an article
     * @param totalArticlesPerFile - int, the total number of articles in a particular file
     * @return String[] - Array of Strings, containing the citations in order [IEEE, ACM, NJ]
     * @throws FileInvalidException - Error thrown when an empty field is detected in a particular file 
     */
    public static String[] processFilesForValidation(Scanner sc, int totalArticlesPerFile) throws FileInvalidException {

        //Array that is returned
        //Length is totalArticlesPerFile*3 because each article produces 3 different types of citations
        String arrayOfCitations[] = new String[totalArticlesPerFile*3];

        //Current article number that is being processed
        int currentArticleNumber = 0;

        //Setting up starting indexes of each type of citation in the array that will be returned
        int IEEEindex = 0;
        int ACMindex = IEEEindex + totalArticlesPerFile;
        int NJindex = ACMindex + totalArticlesPerFile;

        //Initializing null values of fields
        String author = null;
        String journal = null;
        String title = null;
        String year = null;
        String volume = null;
        String number = null;
        String pages = null;
        String keywords = null;
        String doi = null;
        String ISSN = null;
        String month = null;

        String IEEE = null;
        String IEEEauthor = null;
        

        String NJ = null;
        String NJauthor = null;

        String ACM = null;
        String ACMauthor[] = null;
    


        //Scanner splits file into articles using delimiter
        sc.useDelimiter("@ARTICLE");



        //While the EOF is not reached
        while(sc.hasNext()){

            //Taking the entire article into a variable
            String currentArticle = sc.next();
            currentArticleNumber++;

            //Using separate scanner to read through an induvidual article
            Scanner articleScanner = new Scanner(currentArticle);

            //While the end of the article hasn't been reached
            while(articleScanner.hasNextLine()){

                //Initialize to dummy value
                char firstCharacter='.';

                //Breaking article into induvidual fields
                String currentField = articleScanner.nextLine();
    
                //Checking to see if the field is not empty and if so, checking first letter to ensure it is a legitimate field
                if(currentField.length()>0){
                    firstCharacter = currentField.charAt(0);

                    //Checking for legitimate field and extracting data and field name
                    if((firstCharacter >= 'a' && firstCharacter <= 'z') || (firstCharacter >= 'A' && firstCharacter <= 'Z')){
                        String fieldName = currentField.substring(0, currentField.indexOf("="));
                        String data = (currentField.substring(currentField.indexOf("{")+1, currentField.indexOf("}")));
                        
                        //Checking what type of data
                        //If data is empty then throwing FileInvalidException
                        switch (fieldName) {
                            case "author":
                                author = data;
                                //Storing different types of naming the authors
                                IEEEauthor = author.replaceAll("and", ",");
                                IEEEauthor = IEEEauthor.replaceAll(" , ", ", ");
                                ACMauthor = author.split("and");
                                if(ACMauthor.length == 1){
                                    ACMauthor[0] = ACMauthor[0]+" ";
                                }
                                NJauthor = author.replaceAll("and", "&");
                                if(author.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"author\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "journal":
                                journal = data;
                                if(journal.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"journal\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "title":
                                title = data;
                                if(title.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"title\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "volume":
                                volume = data;
                                if(volume.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"volume\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "pages":
                                pages = data;
                                if(pages.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"pages\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "keywords":
                                keywords = data;
                                if(keywords.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"keywords\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "doi":
                                doi = data;
                                if(doi.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"doi\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "ISSN":
                                ISSN = data;
                                if(ISSN.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"ISSN\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "month":
                                month = data;
                                if(month.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"month\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "year":
                                year = data;
                                if(year.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"year\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;

                            case "number":
                                number = data;
                                if(number.equals("")){
                                    throw new FileInvalidException("File is invalid: Field \"number\" is Empty. Processing stopped at this point. Other empty files may be present as well");
                                }
                                break;
                        }


                        //Creating IEEE citation                        
                        IEEE = IEEEauthor + ". \"" + title + "\", " + journal + ", vol. " + volume + ", no. " + number + ", p. " + pages + ", " + month + " " + year + "." + "\n";

                        //Creating ACM citation
                        ACM = "["+currentArticleNumber+"]" + " " + ACMauthor[0] + "et al. " + year + ". " + title + ". " + journal + ". " + volume + ", " + number + " " + "(" + year + ")" + ", " + pages + ". " + "DOI:https://doi.org/" + doi + "." + "\n"; 

                        //Creating NJ citation
                        NJ = NJauthor + ". " + title + ". " + journal + ". " + volume + ", " + pages + "("+year+")" + "." + "\n";

                    }
                    
                    
                }
            }

            //Storing each citation into the array at their relevant positions
            //Then increasing the index by one
            arrayOfCitations[IEEEindex] = IEEE;
            IEEEindex++;
            arrayOfCitations[ACMindex] = ACM;
            ACMindex++;
            arrayOfCitations[NJindex] = NJ;
            NJindex++;

            //Closing scanner
            articleScanner.close();

        }

        return(arrayOfCitations);
        

    }

    /**
     * Main function
     * @param args - Default parameter
     */
    public static void main(String[] args) {

        //Opening Message
        System.out.println();
        System.out.println("~~~~~~~~~ WELCOME TO ZAFIRS BIBLIOGRAPHY FACTORY! ~~~~~~~~~");
        System.out.println();

        
        //Input Stream to read in all .bib files
        Scanner inputStream = null;
        Scanner articleCounter = null;

        //Output Streams for each type of citation
        PrintWriter IEEEpw = null;
        PrintWriter ACMpw = null;
        PrintWriter NJpw = null;

        //Variables used extensively throughout
        String[] citationsToWrite = null;
        int totalArticlesPerFile = 0;
        int invalidFiles = 0;
        Scanner keyboard = new Scanner(System.in);
        String line = "";


        //Creating directory to hold all output files
        File outputDir = new File("OutputFiles");
        outputDir.mkdir();

        //Variable keeping track of the number of total files created
        int numberOfFilesCreated = 0;


        //For loop to read through each of the 10 .bib files
        for(int i=1; i<=10; i++){

            //Main try block, in which each .bib file is opened
            try {

                //Attempting to open .bib file
                inputStream = new Scanner(new FileInputStream("Comp249_W20_Assg3_Files/Latex"+i+".bib"));
                //Counting article using separate input stream
                articleCounter = new Scanner(new FileInputStream("Comp249_W20_Assg3_Files/Latex"+i+".bib"));

                //Nested try block in which each output file is created
                try {

                //Creating 3 output files for each input file 
                NJpw = new PrintWriter(new FileOutputStream("OutputFiles/NJ"+i+".txt"));
                numberOfFilesCreated++;
                ACMpw = new PrintWriter(new FileOutputStream("OutputFiles/ACM"+i+".txt"));
                numberOfFilesCreated++;
                IEEEpw = new PrintWriter(new FileOutputStream("OutputFiles/IEEE"+i+".txt"));
                numberOfFilesCreated++;

                //Catch statement incase an output file can not be created
               } catch (FileNotFoundException e) {

                //Checking to see which output file creation caused the error
                //This is done by checking numberOfFilesCreated+1 to get which file creation was last attempted
                if((numberOfFilesCreated+1)%3 == 0){
                    System.out.println("Could not create output file IEEE" + i + ".txt");
                    System.out.println();
                }
                else if((numberOfFilesCreated+1)%3 == 1){
                    System.out.println("Could not create output file NJ" + i + ".txt");
                    System.out.println();
                }
                else{
                    System.out.println("Could not create output file ACM" + i + ".txt");
                    System.out.println();
                }

                //Nested for loops to delete all the files that were created in case an error occurs
                //First loop is to check the file type (IEEE, ACM, NJ)
                for(int k=1; k<=3; k++){
                    String type="";
                    switch (k) {
                        case 1:
                            type = "IEEE";
                            break;
                    
                        case 2:
                            type = "ACM";
                            break;
                        
                        case 3:
                            type = "NJ";
                            break;
                    }
                    //Second loop deletes all 10 possible files of a single type
                    for(int j=1; j<=10; j++){
                        File fileTodelete = new File("OutputFiles/"+type+j+".txt");
                        fileTodelete.delete();
                    }
                }

                //Closing input stream before exiting
                inputStream.close();
                System.exit(0);
            }

                //Try block in which citations are generated from each file
                try {
                    //Counting number of articles in the file
                    totalArticlesPerFile=0;
                    while(articleCounter.hasNext()){
                        if(articleCounter.next().equals("@ARTICLE{")){
                            totalArticlesPerFile++;
                        }
                    }

                    //Calling function
                    citationsToWrite = (processFilesForValidation(inputStream, totalArticlesPerFile));

                    //How many citations of each type exist
                    //Eg: if 4 articles, then 4 IEEE - 4 ACM - 4 NJ
                    int numberOfEachCitation = citationsToWrite.length / 3;

                    //Writing each citation to the file
                    for(int j=0; j<citationsToWrite.length;j++){
                        if(j<numberOfEachCitation){
                            IEEEpw.println(citationsToWrite[j]);
                        }
                        else if(j>(numberOfEachCitation-1) & j<((2*numberOfEachCitation))){
                            ACMpw.println(citationsToWrite[j]);
                        }
                        else{
                            NJpw.println(citationsToWrite[j]);
                        }

                    }

                    //Closing each output stream after writing is finished
                    IEEEpw.close();
                    ACMpw.close();
                    NJpw.close();

                    //Closing input stream
                    inputStream.close();
                  
                  //Catch statement incase an empty field is detected
                } catch (FileInvalidException e) {
                    System.out.println();
                    System.out.println("Error: Detected Empty Field!");
                    System.out.println("=============================");
                    System.out.println("");
                    System.out.println("Problem detected with file Latex"+i+".bib");
                    System.out.println(e.getMessage());
                    System.out.println();

                    //Deleting the citation files created with the empty fields
                    File IEEEfileToDelete = new File("OutputFiles/"+"IEEE"+i+".txt");
                    File ACMfileToDelete = new File("OutputFiles/"+"ACM"+i+".txt");
                    File NJfileToDelete = new File("OutputFiles/"+"NJ"+i+".txt");

                    IEEEfileToDelete.delete();
                    ACMfileToDelete.delete();
                    NJfileToDelete.delete();
                    invalidFiles++;

                }

               

            
            //Catch statement incase an input file could not be opened
            } catch (FileNotFoundException e) {
                System.out.println();
                System.out.println("Could not open input file Latex" + i + ".bib for reading.");
                System.out.println();
                System.out.println("Please check if file exists! Program will terminate after closing any opened files.");
                System.out.println();
                inputStream.close();
                System.exit(0);
            }




        }
       
       //MAIN PROCESSING ENDS HERE
       //All valid citation files created and generated
       
       //Final stats printed for user
       System.out.println("A total of " + invalidFiles + " files were invalid, and could not be processed. All other " + (10-invalidFiles) + " Valid files have been created.");
       System.out.println();
       
       //Try block to ask user if they want to review a file
        try {
           
           //Getting user input and creating a file object
           System.out.println("Enter the file name you would like to review: ");
           String userInputFileName = keyboard.nextLine();
           File userInputFile = new File("OutputFiles/"+userInputFileName);

           //Buffered reader to read through the file the user wants
           BufferedReader bf1 = new BufferedReader(new FileReader(userInputFile));
           
           //If file exists then output each line of the file
           if(userInputFile.exists()){
            System.out.println();
            while(line != (null)){
                try {
                    line = bf1.readLine();
                } catch (IOException e) {
                    System.out.println("Error while reading file");
                }
                if(line!=null){
                 System.out.println(line);
                }
            }
           }

           //Close the buffered reader
           try {
               bf1.close();
           } catch (IOException e) {
                System.out.println("Error while closing Buffered Reader");
           }

         //Incase file was not found in first attempt
         //Catch statement is invoked and run
       } catch (FileNotFoundException e) {

           //Printing remarks to user and asking for user input again
           System.out.println("Could not open the input file. Either it doesn't exist or could not bre created");
           System.out.println();
           System.out.println("However you will be given another chance to enter a file name");
           System.out.println("Please enter the name of the file you would like to review: ");
           String userInputFileName = keyboard.nextLine();
           File userInputFile = new File("OutputFiles/"+userInputFileName);

           //Creating buffered reader object to read through the file the user wants
           //If file exists ouput each line of the file
           try {
                BufferedReader bf1 = new BufferedReader(new FileReader(userInputFile));
               if(userInputFile.exists()){
                System.out.println();
                while(line != (null)){
                    try {
                        line = bf1.readLine();
                    } catch (IOException e1) {
                        System.out.println("Error while reading file");
                    }
                    if(line!=null){
                     System.out.println(line);
                    }
                }

                //Closing buffered reader
                try {
                    bf1.close();
                } catch (IOException e1) {
                     System.out.println("Error while closing Buffered Reader");
                }
            }

            //Incase the file is not found again
            //This catch statement is then invoked and run
           } catch (FileNotFoundException e1) {
               System.out.println();
               System.out.println("Could not open input file again! Either file doesn't exist or could not be created!");
               System.out.println("Sorry! I am unable to display your desired files! Program will exit!");
               System.exit(0);
           }

       }

       //Closing keyboard object
       keyboard.close();

       //Closing remarks of program
       System.out.println();
       System.out.println("~~~~~~~~~~~~~~~~~~");
       System.out.println("PROGRAM FINISHED");
       System.out.println("~~~~~~~~~~~~~~~~~~");
       System.out.println();

       



    }
    
}
