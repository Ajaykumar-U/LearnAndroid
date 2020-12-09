package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DayTwoActivity extends AppCompatActivity {

    TextView textViewHeader,textViewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_two);

        textViewHeader= findViewById(R.id.tvHeaderDayTwo);
        textViewDetails = findViewById(R.id.tvQuestionsAnswersDayTwo);
        /**
         * <h>Heading of Activity Two</h>
         */
        textViewHeader.setText("Day-2 Activities");
        /**
         * <h>Questions and Answers of Activity Two</h>
         */
        textViewDetails.setText(getText(R.string.dayTwoTasks));
    }
}
