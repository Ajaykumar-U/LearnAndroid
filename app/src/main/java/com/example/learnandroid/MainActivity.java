package com.example.learnandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h>MainActivity</h>
 * this is class
 */
public class MainActivity extends AppCompatActivity implements ActivityDaysRecyclerAdapterCallBack {

    RecyclerView recyclerView;
    ArrayList<String> activities;
    ActivityDaysRecyclerAdapter recyclerAdapter;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.activitiesRecyclerViewLayout);
        /**
         * <h>setLayoutManager</h>
         * <p>LayoutManager: responsible for measuring and positioning item views within a RecyclerView</p>
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        /**
         * <h>data</h>
         * <p>Initializing the data by array of elements </p>
         */
        activities =new ArrayList<>(Arrays.asList("DAY1","DAY2","DAY3","DAY4","DAY5","DAY6","DAY7","DAY8"));
        /**
         * <h>setAdapter (RecyclertAdapter adapter)</h>
         * <p>Sets the data behind this RecyclerView. The adapter passed to this method may be wrapped by a WrapperListAdapter, depending on the ListView features currently in use.</p>
         * @param Adapter: The ListAdapter which is responsible for maintaining the data backing this list and for producing a view to represent an item in that data set.
         */
        recyclerAdapter = new ActivityDaysRecyclerAdapter(activities,(ActivityDaysRecyclerAdapterCallBack)this);
        recyclerView.setAdapter(recyclerAdapter);
        /**
         * <h>addItemDecoration</h>
         * <p>Here it devides each Item Activity using divider line</p>
         */
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

    }
    /**
     * <h>onClickDays(int position)</h>
     * <p>When clicked on particular position of view holder then new activity will be created</p>
     * @param position: return the position of the Avtivity ViewHolder
     */
    @Override
    public void onClickDays(int position) {
        this.position=position;
        if (position == 1){
            Intent intent =new Intent(MainActivity.this, DayOneActivity.class);
            startActivity(intent);
        }
        else if (position == 2){
            Intent intent =new Intent(MainActivity.this, DayTwoActivity.class);
            startActivity(intent);
        }
        else if (position == 3){
            Intent intent =new Intent(MainActivity.this, DayThreeActivity.class);
            startActivity(intent);
        }
        else if (position == 4){
            Intent intent =new Intent(MainActivity.this, DayFourActivity.class);
            startActivity(intent);
        }
        else if (position == 5){
            Intent intent =new Intent(MainActivity.this, DayFiveActivity.class);
            startActivity(intent);
        }
        else if (position == 6){
            Intent intent =new Intent(MainActivity.this, DaySixActivity.class);
            startActivity(intent);
        }
        else if (position == 7){
            Intent intent =new Intent(MainActivity.this, DaySevenActivity.class);
            startActivity(intent);
        }
        else if (position == 8){
            Intent intent =new Intent(MainActivity.this, DayEightActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this,String.valueOf(position),Toast.LENGTH_LONG).show();
        }
    }
}