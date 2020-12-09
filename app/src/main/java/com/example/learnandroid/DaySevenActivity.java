package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learnandroid.SqliteDataBase.SQLActivity1;
import com.example.learnandroid.pushNotification.NotificationView;

public class DaySevenActivity extends AppCompatActivity {

    TextView textViewHeader, textViewQAOne, textViewQATwo, textViewQAThree, textViewQAFour, textViewQAFive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_seven);

        textViewHeader = findViewById(R.id.tvHeaderDaySeven);
        textViewQAOne = findViewById(R.id.tvOneQA);
        textViewQATwo = findViewById(R.id.tvTwoQA);
        textViewQAThree = findViewById(R.id.tvThreeQA);
        textViewQAFour = findViewById(R.id.tvFourQA);
        textViewQAFive = findViewById(R.id.tvFiveQA);

        textViewHeader.setText("Day-7 Activities");
        /**
         * <p>By clicking on this question you enter to new Activity</p>
         * <p>In new Activity DataBase Activity will start</p>
         * <p>where you can Add,Read,Update and Delete the data</p>
         */
        textViewQAOne.setText("1. How store some data in database? Create a database using sqlite and access");
        textViewQAOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DaySevenActivity.this, SQLActivity1.class);
                startActivity(intent);
            }
        });
        /**
         * <p><Creating push notification</p>
         */
        textViewQATwo.setText("2. Create a PushNotification");
        textViewQATwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
            }
        });
        /**
         * <p>Created push Notification using Firebase Cloud Messaging</p>
         */
        textViewQAThree.setText("3. Push Notification in FCM");
        textViewQAThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "FCM Push Notification Created", Toast.LENGTH_LONG).show();
            }
        });
        /**
         * <p>Getting Device id by on click of this text</p>
         */
        textViewQAFour.setText("4. How to find device id");
        textViewQAFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String android_id = Settings.Secure.getString(getContentResolver(),
                        Settings.Secure.ANDROID_ID);
                Toast.makeText(getBaseContext(), "Device Id: " + android_id, Toast.LENGTH_LONG).show();
            }
        });
        /**
         * <p>Need to implement to create registration id for push notification</p>
         */
        textViewQAFive.setText("5. How to create registration id for push notification.");
        textViewQAFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Yet to check", Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * <p>Creating Push Notification</p>
     */
    private void addNotification() {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_launcher_background) //set icon for notification
                .setContentTitle("Ajay") //set title of notification
                .setContentText("Hi this is Ajay!")//this is notification message
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Much longer text that cannot fit one line..."))
                .setAutoCancel(true) // makes auto cancel of notification
                .setPriority(NotificationCompat.PRIORITY_DEFAULT); //set priority of notification


        Intent notificationIntent = new Intent(this, NotificationView.class);
        notificationIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //notification message will get at NotificationView
        notificationIntent.putExtra("message", "This is a notification message");

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}