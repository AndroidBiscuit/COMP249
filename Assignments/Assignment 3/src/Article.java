public class Article {
    private String authors;
    private String journal;
    private String title;
    private String year;
    private String volume;
    private String number;
    private String pages;
    private String doi;
    private String month;

    /**
     * Default Constructor
     */
    public Article(){
        //
    }

    /**
     * Parameterized Constructor
     * @param authors String representing the author of the article
     * @param journal String representing the journal of the article
     * @param title String representing the title of the article
     * @param year int representing the year of the article
     * @param volume String representing the volume of the article
     * @param number int representing the number of the article
     * @param pages String representing the pages of the article
     * @param doi String representing the doi of the article
     * @param month String representing the month of the article
     */
    public Article(String authors, String journal, String title, String year, String volume, String number, String pages, String doi, String month) {
        this.authors = authors;
        this.journal = journal;
        this.title = title;
        this.year = year;
        this.volume = volume;
        this.number = number;
        this.pages = pages;
        this.doi = doi;
        this.month = month;
    }

    /**
     * Generates a list of authors depending on the type of format used for the reference
     * @param format String representing the format of the reference. Can be IEEE, ACM or NJ only. Any other format
     *               will return an error message
     * @return String representing the list made of the names of the author as required by the format of the reference
     */
    public String generateAuthorList(String format){
        String authorList = "";

        switch (format){
            case "IEEE":
                int firstPosition = 0;
                int lastPosition = 0;
                while (this.authors.contains(" and ")){
                    lastPosition = authors.indexOf(" and ");
                    authorList = authors.substring(firstPosition, lastPosition) + ", ";
                    firstPosition = lastPosition + 5;
                }
                authorList += ".";

                firstPosition = 0;
                lastPosition = 0;
                break;

            case "ACM" :
                while (this.authors.contains(" and ")){

                }


                break;

            case "NJ" :
                firstPosition = 0;
                lastPosition = 0;
                while (this.authors.contains(" and ")){
                    lastPosition = authors.indexOf(" and ");
                    authorList = authors.substring(firstPosition, lastPosition) + " & ";
                    firstPosition = lastPosition + 5;
                }
                authorList += ".";
                break;

            default:
                authorList += "Error - Invalid format";
                break;
        }

        return authorList;
    }

    /**
     * Generates a reference int the IEEE format
     * @return String representing the reference of the article in the IEEE format
     */
    public String generateIEEE(){
        return /*generateAuthorList("IEEE") + */" \"" + title + "\", " + journal + ", vol. " + volume + ", no. " +
                number + ", p. " + pages + ", " + month + " " + year + ".";
    }

    /**
     * Generates a reference int the ACM format
     * @return String representing the reference of the article in the ACM format
     */
    public String generateACM(){
        return /*generateAuthorList("ACM") + */" " + year + ". " + title + ". " + journal + ". "+ volume + ", " + number + " (" + year + "), " + pages + ". DOI:https://doi.org/" + doi + ".";
    }

    /**
     * Generates a reference int the NJ format
     * @return String representing the reference of the article in the NJ format
     */
    public String generateNJ(){
        return /*generateAuthorList("NJ") + */" " + title + ". " + journal + ". " + volume + ", " + pages + "(" + year + ").";
    }

    /**
     * Clear all the data from the article
     */
    public void clearArticle(){
        this.authors = "";
        this.journal = "";
        this.title = "";
        this.year = "";
        this.volume = "";
        this.number = "";
        this.pages = "";
        this.doi = "";
        this.month = "";
    }
















    /**
     * Accessor for the author of the article
     * @return String representing the author of the article
     */
    public String getAuthors() {
        return authors;
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
    public String getYear() {
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
    public String getNumber() {
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
        this.authors = authors;
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
    public void setYear(String year) {
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
    public void setNumber(String number) {
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
}
