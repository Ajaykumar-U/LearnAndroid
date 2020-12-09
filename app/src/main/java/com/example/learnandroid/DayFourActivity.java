package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnandroid.retrofitDay.Retrofit.RetrofitActivity;
import com.squareup.picasso.Picasso;

public class DayFourActivity extends AppCompatActivity {

    TextView textViewHeader,textViewDetails,textViewRetrofit,tvHeader;
    ImageView imageView;
    StringBuffer stringBuffer,stringBuffer1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_day_four);
        textViewHeader= findViewById(R.id.tvHeaderDayFour);
        textViewDetails = findViewById(R.id.tvQuestionsAnswersDayFour1);
        textViewRetrofit = findViewById(R.id.tvQuestionsAnswersDayFour2);


        textViewHeader.setText("Day-4 Activities");
        textViewDetails.setText(getText(R.string.dayFourTasksI));
        /**
         * Loading and Displaying image by using Picasso Library
         */
        imageView=findViewById(R.id.imgActivityDayFour);
        String URL="https://cdn.pixabay.com/photo/2020/06/06/16/40/milk-5267300_960_720.jpg";
        Picasso.get().load(URL).into(imageView);
        /**
         * <p>Setting up of Questions and Answers</p>
         */
        textViewRetrofit.setText(getText(R.string.dayFourTasksII));
        /**
         * <p>Setting up onClick to textViewResult so that when we click this it moves to nest avtivity</p>
         * <p>In new Activity it fetches data from JSONAPI by making network calls</p>
         */
        textViewRetrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DayFourActivity.this, RetrofitActivity.class);
                startActivity(intent);
            }
        });
    }
}
