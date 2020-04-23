package tech.mstava.quizam;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

public class ScoreActivity extends AppCompatActivity {

    // initialize {@QuizBrain} class to quizBrain object
    QuizBrain quizBrain = new QuizBrain();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        // find {@quiz_name} TextView id from {@activity_score} xml file
        TextView quizName = findViewById(R.id.quiz_name);
        // find {@quiz_score} TextView id from {@activity_score} xml file
        TextView quizScore = findViewById(R.id.quiz_score);
        // find {@done_btn} Button id from {@activity_score} xml file
        Button doneBtn = findViewById(R.id.done_btn);

        // get {@quizTitle} that come from intent in {@QuizActivity}
        String quizNameTxt = Objects.requireNonNull(getIntent().getExtras()).getString("quizTitleTxt");
        // get {@quizScore} that come from intent in {@QuizActivity}
        int score = getIntent().getExtras().getInt("quizScoreValue");

        // set {@quizName} textView to the value of quiz title that come from intent
        quizName.setText(quizNameTxt);
        // set {@quizScore} textView to the value of quiz score that come from intent
        // and get the total number of questions from {@QuizBrain} class
        quizScore.setText(score + "/" + quizBrain.getQuizBrainSize());

        // set on click listener when clicking on {@doneBtn} and go back to {@MainActivity}
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set intent that go from {@this} activity to {@MainActivity} when clicking on done button
                Intent intent  = new Intent(ScoreActivity.this, MainActivity.class);
                // start the {@MainActivity} that comes from {@intent} object
                startActivity(intent);
            }
        });

    }
}
