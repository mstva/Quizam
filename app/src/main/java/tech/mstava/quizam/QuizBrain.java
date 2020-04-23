package tech.mstava.quizam;

import java.util.Arrays;
import java.util.List;

public class QuizBrain {

    // create a variable to store question number index from {@mQuestionBank List}
    private int mQuestionNumber;

    // create and initialize {@mQuestionBank List} with {@Question Constructor}
    List<Question> mQuestionBank = Arrays.asList(
        new Question("The loudest sound produced by any animal is 188 decibels. That animal is the African Elephant.", false),
        new Question("You can lead a cow down stairs but not up stairs.", false),
        new Question("No piece of square dry paper can be folded in half more than 7 times.", false),
        new Question("Some cats are actually allergic to humans", true),
        new Question("Approximately one quarter of human bones are in the feet.", true),
        new Question("A slug\'s blood is green.", true),
        new Question("Buzz Aldrin\'s mother\'s maiden name was \"Moon\".", true),
        new Question("It is illegal to pee in the Ocean in Portugal.", true),
        new Question("In London, UK, if you happen to die in the House of Parliament, you are technically entitled to a state funeral, because the building is considered too sacred a place.", true),
        new Question("The total surface area of two human lungs is approximately 70 square metres.", true),
        new Question("Google was originally called \"Backrub\".", true),
        new Question("Chocolate affects a dog\'s heart and nervous system; a few ounces are enough to kill a small dog.", true),
        new Question("In West Virginia, USA, if you accidentally hit an animal with your car, you are free to take it home to eat.", true)
    );

    void nextQuestion() {
        /*
        * This function perform the task that go from current question to next question
        * So, if {@QuestionNumber} less than {@QuestionBank Size} it will increase
        * {@QuestionNumber} by (1), and subtract (1) from {@QuestionBank Size} because
        * the {@QuestionBank List} index start from 0 to 12
        */
        if (mQuestionNumber < mQuestionBank.size()-1) {
            // Compare {@QuestionNumber} to {@QuestionBank Size}
            // If condition is true, then increase {@QuestionNumber} by (1)
            mQuestionNumber++;
        }
    }

    String getQuestionText() {
        /*
         * This function return the {@Question} text based on the {@QuestionNumber} index
         */
        return mQuestionBank.get(mQuestionNumber).mQuestion;
    }

    String getQuestionNumber() {
        /*
        * This function return {@QuestionNumber} and convert it to {String}
        * And add 1 because {@QuestionNumber} start with 0
        */
        return Integer.toString(mQuestionNumber + 1);
    }

    String getQuizBrainSize() {
        /*
        * This function returns the total number of {@QuestionBank List} questions
        * And convert it to {String}
        */
        return Integer.toString(mQuestionBank.size());
    }

    boolean getAnswer() {
        /*
        * This function returns the {@Answer} based on the {@QuestionNumber} index
        */
        return mQuestionBank.get(mQuestionNumber).mAnswer;
    }

    boolean isFinished() {
        /*
        * This function check if the {@QuestionBank} is finished or not, based on
        * the {@QuestionNumber} and {@QuestionBank Size} where it compares them together
        * and if {@QuestionNumber} greater than or equal {@QuestionBank Size} it return true
        * otherwise it return false
        */
        if (mQuestionNumber >= mQuestionBank.size()-1) { return true; }
        else { return false; }
    }

    void reset() {
        /*
        * This function reset the {@QuestionNumber} back to 0
        */
        mQuestionNumber = 0;
    }
}
