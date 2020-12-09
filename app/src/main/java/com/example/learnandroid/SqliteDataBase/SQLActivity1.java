package com.example.learnandroid.SqliteDataBase;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.learnandroid.R;

public class SQLActivity1 extends AppCompatActivity {

    DatabaseHelper db;
    EditText etName, etSurname, etMarks,etId;
    Button btnAddData, btnShowData,btnUpdateData,btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_q_l);

        db=new DatabaseHelper(this);
        etId=findViewById(R.id.etId);
        etName=findViewById(R.id.etName);
        etSurname=findViewById(R.id.etSurname);
        etMarks=findViewById(R.id.etMarks);
        btnAddData=findViewById(R.id.btnAddDataToDB);
        btnShowData=findViewById(R.id.btnShowDataFromDB);
        btnUpdateData=findViewById(R.id.btnUpdateDataInDB);
        btnDeleteData=findViewById(R.id.btnDeleteDataInDB);

        //Add new Data
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted =  db.insertData(etName.getText().toString(),etSurname.getText().toString(),etMarks.getText().toString());
                if(isInserted==true)
                    Toast.makeText(SQLActivity1.this, "Data Inserted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(SQLActivity1.this, "Data Not Inserted", Toast.LENGTH_LONG).show();
            }
        });

        //Show Data
        btnShowData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res=db.getAllData();
                if(res.getCount()==0){
                    showMessage("Error","Nothing Found");
                }
                StringBuffer stringBuffer=new StringBuffer();
                while(res.moveToNext()){
                    stringBuffer.append("ID "+res.getString(0)+"\n");
                    stringBuffer.append("Name "+res.getString(1)+"\n");
                    stringBuffer.append("Surname "+res.getString(2)+"\n");
                    stringBuffer.append("Marks "+res.getString(3)+"\n\n");
                }
                showMessage("Data",stringBuffer.toString());
            }
        });

        //Update Data
        btnUpdateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = db.updataData(etId.getText().toString(),etName.getText().toString(),etSurname.getText().toString(),etMarks.getText().toString());
                if(isUpdate==true) {
                    Toast.makeText(SQLActivity1.this, "Data Updated", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(SQLActivity1.this, "Data Not Updated", Toast.LENGTH_LONG).show();
                }
            }
        });

        //Delete Data
        btnDeleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int isDelete = db.deleteData(etId.getText().toString());
                if(isDelete > 0) {
                    Toast.makeText(SQLActivity1.this, "Data Deleted", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(SQLActivity1.this, "Data Not Deleted", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    //show data
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
