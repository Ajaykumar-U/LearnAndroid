package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DayThreeActivity extends AppCompatActivity {

    TextView textViewHeader,textViewDetails;
    ImageView imageView;
    StringBuffer stringBuffer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_three);

        textViewHeader= findViewById(R.id.tvHeaderDayThree);
        textViewDetails = findViewById(R.id.tvQuestionsAnswersDayThree);
        /**
         * <h>Heading</h>
         */
        textViewHeader.setText("Day-3 Activities");
        /**
         * <h>Questions and answers</h>
         */
        textViewDetails.setText(getText(R.string.dayThreeTasks));
        /**
         * <h>Image View</h>
         * <p>When we click on the image it shows the toast</p>
         */
        imageView=findViewById(R.id.imgClickDayThree);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Image Clicked", Toast.LENGTH_LONG).show();
            }
        });
    }
}
