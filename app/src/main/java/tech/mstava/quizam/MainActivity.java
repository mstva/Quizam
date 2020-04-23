package tech.mstava.quizam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // create a list to store the quiz card data in it
    List<QuizCard> quizCardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initialize the {@quizCardList} with array list of {@QuizCard Constructor}
        quizCardList = new ArrayList<>(Arrays.asList(
                new QuizCard("Geography", R.drawable.quiz_geography),
                new QuizCard("Energy", R.drawable.quiz_energy),
                new QuizCard("Space", R.drawable.quiz_space),
                new QuizCard("Physics", R.drawable.quiz_physics),
                new QuizCard("Maths", R.drawable.quiz_maths),
                new QuizCard("Biology", R.drawable.quiz_biology),
                new QuizCard("Chemistry", R.drawable.quiz_chemistry),
                new QuizCard("Movies", R.drawable.quiz_movies),
                new QuizCard("Economy", R.drawable.quiz_economy)
        ));

        // find the {@recyclerView_root} RecyclerView id from {@activity_main} xml file
        RecyclerView recyclerView = findViewById(R.id.recyclerView_root);
        // initialize an object from the {QuizViewAdapter Class} based on {@this} context
        QuizViewAdapter quizViewAdapter = new QuizViewAdapter(this, quizCardList);
        // use the grid layout manager to set the number of columns to 3
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        // set the adapter of the {@recyclerView} to {@quizViewAdapter} object
        recyclerView.setAdapter(quizViewAdapter);
    }
}
