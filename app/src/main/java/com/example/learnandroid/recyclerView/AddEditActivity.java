package com.example.learnandroid.recyclerView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.learnandroid.R;

public class AddEditActivity extends AppCompatActivity {

    EditText etEnterId, etEnterName, etEnterJob;
    Button btnSaveData;
    boolean isEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        etEnterId=findViewById(R.id.etEnterId);
        etEnterName=findViewById(R.id.etEnterName);
        etEnterJob= findViewById(R.id.etEnterJob);
        btnSaveData=findViewById(R.id.btnSave);
        getDataFromPreviewActivity();
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("value1", etEnterId.getText().toString());
                intent.putExtra("value2", etEnterName.getText().toString());
                intent.putExtra("value3", etEnterJob.getText().toString());
                intent.putExtra("isEdit",isEdit);
                setResult(2, intent);
                finish();
            }
        });
    }

    private void getDataFromPreviewActivity() {
        String id,name,job;
        id=String.valueOf(getIntent().getIntExtra("id",0));
        name=getIntent().getStringExtra("name");
        job=getIntent().getStringExtra("job");

        isEdit=getIntent().getBooleanExtra("isEdit",false);
        if(isEdit){
            etEnterId.setText(id);
            etEnterName.setText(name);
            etEnterJob.setText(job);
            btnSaveData.setText("Save");
        }
    }
}
