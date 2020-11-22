/**
 * Name and ID: Faizan Ahmad 40100581
 * COMP249
 * Assignment #3
 * Due Date: November 13th 2020
 *
 * IMPORTANT: Due to a big course load (exams, quizzes, projects, etc.) this
 * assignment is INCOMPLETE. If possible, Please correct as much as you can and
 * not just overview it and give 0 because it does not output everything.
 *
 * If you want to run it, please change directory (variable filePath)
 *
 * Thanks.
 */

package Assignment3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliographyFactory {
    private static String filePath = "E:\\Users\\Faizan\\Documents\\Polytechnique Montréal\\Concordia\\COMP 249 - Object-Oriented Programming II\\Assignments\\Ass3";

    final static int latexFiles = 10;

    // String array for each bib paths
    static String[] bibPaths = new String[10];

    // Scanner object for each bib file
    static Scanner[] bibInput = new Scanner[10];

    // Paths to each output Files
    static String[] ieeePath = new String[10];
    static String[] acmPath = new String[10];
    static String[] njPath = new String[10];

    // File instances that represents each Output file
    static File[] ieeeFiles = new File[10];
    static File[] acmFiles = new File[10];
    static File[] njFiles = new File[10];

    // Output streams to each output file
    static FileOutputStream[] ieeeFileOutput = new FileOutputStream[10];
    static FileOutputStream[] acmFileOutput = new FileOutputStream[10];
    static FileOutputStream[] njFileOutput = new FileOutputStream[10];

    // PrintWriter objects for each output file
    static PrintWriter[] ieeePrintWriters = new PrintWriter[10];
    static PrintWriter[] acmpPrintWriters = new PrintWriter[10];
    static PrintWriter[] njPrintWriters = new PrintWriter[10];

    /**
     * Quits the program
     */
    public static void quitProgram(){
        System.out.println("================================================");
        System.out.println("The program has been terminated!" + "\n" + "Have a nice day!");
        System.out.println("================================================");
        System.exit(0);
    }

    public static void main(String[] args){
        // Step 3
        // Open all latex files (Latex1.bib to Latex10.bib)
        for (int i = 1; i < 11; i++) {
            String path = filePath + "/InputFiles/Latex" + i + ".bib";

            // Save the path for later (in case we need it)
            bibPaths[i - 1] = path;

            // Open file i
            try {
                bibInput[i - 1] = new Scanner(new FileInputStream(path));
            } catch (FileNotFoundException e) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Error - Cannot open " + path + "\n" + "File may not exist." + "\n" +
                        "Program will terminate after closing any opened files.");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                for (int j = 0; j < i - 1; j++) {
                    bibInput[j].close();
                }
                quitProgram();
            }
        }

        // Step 4
        for (int i = 1; i < 11; i++) {
            // Instantiate all of the path types
            String ieeePathName = filePath + "/OutputFiles/IEEE" + i + ".json";
            String acmPathName = filePath + "/OutputFiles/ACM" + i + ".json";
            String njPathName = filePath + "/OutputFiles/NJ" + i + ".json";

            // For IEEE
            try {
                ieeePath[i-1] = ieeePathName;
                ieeeFiles[i-1] = new File(ieeePath[i-1]);
                ieeeFileOutput[i-1] = new FileOutputStream(ieeeFiles[i-1]);
                ieeePrintWriters[i-1] = new PrintWriter(ieeeFileOutput[i-1]);
                System.out.println("Created file: " + "IEEE" + (i - 1) + ".json");
            } catch (Exception e) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Error - Could not create file " + "IEEE" + (i - 1) + ".json" + "\n" +
                        "Closed all input files and deleted all output files.");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                closeAllInputFiles();
                deleteOutputFiles();
                quitProgram();
            }

            // For ACM
            try {
                acmPath[i-1] = acmPathName;
                acmFiles[i-1] = new File(acmPath[i-1]);
                acmFileOutput[i-1] = new FileOutputStream(acmFiles[i-1]);
                acmpPrintWriters[i-1] = new PrintWriter(acmFileOutput[i-1]);
                System.out.println("Created file: " + "ACM" + (i - 1) + ".json");
            } catch (Exception e) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Error - Could not create file " + "ACM" + (i - 1) + ".json" + "\n" +
                        "Closed all input files and deleted all output files.");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                closeAllInputFiles();
                deleteOutputFiles();
                quitProgram();
            }

            // For NJ
            try {
                njPath[i - 1] = njPathName;
                njFiles[i - 1] = new File(njPath[i-1]);
                njFileOutput[i - 1] = new FileOutputStream(njFiles[i-1]);
                njPrintWriters[i - 1] = new PrintWriter(njFileOutput[i-1]);
                System.out.println("Created file: " + "NJ" + (i - 1) + ".json");
            } catch (Exception e) {
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                System.out.println("Error - Could not create file " + "NJ" + (i - 1) + ".json" + "\n" +
                        "Closed all input files and deleted all output files.");
                System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
                closeAllInputFiles();
                deleteOutputFiles();
                quitProgram();
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
            outputFileToDisplay = filePath + "/OutputFiles/" + userInput.nextLine();
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
    }

    /**
     * Reads input files and saves the information in Article objects
     * Note: uses another method (writeFiles) to make and save files
     */
    private static void processFilesForValidation() {
        for (int i = 1; i < 11; i++) {
            ArrayList<Article> articleList = new ArrayList<>();
            Article tempArticle = new Article();

            try {
                int lineCounter = 0;
                int articleCounter = 1;

                while (bibInput[i - 1].hasNextLine()) {
                    lineCounter++;

                    // Make a string of the line being read
                    String line = bibInput[i - 1].nextLine();

                    // Checks if the line contains an empty line (invalid)
                    if (line.contains("{}")) {
                        Scanner lineScanner = new Scanner(line);
                        lineScanner.useDelimiter("=");
                        throw new FileInvalidException(lineScanner.next(), articleCounter, lineCounter);

                        // Checks if the line contains info about the article
                    } else if (line.contains("={")) {
                        Scanner lineScanner = new Scanner(line);

                        // Will be used later to analyse the type of the info
                        lineScanner.useDelimiter("=\\{");

                        // IMPORTANT: will be used later to store info in Article object
                        String field = lineScanner.next();

                        Scanner newScanner = new Scanner(lineScanner.next());
                        newScanner.useDelimiter("},");

                        // Now we use the field variable to store everything in the proper article class
                        switch (field) { //takes the field name
                            case "author":
                                tempArticle.setAuthors(newScanner.next());
                                break;
                            case "journal":
                                tempArticle.setJournal(newScanner.next());
                                break;
                            case "title":
                                tempArticle.setTitle(newScanner.next());
                                break;
                            case "year":
                                tempArticle.setYear(Integer.parseInt(newScanner.next()));
                                break;
                            case "volume":
                                tempArticle.setVolume(newScanner.next());
                                break;
                            case "number":
                                tempArticle.setNumber(Integer.parseInt(newScanner.next()));
                                break;
                            case "pages":
                                tempArticle.setPages(newScanner.next());
                                break;
                            case "doi":
                                tempArticle.setDoi(newScanner.next());
                                break;
                            case "month":
                                tempArticle.setMonth(newScanner.next());
                                break;
                        }

                        // Checks if the line is the end of a new article
                    }else if (line.equals("}")){
                        articleCounter++;
                        articleList.add(new Article(tempArticle));
                    }
                }

                System.out.println("File " + bibPaths[i-1] + " is valid. Now Writing...");
                writeFiles(articleList, i);

            } catch (FileInvalidException e) {
                bibInput[i-1].close();
                System.out.println("****************************************************");
                System.out.print("Error - File " + bibPaths[i-1] + " is NOT valid: ");
                System.out.println("****************************************************");
                System.out.println(e.getMessage());
                deleteOutputFiles(i);

            } catch (Exception e) {
                System.out.println(e + e.getMessage());
            }
        }
    }

    /**
     * Writes all articles in files IEEE, ACM and NJ (runs for each input file)
     * @param articleArrayList ArrayList of type Article that contains all articles of an Input file
     * @param index int representing the index passed on
     */
    private static void writeFiles(ArrayList<Article> articleArrayList, int index) {

        int articleCount = 1;
        for (Article article : articleArrayList) {
            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            // For IEEE

            for (String author : article.generateAuthorList()) {
                //Writes the authors

                // Check if author string in the loop is the last author
                if (article.generateAuthorList().get(article.generateAuthorList().size()-1).equals(author)) {
                    ieeePrintWriters[index - 1].print(author + ". ");
                } else {
                    ieeePrintWriters[index - 1].print(author + ", ");
                }
            }
            ieeePrintWriters[index - 1].print("\"" + article.getTitle() + "\", " + article.getJournal() + ", " + "vol. " + article.getVolume() + ", " + "no. " + article.getNumber() + ", " + "p. " + article.getPages() + ", " + article.getMonth() + " " + article.getYear() + "." + "\n\n");

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            // For ACM

            acmpPrintWriters[index-1].print("[" + articleCount + "]\t");
            articleCount++;

            // Check if there are more than one author (if true, then add "et al.")
            if (article.generateAuthorList().size() > 1){
                acmpPrintWriters[index - 1].print(article.generateAuthorList().get(0) + " et al. ");
            }
            else {
                acmpPrintWriters[index - 1].print(article.generateAuthorList().get(0) + ". ");
            }

            // Take care of the rest of the reference
            acmpPrintWriters[index - 1].print(article.getYear() + ". " + article.getTitle() + ". " +
                    article.getJournal() + ". " + article.getVolume() + ", " + article.getNumber() +
                    " (" + article.getYear() + "), " + article.getPages() + ". DOI:https://doi.org/" +
                    article.getDoi() + ".\n\n");

            ////////////////////////////////////////////////////////////////////////////////////////////////////////
            // For NJ (basically similar to the one for IEEE

            // Check if author string in the loop is the last author
            for (String author : article.generateAuthorList()) {

                if (article.generateAuthorList().get(article.generateAuthorList().size()-1).equals(author)) {
                    njPrintWriters[index - 1].print(author + ". ");
                } else {
                    njPrintWriters[index - 1].print(author + " & ");
                }
            }
            njPrintWriters[index - 1].print(article.getTitle() + ". " + article.getJournal() + ". " + article.getVolume() + ", " + article.getPages() + "(" + article.getYear() + ").\n\n");

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
     * Close all PrintWriter objects
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
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Error - Failed to close all PrintWriter objects");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
    }

    /**
     * Delete the content of the output files directory
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
     * Delete a specific file (at location index)
     * @param index int representing the index of the file to delete
     */
    private static void deleteOutputFiles(int index) {
        try {
            // Make sure to close the output before deleting
            ieeeFileOutput[index - 1].close();
            acmFileOutput[index - 1].close();
            njFileOutput[index - 1].close();

            if(ieeeFiles[index - 1].delete()){
                System.out.println("Deleted " + ieeePath[index - 1]);
            }


            if(acmFiles[index - 1].delete()){
                System.out.println("Deleted " + acmPath[index - 1]);
            }


            if(njFiles[index - 1].delete()){
                System.out.println("Deleted " + njPath[index - 1]);
            }

        } catch(Exception e) {
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Error - Failed to close all output files in deleteOutputFiles method");
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
    }
}
