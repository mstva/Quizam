package tech.mstava.quizam;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuizViewAdapter extends RecyclerView.Adapter<QuizViewAdapter.MyViewHolder> {

    // create variables to store the class data members
    private Context mContext;
    private List<QuizCard> mQuizCardData;

    // create and initialize the class constructor
    public QuizViewAdapter(Context context, List<QuizCard> quizCardData) {
        this.mContext = context;
        this.mQuizCardData = quizCardData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /**
        * This function is used to set the layout view
         * to the {@quiz_cardview_item} xml file
        */

        // create a variable to store the view
        View view;
        // inflate the layout based on this context
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        // initialize the view  based the inflater and {@quiz_cardview_item}
        view = mInflater.inflate(R.layout.quiz_cardview_item, parent, false);
        // return the function with the view
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        // set the {@quizTitle} TextView to the title that come from {@getQuizTitle} in {@QuizCard Class}
        holder.quizTitle.setText(mQuizCardData.get(position).getQuizTitle());
        // set the {@quizIcon} ImageView to the icon that come from {@getQuizIconID} in {@QuizCard Class}
        holder.quizIcon.setImageResource(mQuizCardData.get(position).getQuizIconID());
        // set the color of {@quizIcon} to black
        holder.quizIcon.setColorFilter(Color.BLACK);

        // set on click listener when clicking on {@quizCard}
        holder.quizCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set an intent that goes from {@this} context to {@QuizActivity}
                Intent intent = new Intent(mContext, QuizActivity.class);
                // send the {@quizTitle} to {@QuizActivity}
                intent.putExtra("quizTitle", mQuizCardData.get(position).getQuizTitle());
                // start the {@QuizActivity} that comes from the {@intent} object
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mQuizCardData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView quizTitle;
        private ImageView quizIcon;
        private CardView quizCard;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            // find {@quizTitle} TextView id from the {@activity_main} xml file
            quizTitle = itemView.findViewById(R.id.quiz_title);
            // find {@quizIcon} ImageView id from the {@activity_main} xml file
            quizIcon = itemView.findViewById(R.id.quiz_icon);
            // find {@quizCard} CardView id from the {@activity_main} xml file
            quizCard = itemView.findViewById(R.id.quiz_card);

        }
    }
}
