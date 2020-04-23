package tech.mstava.quizam;

public class QuizCard {

    // create a variables to store {@QuizCard} data members
    private String mQuizTitle;
    private int mQuizIconID;

    // create and initialize {@QuizCard} constructor
    public QuizCard(String quizTitle, int quizIconID) {
        this.mQuizTitle = quizTitle;
        this.mQuizIconID = quizIconID;
    }

    public String getQuizTitle() {
        return mQuizTitle;
    }

    public int getQuizIconID() {
        return mQuizIconID;
    }
}
