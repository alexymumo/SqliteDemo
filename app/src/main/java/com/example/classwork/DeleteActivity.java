package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {
    EditText id;
    Button delete;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        id = findViewById(R.id.id);
        delete = findViewById(R.id.delete);
        databaseHelper = new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int results = databaseHelper.deleteStudent(id.getText().toString().trim());
                Toast.makeText(getApplicationContext(),+ results+ "Deleted", Toast.LENGTH_SHORT).show();
            }
        });
    }
}