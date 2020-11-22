/**
 * The class "Student" calculates the overall score and letter grade of a student.
 * Made for questions 4, 5 and 6 for Tutorial 1 in COMP 249
 * @author Faizan Ahmad (40100581)
 * @version 1
 */

public class Student {
    private int[] score = new int[3];
    private int midtermScore, finalScore;
    private double overallScore;
    private char letterGrade;

    /**
     * Returns the score
     * @return an array of int representing the scores of the three quizzes
     */
    public int[] getScore(){
        return this.score;
    }

    /**
     * Returns the midterm score
     * @return an int representing the midterm score
     */
    public int getMidtermScore(){
        return this.midtermScore;
    }

    /**
     * Returns the final score
     * @return an int representing the final score
     */
    public int getFinalScore(){
        return this.finalScore;
    }

    /**
     * Returns the overall score
     * @return a double representing the overall score
     */
    public double getOverallScore(){
        return this.overallScore;
    }

    /**
     * Returns the letter grade
     * @return an char representing the letter grade
     */
    public char getGrade(){
        return this.letterGrade;
    }

    /**
     * Takes an array of int and checks if it has ONLY 3 integers in it. If not, it throws an error.
     * Saves the grades in the private array if the given score is between 0 and 20, otherwise it throws an error.
     * @param score an array of int
     */
    public void setScore(int[] score){
        if (score.length == 3){
            for (int i = 0; i < 3; i++){
                if (score[i] >= 0 && score[i] <=20) {
                    this.score[i] = score[i];
                }
                else {
                    throw new IllegalArgumentException("Error, the score must be between 0 ad 20");
                }
            }
        }
        else {
            throw new IllegalArgumentException("Error, there should be exactly 3 quiz scores");
        }
    }

    /**
     * Saves the grades in the private value if the given score is between 0 and 50, otherwise it throws an error.
     * @param midtermScore an int value
     */
    public void setMidtermScore(int midtermScore){
        if (midtermScore >= 0 && midtermScore <= 50) {
            this.midtermScore = midtermScore;
        }
        else {
            throw new IllegalArgumentException("Error, the score must be between 0 ad 50");
        }
    }

    // Sets the final score and checks if its between 0 and 100
    /**
     * Saves the grades in the private value if the given score is between 0 and 100, otherwise it throws an error.
     * @param finalScore an int value
     */
    public void setFinalScore(int finalScore){
        if (finalScore >= 0 && finalScore <= 50) {
            this.finalScore = finalScore;
        }
        else {
            throw new IllegalArgumentException("Error, the score must be between 0 ad 100");
        }
    }

    /**
     * Saves the grades in the private value
     * @param overallScore a double value
     */
    public void setOverallScore(double overallScore){
        this.overallScore = overallScore;
    }

    /**
     * Saves the grades in the private value
     * @param grade a char value
     */
    public void setGrade(char grade){
        this.letterGrade = grade;
    }

    /**
     * Calculates the overall score of the student by using the private values for the quiz, midterm and final.
     * Does not return anything.
     */
    public void calculateOverallScore(){
        // Calculate the quiz grades
        double quizGrade = 0;
        for (int i = 0; i < 3; i++){
            quizGrade += (this.score[i]/100.0) * 15.0;
        }

        // Calculate the overtall score
        this.overallScore = quizGrade + ((this.midtermScore/100.0) * 35.0) + ((this.finalScore/100.0) * 50.0);
    }

    /**
     * Calculates the letter grade of the student by using the private value of the overall score.
     * Does not return anything.
     */
    public void finalLetterGrade(){
        if (this.overallScore <= 100 && this.overallScore >= 90){
            this.letterGrade = 'A';
        }
        else if (this.overallScore < 90 && this.overallScore >= 80){
            this.letterGrade = 'B';
        }
        else if (this.overallScore < 80 && this.overallScore >= 70){
            this.letterGrade = 'C';
        }
        else if (this.overallScore < 70 && this.overallScore >= 60){
            this.letterGrade = 'D';
        }
        else if (this.overallScore < 60){
            this.letterGrade = 'F';
        }
    }
}
