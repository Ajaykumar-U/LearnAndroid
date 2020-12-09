package com.example.learnandroid.IntentPack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.learnandroid.R;

public class SendImageFromActivityOneToTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_image);

        TextView textView=findViewById(R.id.tvSendData);
        ImageView img2=(ImageView)findViewById(R.id.imgSend);

        String str=getIntent().getStringExtra("resName");
        textView.setText(str);


        Bundle b=getIntent().getExtras();
        if(b!=null){
            int resid = b.getInt("resID");
            img2.setImageResource(resid);
        }
    }
}
