import java.io.FileNotFoundException;

public class FileInvalidException extends FileNotFoundException {
    /**
     * Parameterized constructor that passes the message to the Exception class
     * @param message String
     */
    public FileInvalidException(String message){
        super(message);
    }

    /**
     * Default Constructor (with a default message)
     */
    public FileInvalidException() {
        super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
    }

    /**
     * Parametrized constructor that passes a message than an empty field has been detected
     * @param emptyArgument the empty field detected
     * @param articleNumber the number of the article inside the file
     * @param lineNumber the line number inside the file
     */
    public FileInvalidException(String emptyArgument, int articleNumber, int lineNumber) {
        super("Empty Field detected ->" + emptyArgument + "<- at Line " + lineNumber + " in Article Number " +
                articleNumber + ". There could be more Empty Fields inside the file");
    }
}
