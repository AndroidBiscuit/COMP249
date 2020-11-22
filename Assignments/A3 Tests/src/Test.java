import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    private static String filePath = "E:\\Users\\Faizan\\Documents\\Polytechnique Montréal\\Concordia\\COMP 249 - Object-Oriented Programming II\\Assignments\\A3 Tests\\Files";

    static String[] bibPaths = new String[10];
    static Scanner[] bibInput = new Scanner[10];

    /**
     * Quits the program
     */
    public static void quitProgram(){
        //System.out.println("The program has been terminated!" + "\n" + "Have a nice day!");
        System.exit(0);
    }

    public static void main(String[] args) {
        try {
            Article article = new Article();
            ArrayList<Article> articleList = new ArrayList<Article>();
            //ArrayList<ArrayList<Article>> totalArticles = new ArrayList<ArrayList<Article>>(10);
            Scanner[] scanner = new Scanner[10];
            int articleCounter = 0;
            int listCounter = 0;

            for (int i = 0; i < 10; i++){
                File latex = new File(filePath + "\\Latex" + (i+1) + ".bib");
                //Scanner scanner = new Scanner(new FileInputStream(latex));

                System.out.println("---------------------------------------------------------------");
                System.out.println("Latex" + (i+1) + ".bib");

                while (scanner[i].hasNextLine()){
                    String line = scanner[i].nextLine();
                    // Checks if the line contains an empty line
                    if (line.contains("{}")){
                        scanner[i].close();
                        System.out.println("Error - Empty line");
                        quitProgram();
                    }

                    // Checks if the line is the end of a new article
                    if (line.startsWith("}")) {
                        articleCounter++;
                        break;
                    }

                    ////////////////////////////////////////////////////////////////////////
                    if (line.startsWith("author")) {
                        article.setAuthors(line.substring("author={".length(), line.indexOf("},")));
                    }
                    if (line.startsWith("journal")) {
                        article.setJournal(line.substring("journal={".length(), line.indexOf("},")));
                    }
                    if (line.startsWith("title")) {
                        article.setTitle(line.substring("title={".length(), line.indexOf("},")));
                    }
                    if (line.startsWith("year")) {
                        article.setYear(line.substring("year={".length(), line.indexOf("},")));
                    }
                    if (line.startsWith("volume")) {
                        article.setVolume(line.substring("volume={".length(), line.indexOf("},")));
                    }
                    if (line.startsWith("number")) {
                        article.setNumber(line.substring("number={".length(), line.indexOf("},")));
                    }
                    if (line.startsWith("pages")) {
                        article.setPages(line.substring("pages={".length(), line.indexOf("},")));
                    }
                    if (line.startsWith("doi")) {
                        article.setDoi(line.substring("doi={".length(), line.indexOf("},")));
                    }
                    if (line.startsWith("month")) {
                        article.setMonth(line.substring("month={".length(), line.indexOf("},")));
                    }
                    ////////////////////////////////////////////////////////////////////////
                }
                articleList.add(article);
                System.out.println("Article " + articleCounter + " added!");

                /*while (scanner.hasNextLine()) {
                    Article article = new Article();
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        // Checks if the line contains an empty line
                        if (line.contains("{}")){
                            scanner.close();
                            System.out.println("Error - Empty line");
                            quitProgram();
                        }

                        // Checks if the line is the end of a new article
                        if (line.startsWith("}")) {
                            articleCounter++;
                            break;
                        }

                        ////////////////////////////////////////////////////////////////////////

                        if (line.startsWith("author")) {
                            article.setAuthors(line.substring("author={".length(), line.indexOf("},")));
                        }
                        if (line.startsWith("journal")) {
                            article.setJournal(line.substring("journal={".length(), line.indexOf("},")));
                        }
                        if (line.startsWith("title")) {
                            article.setTitle(line.substring("title={".length(), line.indexOf("},")));
                        }
                        if (line.startsWith("year")) {
                            article.setYear(line.substring("year={".length(), line.indexOf("},")));
                        }
                        if (line.startsWith("volume")) {
                            article.setVolume(line.substring("volume={".length(), line.indexOf("},")));
                        }
                        if (line.startsWith("number")) {
                            article.setNumber(line.substring("number={".length(), line.indexOf("},")));
                        }
                        if (line.startsWith("pages")) {
                            article.setPages(line.substring("pages={".length(), line.indexOf("},")));
                        }
                        if (line.startsWith("doi")) {
                            article.setDoi(line.substring("doi={".length(), line.indexOf("},")));
                        }
                        if (line.startsWith("month")) {
                            article.setMonth(line.substring("month={".length(), line.indexOf("},")));
                        }
                        ////////////////////////////////////////////////////////////////////////
                    }
                    articleList.add(article);
                    System.out.println("Article " + articleCounter + " added!");
                }*/
                articleCounter = 0;
                totalArticles.add(articleList);
                listCounter++;
                System.out.println("List " + listCounter + " added!");
                System.out.println("---------------------------------------------------------------");
            }


            System.out.println("Adding Complete!");
            System.out.println(totalArticles.size());
            System.out.println(articleList.size());


            for (int j = 0; j < articleList.size(); j++){
                System.out.println(totalArticles.get(2).get(j).generateIEEE());
                System.out.println("- - - - - - - - Next article - - - - - - - -");
            }



        } catch (FileNotFoundException e) {
            System.out.println("Cannot open file: Does not exist");
        }
        System.out.println("EOP");
    }
}
