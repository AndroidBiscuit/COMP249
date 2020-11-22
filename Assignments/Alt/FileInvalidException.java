package Assignment3;

//-----------------------------------------------------
//Assignment 3
//Question: Part 1/1
//Written by: Jacques-Andre Roebuck 40128691, Joseph Saliba 40183705
//-----------------------------------------------------

public class FileInvalidException extends Exception{



    /**
     * Parametrized FileInvalidException constructor which passes the message to the Exception class
     * @param m String
     */
    public FileInvalidException(String m){
        super(m);
    }

    /**
     * Default Constructor which sends a message to the Exception cllass
     */
    public FileInvalidException() {
        super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
    }

    /**
     * Parametrized constructor that passes a message informing the user about the Empty field detected
     * @param emptyArgument the empty field detected
     * @param articleNum the number of the article inside the file
     * @param lineNum the line number inside the file
     */
    public FileInvalidException(String emptyArgument, int articleNum, int lineNum) {
        super("Empty Field detected ->" + emptyArgument + "<- at Line " + lineNum + " in Article Number " + articleNum + ". There could be more Empty Fields inside the file");
    }
}
