package Assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//-----------------------------------------------------
//Assignment 3
//Question: Part 1/1
//Written by: Jacques-Andre Roebuck 40128691, Joseph Saliba 40183705
//-----------------------------------------------------

public class BibliographyFactory {

    final static int latexFiles = 10;

    //String array for each bib paths
    static String[] bibPaths = new String[latexFiles];

    //Scanner object for each bib file
    static Scanner[] bibInput = new Scanner[latexFiles];

    //static ArrayList<Article>[] article2darr = new ArrayList[latexFiles];

    //Paths to each output Files
    static String[] ieeePath = new String[latexFiles];
    static String[] acmPath = new String[latexFiles];
    static String[] njPath = new String[latexFiles];

    //File instances that represents each Output file
    static File[] ieeeFiles = new File[latexFiles];
    static File[] acmFiles = new File[latexFiles];
    static File[] njFiles = new File[latexFiles];

    //Output streams to each output file
    static FileOutputStream[] ieeeFileOutput = new FileOutputStream[latexFiles];
    static FileOutputStream[] acmFileOutput = new FileOutputStream[latexFiles];
    static FileOutputStream[] njFileOutput = new FileOutputStream[latexFiles];

    //PrintWriter objects for each output file
    static PrintWriter[] ieeePrintWriters = new PrintWriter[latexFiles];
    static PrintWriter[] acmpPrintWriters = new PrintWriter[latexFiles];
    static PrintWriter[] njPrintWriters = new PrintWriter[latexFiles];

    public static void main(String[] args){

        // Step 3
        // Open Latex1.bib to Latex10.bib
        for (int i = 1; i < latexFiles + 1; i++) {
            String path = "src/Assignment3/InputFiles/Latex" + i + ".bib";
            bibPaths[i-1] = path; //Stores the path variable in the path array

            // Open file i
            try {
                bibInput[i-1] = new Scanner(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                System.out.println("Could not open input file " + path + " for reading. Please check if file exists!\n" +
                        "Program will terminate after closing any opened files.");
                for (int j = 0; j < i - 1; j++) {
                    bibInput[j].close();
                }
                System.exit(0);
            }
        }

        // Step 4
        for (int i = 1; i < latexFiles + 1; i++) {
            //Instantiate all of the path types
            String ieeepathstr = "src/Assignment3/OutputFiles/IEEE" + i + ".json";
            String acmpathstr = "src/Assignment3/OutputFiles/ACM" + i + ".json";
            String njpathstr = "src/Assignment3/OutputFiles/NJ" + i + ".json";

            //create the files i
            try {
                ieeePath[i-1] = ieeepathstr;
                ieeeFiles[i-1] = new File(ieeePath[i-1]);
                ieeeFileOutput[i-1] = new FileOutputStream(ieeeFiles[i-1]);
                ieeePrintWriters[i-1] = new PrintWriter(ieeeFileOutput[i-1]);
                System.out.println("Created file: " + ieeePath[i-1]);
            } catch (Exception e) {
                System.out.println("Could not create file " + ieeePath[i-1] + ".\nNow closing all input files and deleting all output files created.");
                closeAllInputFiles();
                deleteOutputFiles();
                System.exit(0);
            }

            try {
                acmPath[i-1] = acmpathstr;
                acmFiles[i-1] = new File(acmPath[i-1]);
                acmFileOutput[i-1] = new FileOutputStream(acmFiles[i-1]);
                acmpPrintWriters[i-1] = new PrintWriter(acmFileOutput[i-1]);
                System.out.println("Created file: " + acmPath[i-1]);
            } catch (Exception e) {
                System.out.println("Could not create file " + acmPath[i-1] + ".\nNow closing all input files and deleting all output files created.");
                closeAllInputFiles();
                deleteOutputFiles();
                System.exit(0);
            }

            try {
                njPath[i-1] = njpathstr;
                njFiles[i-1] = new File(njPath[i-1]);
                njFileOutput[i-1] = new FileOutputStream(njFiles[i-1]);
                njPrintWriters[i-1] = new PrintWriter(njFileOutput[i-1]);
                System.out.println("Created file: " + njPath[i-1]);
            } catch (Exception e) {
                System.out.println("Could not create file " + njPath[i-1] + ".\nNow closing all input files and deleting all output files created.");
                closeAllInputFiles();
                deleteOutputFiles();
                System.exit(0);
            }
        }

        // Step 5
        processFilesForValidation();
        closeAllOutputStreams();
        closeAllInputFiles();

        // Step 7
        Scanner userInput = new Scanner(System.in);
        String outputFileToDisplay;
        for (int i = 0; i < 2; i++){
            System.out.print("Enter the name of the file you wish to display. (Example Inputs: \"ACM6.json\", \"IEEE3.json\")\n>>> ");
            outputFileToDisplay = "src/Assignment3/OutputFiles/" + userInput.nextLine();
            String line = "";

            try {
                BufferedReader br = new BufferedReader(new FileReader(outputFileToDisplay));
                System.out.println("Here are the contents of " + outputFileToDisplay + ":\n");
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                br.close();
                break;
            } catch (FileNotFoundException e) {
                if (i == 0)
                    System.out.println(outputFileToDisplay + " does not exist. Please try again (1 more try remaining)");
                else {
                    System.out.println(outputFileToDisplay + " does not exist. Exiting program.");
                }
            } catch (IOException e){
                System.out.println("IO Exception, could not read the file " + outputFileToDisplay);
            }
        }
        // deleteOutputFiles(); for testing

    }

    /**
     * Main Engine method to Proceed with the requested task.
     * The method reads each line of each Input file to collect the data and create Article instances to store the read attributes.
     * The Method then passes each arraylist of articles made for the different Input Files to another method for writing
     */
    private static void processFilesForValidation() {

        System.out.println();

        for (int i = 1; i < latexFiles + 1; i++) {

            ArrayList<Article> articleArrayList = new ArrayList<>();
            Article tempArticle = new Article();

            try {

                int lineCounter = 0;
                int articleCounter = 1;

                while (bibInput[i-1].hasNextLine()) {
                    lineCounter++;
                    String line = bibInput[i - 1].nextLine();//creates the string of the line being read

                    if (line.contains("{}")) { //means invalid
                        Scanner inlineScanner = new Scanner(line);
                        inlineScanner.useDelimiter("=");
                        throw new FileInvalidException(inlineScanner.next(), articleCounter, lineCounter);

                    } else if (line.contains("={")) { //means field is being defined

                        Scanner inlineScanner = new Scanner(line);
                        inlineScanner.useDelimiter("=\\{");
                        String field = inlineScanner.next();
                        Scanner secondInlineScanner = new Scanner(inlineScanner.next());
                        secondInlineScanner.useDelimiter("},");

                        switch (field) { //takes the field name
                            case "author":
                                tempArticle.setAuthors(secondInlineScanner.next());
                                break;

                            case "journal":
                                tempArticle.setJournal(secondInlineScanner.next());
                                break;

                            case "title":
                                tempArticle.setTitle(secondInlineScanner.next());
                                break;

                            case "year":
                                tempArticle.setYear(Integer.parseInt(secondInlineScanner.next()));
                                break;

                            case "volume":
                                tempArticle.setVolume(secondInlineScanner.next());
                                break;

                            case "number":
                                tempArticle.setNumber(Integer.parseInt(secondInlineScanner.next()));
                                break;

                            case "pages":
                                tempArticle.setPages(secondInlineScanner.next());
                                break;

                            case "keywords":
                                tempArticle.setKeywords(secondInlineScanner.next());
                                break;

                            case "doi":
                                tempArticle.setDoi(secondInlineScanner.next());
                                break;

                            case "ISSN":
                                tempArticle.setISSN(secondInlineScanner.next());
                                break;

                            case "month":
                                tempArticle.setMonth(secondInlineScanner.next());
                                break;
                        }


                    }else if (line.equals("}")){ //means end of article
                        articleCounter++;
                        articleArrayList.add(new Article(tempArticle)); //adds a copy of the object holding the read field values to an array list that will later be passed on
                    }
                }

                System.out.println("File " + bibPaths[i-1] + " is valid. Now Writing...");
                writeFiles(articleArrayList, i);

            } catch (FileInvalidException e) {
                // Step 6
                bibInput[i-1].close();
                System.out.print("File " + bibPaths[i-1] + " is NOT valid: ");
                System.out.println(e.getMessage());
                deleteOutputFiles(i);

            } catch (Exception e) {
                System.out.println(e + e.getMessage());
            }
        }
    }

    /**
     * This Method runs for each Input file.
     * It takes as Argument an Arraylist of Article Objects which represent all articles in an Input file.
     * The Method takes these Article Objects to then write a file of each of the IEEE, ACM and NJ files
     * @param articleArrayList Article Arraylist holding all the articles of the Input file
     * @param i index passed on
     */
    private static void writeFiles(ArrayList<Article> articleArrayList, int i) {

        int articleCount = 1;
        for (Article article : articleArrayList) {

            //IEEE files
            for (String author : article.getAuthorArrayList()) {
                //Writes the authors
                if (article.getAuthorArrayList().get(article.getAuthorArrayList().size()-1).equals(author)) { //checks to see if the author string in the loop is the last one of the array to add a dot
                    ieeePrintWriters[i - 1].print(author + ". ");
                } else {
                    ieeePrintWriters[i - 1].print(author + ", ");
                }
            }
            ieeePrintWriters[i - 1].print("\"" + article.getTitle() + "\", " + article.getJournal() + ", " + "vol. " + article.getVolume() + ", " + "no. " + article.getNumber() + ", " + "p. " + article.getPages() + ", " + article.getMonth() + " " + article.getYear() + "." + "\n\n");

           //ACM Files
           acmpPrintWriters[i-1].print("[" + articleCount + "]\t");
            articleCount++;

                if (article.getAuthorArrayList().size() > 1) //checks if there are more than one author to put "et al."
                    acmpPrintWriters[i-1].print(article.getAuthorArrayList().get(0) + " et al. ");
                else acmpPrintWriters[i-1].print(article.getAuthorArrayList().get(0) + ". ");
            acmpPrintWriters[i-1].print(article.getYear() + ". " + article.getTitle() + ". " + article.getJournal() + ". " + article.getVolume() + ", " + article.getNumber() + " (" + article.getYear() + "), " + article.getPages() + ". DOI:https://doi.org/" + article.getDoi() + ".\n\n");

            //NJ Files
            for (String author : article.getAuthorArrayList()) {

                if (article.getAuthorArrayList().get(article.getAuthorArrayList().size()-1).equals(author)) { //checks to see if the author string in the loop is the last one of the array to add a dot
                    njPrintWriters[i - 1].print(author + ". ");
                } else {
                    njPrintWriters[i - 1].print(author + " & ");
                }
            }
            njPrintWriters[i - 1].print(article.getTitle() + ". " + article.getJournal() + ". " + article.getVolume() + ", " + article.getPages() + "(" + article.getYear() + ").\n\n");

        }
    }

    /**
     * Closes all scanner objects
     */
    private static void closeAllInputFiles() {
        for (Scanner scanner : bibInput)
            scanner.close();
    }

    /**
     * Closes all Output Streams (PrintWriter Objects)
     */
    private static void closeAllOutputStreams() {
        try {
            for (PrintWriter printWriter : ieeePrintWriters)
                printWriter.close();

            for (PrintWriter printWriter : acmpPrintWriters)
                printWriter.close();

            for (PrintWriter printWriter : njPrintWriters)
                printWriter.close();

        } catch (Exception e) {
            System.out.println("Couldn't Close all printwriters");
        }
    }

    /**
     * Cleans the outputfiles directory (deletes everything)
     */
    private static void deleteOutputFiles() {
        closeAllOutputStreams();
        for (File file : ieeeFiles)
            file.delete();

        for (File file : acmFiles)
            file.delete();

        for (File file : njFiles)
            file.delete();
    }

    /**
     * Delete the file at index i
     * @param i index of the file to delete
     */
    private static void deleteOutputFiles(int i) { //deletes IEEE, ACM, and NJ files number i
        try {
            //Closes the output before deleting
            ieeeFileOutput[i - 1].close();
            acmFileOutput[i - 1].close();
            njFileOutput[i - 1].close();

            if(ieeeFiles[i - 1].delete())
                System.out.println("Deleted " + ieeePath[i - 1]);

            if(acmFiles[i - 1].delete())
                System.out.println("Deleted " + acmPath[i - 1]);

            if(njFiles[i - 1].delete())
                System.out.println("Deleted " + njPath[i - 1]);

        } catch(Exception e) {
            System.out.println("Couldn't close all output files in deleteOutputFiles(int i) method");
        }
    }
}
