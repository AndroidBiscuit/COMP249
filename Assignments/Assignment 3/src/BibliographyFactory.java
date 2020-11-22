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

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliographyFactory {
    private static int latexFiles = 10;
    private static String filePath = "E:\\Users\\Faizan\\Documents\\Polytechnique Montréal\\Concordia\\COMP 249 - Object-Oriented Programming II\\Assignments\\Assignment 3\\Assignment Test Files";

    /**
     * Quits the program
     */
    public static void quitProgram(){
        //System.out.println("The program has been terminated!" + "\n" + "Have a nice day!");
        System.exit(0);
    }

    /**
     * Test program to read a file (basis for processFilesForValidation class)
     * Check the FileHandler class for more info and code
     */
    public static void processFilesForValidation(){
        int articleCounter = 0;
        Article article = new Article();
        ArrayList<Article> articleList = new ArrayList<Article>();
        ArrayList<ArrayList<Article>> totalArticles = new ArrayList<ArrayList<Article>>(10);

        articleList.add(article);
        totalArticles.add(articleList);

        // Part 1: Read and store the text in the files
        try {
            for (int i = 0; i < 10; i++) {
                File latex = new File(filePath + "\\Latex" + (i+1) + ".bib");
                Scanner scanner = new Scanner(new FileInputStream(latex));
                System.out.println("Latex" + (i+1) + ".bib");

                while(scanner.hasNextLine()){
                    while (scanner.hasNextLine()){
                        String line = scanner.nextLine();
                        //System.out.println(line);

                        // Checks if the line contains an empty line
                        if (line.contains("{}")){
                            scanner.close();
                            System.out.println("Error - Empty line");
                            quitProgram();
                        }

                        // Checks if the line is the beginning of a new article
                        if (line.contains("@ARTICLE{")){
                            ++articleCounter;
                            //System.out.println("A");
                        }

                        // Checks if the line is the end of a new article
                        if (line.startsWith("}")){
                            break;
                        }

                        ////////////////////////////////////////////////////////////////////////
                        if (line.startsWith("author")){
                            article.setAuthors(line.substring("author={".length(), line.length()-3));
                        }
                        if (line.startsWith("journal")){
                            article.setJournal(line.substring("journal={".length(), line.length()-3));
                        }
                        if (line.startsWith("title")){
                            article.setTitle(line.substring("title={".length(), line.length()-3));
                        }
                        if (line.startsWith("year")){
                            article.setYear(line.substring("year={".length(), line.length()-3));
                        }
                        if (line.startsWith("volume")){
                            article.setVolume(line.substring("volume={".length(), line.length()-3));
                        }
                        if (line.startsWith("number")){
                            article.setNumber(line.substring("number={".length(), line.length()-3));
                        }
                        if (line.startsWith("pages")){
                            article.setPages(line.substring("pages={".length(), line.length()-3));
                        }
                        if (line.startsWith("doi")){
                            article.setDoi(line.substring("doi={".length(), line.length()-3));
                        }
                        if (line.startsWith("month")){
                            article.setMonth(line.substring("month={".length(), line.length()-3));
                        }
                        ////////////////////////////////////////////////////////////////////////
                    }
                    System.out.println(article.generateIEEE());
                    articleList.add(article);
                    article.clearArticle();
                }
                totalArticles.add(articleList);
                scanner.close();
                System.out.println(articleCounter + " ----------------------------------------------------------");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot open file: Does not exist");
        }
        System.out.println("Complete!");

        // Part 2: Write and store references into files
        try {
            for (int i = 0; i < totalArticles.size(); i++){
                PrintWriter output = new PrintWriter(filePath + "\\Output Files\\" + "IEEE" + (i+1) + ".json");
                for (int j = 0; j < totalArticles.get(i).size(); j++){
                    System.out.println(totalArticles.get(i).get(j).generateIEEE());
                    output.println(totalArticles.get(i).get(j).generateIEEE());
                }
                output.close();
            }
            for (int i = 0; i < totalArticles.size(); i++){
                PrintWriter output = new PrintWriter(filePath + "\\Output Files\\" + "ACM" + (i+1) + ".json");
                for (int j = 0; j < totalArticles.get(i).size(); j++){
                    output.println(totalArticles.get(i).get(j).generateACM());
                }
                output.close();
            }
            for (int i = 0; i < totalArticles.size(); i++){
                PrintWriter output = new PrintWriter(filePath + "\\Output Files\\" + "NJ" + (i+1) + ".json");
                for (int j = 0; j < totalArticles.get(i).size(); j++){
                    output.println(totalArticles.get(i).get(j).generateNJ());
                }
                output.close();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Cannot create/write file. Deleting any created files...");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to BibliographyFactory!");

        processFilesForValidation();

    }
}
