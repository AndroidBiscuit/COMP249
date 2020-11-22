package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

public class Article {
    private String authorString;
    private String journal;
    private String title;
    private String volume;
    private String pages;
    private String doi;
    private String month;
    private int year;
    private int number;

    /**
     * Default Constructor
     * Note: Sets default values for each private variable
     */
    public Article(){
        this.authorString = "";
        this.journal = "";
        this.title = "";
        this.volume = "";
        this.pages = "";
        this.doi = "";
        this.month = "";
        this.year = 0;
        this.number = 0;
    }

    /**
     * Parameterized Constructor
     * @param authorString String representing the author of the article
     * @param journal String representing the journal of the article
     * @param title String representing the title of the article
     * @param year int representing the year of the article
     * @param volume String representing the volume of the article
     * @param number int representing the number of the article
     * @param pages String representing the pages of the article
     * @param doi String representing the doi of the article
     * @param month String representing the month of the article
     */
    public Article(String authorString , String journal, String title, String volume, String pages, String keywords, String doi, String ISSN, String month, int year, int number) {
        this.authorString = authorString;
        this.journal = journal;
        this.title = title;
        this.volume = volume;
        this.pages = pages;
        this.doi = doi;
        this.month = month;
        this.year = year;
        this.number = number;
    }


    /**
     * Copy Constructor
     * @param article object of type Article to copy
     */
    public Article(Article article) {
        this.authorString = article.authorString;
        this.journal = article.journal;
        this.title = article.title;
        this.volume = article.volume;
        this.pages = article.pages;
        this.doi = article.doi;
        this.month = article.month;
        this.year = article.year;
        this.number = article.number;
    }

    /**
     * Accessor for the author of the article
     * @return String representing the author of the article
     */
    public String getAuthors() {
        return authorString;
    }

    /**
     * Accessor for the journal of the article
     * @return String representing the journal of the article
     */
    public String getJournal() {
        return journal;
    }

    /**
     * Accessor for the title of the article
     * @return String representing the title of the article
     */
    public String getTitle() {
        return title;
    }

    /**
     * Accessor for the year of the article
     * @return int representing the year of the article
     */
    public int getYear() {
        return year;
    }

    /**
     * Accessor for the volume of the article
     * @return String representing the volume of the article
     */
    public String getVolume() {
        return volume;
    }

    /**
     * Accessor for the number of the article
     * @return int representing the number of the article
     */
    public int getNumber() {
        return number;
    }

    /**
     * Accessor for the pages of the article
     * @return String representing the pages of the article
     */
    public String getPages() {
        return pages;
    }

    /**
     * Accessor for the doi of the article
     * @return String representing the doi of the article
     */
    public String getDoi() {
        return doi;
    }

    /**
     * Accessor for the month of the article
     * @return String representing the month of the article
     */
    public String getMonth() {
        return month;
    }

    /**
     * Mutator for the author of the article
     * @param authors String representing the author of the article
     */
    public void setAuthors(String authors) {
        this.authorString = authors;
    }

    /**
     * Mutator for the journal of the article
     * @param journal String representing the journal of the article
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     * Mutator for the title of the article
     * @param title String representing the title of the article
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Mutator for the year of the article
     * @param year int representing the year of the article
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Mutator for the volume of the article
     * @param volume String representing the author of the article
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * Mutator for the number of the article
     * @param number int representing the number of the article
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Mutator for the pages of the article
     * @param pages String representing the pages of the article
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * Mutator for the doi of the article
     * @param doi String representing the doi of the article
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * Mutator for the month of the article
     * @param month String representing the month of the article
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * Reads the authorString stored and returns an arraylist holding all author names appearing in that String
     * @return A String ArrayList with the individual author Strings
     */
    public ArrayList<String> generateAuthorList() {
        ArrayList<String> authors = new ArrayList<String>();
        Scanner authorLineScanner = new Scanner(authorString);
        authorLineScanner.useDelimiter(" and ");

        while(authorLineScanner.hasNext()){
            authors.add(authorLineScanner.next());
        }

        return authors;
    }

    /**
     * Stores all the info of the Article Class in a String
     * @return String containing the info article object
     */
    public String toString() {
        return "Article{" +
                "authors=" + authorString +
                ", journal='" + journal + '\'' +
                ", title='" + title + '\'' +
                ", volume='" + volume + '\'' +
                ", pages='" + pages + '\'' +
                ", doi='" + doi + '\'' +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", number=" + number +
                '}';
    }
}
