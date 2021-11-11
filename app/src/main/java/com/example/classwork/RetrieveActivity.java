package com.example.classwork;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RetrieveActivity extends AppCompatActivity {
    TextView textView;
    Button retrieve;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrieve);

        textView = findViewById(R.id.textView);
        retrieve = findViewById(R.id.retrieve);
        databaseHelper = new DatabaseHelper(this);

        retrieve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor data = databaseHelper.readData();
                StringBuffer stringBuffer = new StringBuffer();
                if (data == null && data.getCount()>0){
                    while (data.moveToNext()){
                        stringBuffer.append("ID:\t" + data.getString(0)+"\n");
                        stringBuffer.append("NAME:\t" + data.getString(1)+"\n");
                        stringBuffer.append("COURSE:\t" + data.getString(2)+"\n");
                        stringBuffer.append("DEPARTMENT:\t" +data.getString(3)+"\n");
                    }
                    textView.setText(stringBuffer.toString());
                    Toast.makeText(getApplicationContext(), "Data Retrieved", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}