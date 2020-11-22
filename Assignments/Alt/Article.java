package Assignment3;

import java.util.ArrayList;
import java.util.Scanner;

//-----------------------------------------------------
//Assignment 3
//Question: Part 1/1
//Written by: Jacques-Andre Roebuck 40128691, Joseph Saliba 40183705
//-----------------------------------------------------

public class Article {

    private String authorString;
    private String journal;
    private String title;
    private String volume;
    private String pages;
    private String keywords;
    private String doi;
    private String ISSN;
    private String month;
    private int year;
    private int number;

    /**
     * Default Constructor for Article Class
     */
    public Article(){
        // temp empty article
        this.authorString = "";
        this.journal = "";
        this.title = "";
        this.volume = "";
        this.pages = "";
        this.keywords = "";
        this.doi = "";
        this.ISSN = "";
        this.month = "";
        this.year = 0;
        this.number = 0;
    }

    /**
     * Parametrized constructor for the Article Class
     * @param authorString Takes The whole String of the authors which will later be tokenized to get individual author Strings
     * @param journal Journal String Retrieved
     * @param title Title String Retrieved
     * @param volume Volume String Retrieved
     * @param pages Pages String Retrieved
     * @param keywords Keywords String Retrieved
     * @param doi Doi String Retrieved
     * @param ISSN ISSN String Retrieved
     * @param month Month String Retrieved
     * @param year Year int Retrieved
     * @param number Number int Retrieved
     */
    public Article(String authorString , String journal, String title, String volume, String pages, String keywords, String doi, String ISSN, String month, int year, int number) {
        this.authorString = authorString;
        this.journal = journal;
        this.title = title;
        this.volume = volume;
        this.pages = pages;
        this.keywords = keywords;
        this.doi = doi;
        this.ISSN = ISSN;
        this.month = month;
        this.year = year;
        this.number = number;
    }


    /**
     * Copy Constructor
     * @param article Article Object to Create a deep copy of
     */
    public Article(Article article) {
        this.authorString = article.authorString;
        this.journal = article.journal;
        this.title = article.title;
        this.volume = article.volume;
        this.pages = article.pages;
        this.keywords = article.keywords;
        this.doi = article.doi;
        this.ISSN = article.ISSN;
        this.month = article.month;
        this.year = article.year;
        this.number = article.number;
    }

    /**
     * journal mutator
     * @param journal new journal String
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     * title mutator
     * @param title new title String
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * volume mutator
     * @param volume new volume String
     */
    public void setVolume(String volume) {
        this.volume = volume;
    }

    /**
     * pages mutator
     * @param pages new pages String
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     * keywords mutator
     * @param keywords new keywords String
     */
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    /**
     * doi mutator
     * @param doi new mutator String
     */
    public void setDoi(String doi) {
        this.doi = doi;
    }

    /**
     * issn mutator
     * @param ISSN new issn String
     */
    public void setISSN(String ISSN) {
        this.ISSN = ISSN;
    }

    /**
     * authorString mutator
     * @param authorString new authorString String
     */
    public void setAuthors(String authorString) {
        this.authorString = authorString;
    }

    /**
     * month mutator
     * @param month new month String
     */
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * year mutator
     * @param year new year int
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * number mutator
     * @param number new number int
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @return the whole author String retrieved
     */
    public String getAuthorString() {
        return authorString;
    }

    /**
     *
     * @return number int stored
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @return doi String stored
     */
    public String getDoi() {
        return doi;
    }

    /**
     *
     * @return year int stored
     */
    public int getYear() {
        return year;
    }

    /**
     *
     * @return issn String stored
     */
    public String getISSN() {
        return ISSN;
    }

    /**
     *
     * @return journal String stored
     */
    public String getJournal() {
        return journal;
    }

    /**
     *
     * @return title String stored
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return keywords String stored
     */
    public String getKeywords() {
        return keywords;
    }

    /**
     *
     * @return month String stored
     */
    public String getMonth() {
        return month;
    }

    /**
     *
     * @return volume String stored
     */
    public String getVolume() {
        return volume;
    }

    /**
     *
     * @return pages String stored
     */
    public String getPages() {
        return pages;
    }

    /**
     * Reads the authorString stored and returns an arraylist holding all author names appearing in that String
     * @return A String ArrayList with the individual author Strings
     */
    public ArrayList<String> getAuthorArrayList() {

        ArrayList<String> authors = new ArrayList<String>();
        Scanner authorLineScanner = new Scanner(authorString);
        authorLineScanner.useDelimiter(" and ");

        while(authorLineScanner.hasNext())
            authors.add(authorLineScanner.next());
        return authors;
    }


    /**
     * ToString Method of the Article Class
     * @return String with the Stored Attributes of the Article instance
     */
    public String toString() {
        return "Article{" +
                "authors=" + authorString +
                ", journal='" + journal + '\'' +
                ", title='" + title + '\'' +
                ", volume='" + volume + '\'' +
                ", pages='" + pages + '\'' +
                ", keywords='" + keywords + '\'' +
                ", doi='" + doi + '\'' +
                ", ISSN='" + ISSN + '\'' +
                ", month='" + month + '\'' +
                ", year=" + year +
                ", number=" + number +
                '}';
    }
}
