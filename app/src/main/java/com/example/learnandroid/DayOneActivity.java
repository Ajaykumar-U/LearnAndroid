package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DayOneActivity extends AppCompatActivity {

    TextView textViewHeader,textViewDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_one);

        textViewHeader= findViewById(R.id.tvHeader);
        textViewDetails = findViewById(R.id.tvQuestionsAnswersDayOne);
        /**
         * <h>Heading of Activity One</h>
         */
        textViewHeader.setText("Day-1 Activities");
        /**
         * <h>Questions and Answers of Activity One</h>
         */
        textViewDetails.setText(getString(R.string.dayOneTasks));
    }
}
