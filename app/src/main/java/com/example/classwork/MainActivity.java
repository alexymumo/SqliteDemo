package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.Inet4Address;

public class MainActivity extends AppCompatActivity {
    Button save , retrieve, update, delete;
    EditText name, course , department;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //buttons
        save = findViewById(R.id.save);
        retrieve = findViewById(R.id.retrieve);
        update = findViewById(R.id.update);
        delete = findViewById(R.id.delete);

        //edittext
        name = findViewById(R.id.name);
        course = findViewById(R.id.course);
        department = findViewById(R.id.department);

        databaseHelper = new DatabaseHelper(this);



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(name.getText().toString().trim()) && !TextUtils.isEmpty(course.getText().toString().trim()) && !TextUtils.isEmpty(department.getText().toString().trim())){
                    Boolean obj = databaseHelper.addStudent(name.getText().toString().trim(),course.getText().toString().trim(),department.getText().toString().trim());
                    if (obj = true){
                        Toast.makeText(getApplicationContext(), "Saved Student", Toast.LENGTH_SHORT).show();
                        //name.setText("");
                        //department.setText("");
                       // course.setText("");
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Student Not Saved", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    name.setError("Required");
                    department.setError("Required");
                    course.setError("Required");
                    //Toast.makeText(getApplicationContext(), "All Fields are required", Toast.LENGTH_SHORT).show();
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DeleteActivity.class));
            }
        });
        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RetrieveActivity.class));

            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UpdateActivity.class));
            }
        });

    }
}