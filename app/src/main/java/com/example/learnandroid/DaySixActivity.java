package com.example.learnandroid;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.learnandroid.recyclerView.AdapterCallback;
import com.example.learnandroid.recyclerView.AddEditActivity;
import com.example.learnandroid.recyclerView.Employee;
import com.example.learnandroid.recyclerView.EmployeeAdapter;
import com.example.learnandroid.recyclerView.EmployeeList;

import java.util.ArrayList;

public class DaySixActivity extends AppCompatActivity implements AdapterCallback {

    TextView textViewHeader,textViewDetails;
    RecyclerView recyclerView;
    Button AddEmpData;
    int position;
    Button EditEmpData;


    EmployeeList employeeList = new EmployeeList();
    ArrayList<Employee> data;
    EmployeeAdapter employeeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_six);

        textViewHeader= findViewById(R.id.tvHeaderDaySix);
        textViewDetails = findViewById(R.id.day6TvPara);
        textViewHeader.setText("Day-6 Activities");

//        A LayoutManager is responsible for measuring and positioning item views within a RecyclerView as well as determining the policy for when to recycle item views that are no longer visible to the user. By changing the LayoutManager a RecyclerView can be used to implement a standard vertically scrolling list, a uniform grid, staggered grids, horizontally scrolling collections and more. Several stock layout managers are provided for general use.
        textViewDetails.setText(getText(R.string.daySixTask));

        recyclerView = findViewById(R.id.recycler_view);
        /*
         *<h>Set Layout Manager</h>
         * <p> This is for setting layout Manager</p>
         */
        recyclerView.setLayoutManager(new LinearLayoutManager(DaySixActivity.this));
        /*
         *<h>Set Adapter</h>
         * <p> This is for setting Adapter</p>
         */
        data = employeeList.getData();
        employeeAdapter = new EmployeeAdapter(data, (AdapterCallback) this);
        recyclerView.setAdapter(employeeAdapter);
        /*
         *<h>Set Decorator</h>
         * <p> This provides line after each item</p>
         */
        recyclerView.addItemDecoration(new DividerItemDecoration(DaySixActivity.this, DividerItemDecoration.VERTICAL));

        AddEmpData = findViewById(R.id.AddData);
        /**
         * <p>Getting into new activity and getting result from new created activity</p>
         */
        AddEmpData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addIntent = new Intent(DaySixActivity.this, AddEditActivity.class);
                startActivityForResult(addIntent, 1);
            }
        });

    }

    /**
     *
     * @param requestCode: Result code is defined from startActivityForResult()
     * @param resultCode: Result code is defined on the new activity to get the result
     * @param data: result data from new activity
     */
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 2 && requestCode == 1) {
            if (!data.getBooleanExtra("isEdit", false)) {
                this.data.add(new Employee(Integer.parseInt(data.getStringExtra("value1")),
                        data.getStringExtra("value2"),
                        data.getStringExtra("value3")));
            } else {
                this.data.get(position).setId(Integer.parseInt(data.getStringExtra("value1")));
                this.data.get(position).setName(data.getStringExtra("value2"));
                this.data.get(position).setJob(data.getStringExtra("value3"));

            }
            employeeAdapter.notifyDataSetChanged();
        }
    }

    /**
     * <p>Used to delete the employee data by knowing its position</p>
     * @param position
     */
    @Override
    public void onDeleteEmp(int position) {
        this.position=position;
        data.remove(position);
        employeeAdapter.notifyDataSetChanged();
    }

    /**
     * <p>Used to Edit the existing employee details by sending the existing data to new activity and modifing the details and edit the details in employee data</p>
     * @param position
     */
    @Override
    public void onEditEmp(int position) {
        this.position=position;
        Intent intent = new Intent(DaySixActivity.this, AddEditActivity.class);
        intent.putExtra("id", data.get(position).getId());
        intent.putExtra("name", data.get(position).getName());
        intent.putExtra("job", data.get(position).getJob());
        intent.putExtra("isEdit", true);
        startActivityForResult(intent, 1);
    }
}