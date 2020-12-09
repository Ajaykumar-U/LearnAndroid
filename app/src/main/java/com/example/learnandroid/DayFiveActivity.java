package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.learnandroid.AsyncTask.NetworkAsyncTask;
import com.example.learnandroid.IntentPack.SendImageFromActivityOneToTwo;

public class DayFiveActivity extends AppCompatActivity {

    TextView textViewHeader, textViewDetails, textViewDetails1,
            textViewDetails2, textViewDetails3, textViewDetails4, textViewDetails5;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_five);

        textViewHeader = findViewById(R.id.tvHeaderDayFive);
        textViewDetails = findViewById(R.id.day5TvPara1);
        textViewDetails1 = findViewById(R.id.day5TvPara2);
        textViewDetails2 = findViewById(R.id.day5TvPara3);
        textViewDetails3 = findViewById(R.id.day5TvPara4);
        textViewDetails4 = findViewById(R.id.day5TvPara5);
        textViewDetails5 = findViewById(R.id.day5TvPara6);
        editText = findViewById(R.id.etday5);
        textViewHeader.setText("Day-5 Activities");
        String tick = "\u2713";
        textViewDetails.setText("1. Use Async Task instead of Thread to make network calls.");
        /**
         * <p>starting new activity</p>
         */
        textViewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DayFiveActivity.this, NetworkAsyncTask.class);
                startActivity(intent);
            }
        });

        String str2 = "2. Check out your manifest file is there any permission required or you added? What are these permissions for android?\n" + tick + " The purpose of a permission is to protect the privacy of an Android user. Android apps must request permission to access sensitive user data (such as contacts and SMS), as well as certain system features (such as camera and internet)\n";
        textViewDetails1.setText(str2);

        /**
         * <p>Send image and Text to new activity on click of this text</p>
         */
        textViewDetails2.setText("3. Move Text and image to next Activity and show this same Text and image there also.");
        textViewDetails2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DayFiveActivity.this, SendImageFromActivityOneToTwo.class);
                intent.putExtra("resID", R.mipmap.ic_launcher);
                intent.putExtra("resName", "Move Text and image to next Activity and show this same Text and image there also.");
                startActivity(intent);
            }
        });

        textViewDetails3.setText("4. Learn About different type of Intents");
        /**
         * <p>Requesting new Activity to show/get data</p>
         */
        textViewDetails4.setText("a. Implicit Intent");
        textViewDetails4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = editText.getText().toString();
                StringBuffer strBuf = new StringBuffer();
                strBuf.append("https://www." + str + ".com");
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(String.valueOf(strBuf)));
                startActivity(i);
            }
        });
        /**
         * <p>Sending Details from this Activity to new Activity</p>
         */
        textViewDetails5.setText("b. Explicit Intent\n");
        textViewDetails5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DayFiveActivity.this, SendImageFromActivityOneToTwo.class);
                intent.putExtra("resID", R.mipmap.ic_launcher);
                String str = editText.getText().toString();
                intent.putExtra("resName", str);
                startActivity(intent);
            }
        });
    }
}
