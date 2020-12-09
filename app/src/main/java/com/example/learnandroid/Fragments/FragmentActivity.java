package com.example.learnandroid.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid.R;

public class FragmentActivity extends AppCompatActivity {

    Button clickFragmentOne,clickFragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        clickFragmentOne = findViewById(R.id.btnFragmentOne);
        clickFragmentTwo = findViewById(R.id.btnFragmentTwo);

        clickFragmentOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new FragmentOne());
            }
        });

        clickFragmentTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadFragment(new FragmentTwo());
            }
        });
    }

    /**
     * <p>Set up for starting the fragment</p>
     * @param fragment
     */
    public void LoadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentLayout,fragment);
        fragmentTransaction.commit();
    }
}
