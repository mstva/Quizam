package tech.mstava.quizam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class QuizActivity extends AppCompatActivity {

    // initialize {@QuizBrain Class} to {@quizBrain} object
    QuizBrain quizBrain = new QuizBrain();
    // create a variable to store the quiz score value
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // find {@answer_correct} button id from the {@activity_quiz} xml file
        Button correctAnswer = findViewById(R.id.answer_correct);
        // find {@answer_wrong} button id from the {@activity_quiz} xml file
        Button wrongAnswer = findViewById(R.id.answer_wrong);

        // show the first question by calling {@showQuestion Function}
        showQuestion();

        // set on click listener when clicking on {correctAnswer Button}
        correctAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the user picked the correct answer, so send {true} to {@checkAnswer Function}
                checkAnswer(true);
            }
        });

        // set on click listener when clicking on {wrongAnswer Button}
        wrongAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the user picked the wrong answer, so send {false} to {@checkAnswer Function}
                checkAnswer(false);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void checkAnswer(boolean userPickAnswer) {
        /**
        * This function is used to check user answer based
         * on the type of Button that was clicked
        */

        // get the answer for the current and correct question from the {@QuizBrain Class}
        boolean correctAnswer = quizBrain.getAnswer();

        // create an array to store the images of the answers
        ArrayList<Integer> scoreKeeperImg = new ArrayList<Integer>();

        // find the {@scoreKeeperImgView} LinearLayout id that used to show the answer on the screen
        LinearLayout scoreKeeperImgView = findViewById(R.id.scoreKeeperImgView);

        // call {@isFinished Function} from {@QuizBrain Class} first
        // to check if the questions is finished or not
        if (quizBrain.isFinished()) {
            // call the {@startScoreActivity} to show the finished quiz score
            startScoreActivity();
            // call the {@reset Function} from {@QuizBrain Class} to reset the questions
            quizBrain.reset();
            // clear the {@scoreKeeperImg List} from the value that was added to it
            scoreKeeperImg.clear();
            // remove all views from the LinearLayout that stored in {@scoreKeeperImgView}
            scoreKeeperImgView.removeAllViews();
            // reset the {@score} value back to zero
            score = 0;

        } else {
            if (userPickAnswer == correctAnswer) {
                // if the user picked the correct answer, go and increase {@score} by 1
                score++;
                // and add the {@ic_done Icon} to {@scoreKeeperImg List}
                scoreKeeperImg.add(R.drawable.ic_done);

            } else {
                // don't increase {@score} and add {@ic_close Icon} to {@scoreKeeperImg List}
                scoreKeeperImg.add(R.drawable.ic_close);
            }

            // get the next question by calling {@nextQuestion Function} from {@QuizBrain Class}
            quizBrain.nextQuestion();
        }

        // show the next question by calling {@showQuestion Function}
        showQuestion();

        // show the answer to the question by calling {@showAnswer Function}
        showAnswer(scoreKeeperImg, scoreKeeperImgView);
    }

    private void startScoreActivity() {
        /**
        * This function is used to start the {@ScoreActivity} after finishing
         * the quiz and sending the {@quizTitle} and {@score} value
        */

        // get {@quizTitle} that come from intent in {@QuizViewAdapter}
        String quizTitle = Objects.requireNonNull(getIntent().getExtras()).getString("quizTitle");
        // set intent that go from {@this} activity to {@ScoreActivity}
        Intent intent  = new Intent(QuizActivity.this, ScoreActivity.class);

        // send the {@quizTitle} value to {@ScoreActivity}
        intent.putExtra("quizTitleTxt", quizTitle);
        // send the {@score} value to {@ScoreActivity}
        intent.putExtra("quizScoreValue", score);

        // start the {@ScoreActivity} that comes from the {@intent} object
        startActivity(intent);
    }

    private void showQuestion() {
        /**
        * This Function is used to show the question on the screen
        */

        // find {@question} TextView id from {@activity_quiz} xml file
        TextView question = findViewById(R.id.question);
        // get question from {@getQuestionText Function} from {@QuizBrain Class}
        String questionTxt = quizBrain.getQuestionText();
        // set the {@question} TextView to {@questionTxt}
        question.setText(questionTxt);

        // find {@question_number} TextView id from {@activity_quiz} xml file
        TextView questionNumber = findViewById(R.id.question_number);
        // get question number from {@getQuestionNumber Function} and get question bank total size
        // from {@getQuizBrainSize() Function} that come from {@QuizBrain Class}
        String questionNumberTxt = quizBrain.getQuestionNumber() + "/" + quizBrain.getQuizBrainSize();
        // set the {@questionNumber} TextView to {@questionNumberTxt}
        questionNumber.setText(questionNumberTxt);
    }

    private void showAnswer(ArrayList<Integer> scoreKeeperImg, LinearLayout scoreKeeperImgView) {
        /**
        * This function is used to show the answer of the question,
        * if it correct show the {@ic_done Icon}, if it wrong show the {@ic_close Icon}
        */

        // use this loop to show the icon answer based on the index of {@scoreKeeperImg List}
        for (int index=0; index < scoreKeeperImg.size(); index++) {
            // initialize an object from the {@ImageView} based on the {@this} context
            ImageView imageAnswerView = new ImageView(this);
            // set this {@imageAnswerView} object to the image resource that come from {@scoreKeeperImg List}
            imageAnswerView.setImageResource(scoreKeeperImg.get(index));
            // show the icons on the screen that added to {@scoreKeeperImgView LinearLayout} based on {@imageAnswerView}
            scoreKeeperImgView.addView(imageAnswerView);
        }
    }
}
