package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {
    EditText name , department, course , id;
    Button update;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        name = findViewById(R.id.name);
        department = findViewById(R.id.department);
        course = findViewById(R.id.course);
        update = findViewById(R.id.update);
        id = findViewById(R.id.id);

        databaseHelper = new DatabaseHelper(this);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name_text = name.getText().toString().trim();
                String department_text = department.getText().toString().trim();
                String course_text = course.getText().toString().trim();
                String id_text = id.getText().toString().trim();

                if (!name_text.isEmpty() && !department_text.isEmpty() && !course_text.isEmpty() && !id_text.isEmpty()){
                    Boolean addup = databaseHelper.updateStudent(name_text, department_text, course_text, id_text);
                    if (addup = true){
                        Toast.makeText(getApplicationContext(), "Student Updated", Toast.LENGTH_SHORT).show();
                        id.setText("");
                        id.setFocusable(true);
                        department.setText("");
                        course.setText("");
                        name.setText("");
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Student Not Updated", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Required", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}