package com.example.classwork;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final int DATABASEVERSION = 1;
    public static final String DATABASENAME = "students";
    public static final String TABLE_STUDENTS = "table_students";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DEPARTMENT = "department";
    public static final String COURSE = "course";
    public DatabaseHelper(Context context){
        super(context, DATABASENAME, null, DATABASEVERSION);

    }
    //creating tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_STUDENTS  = "CREATE TABLE " + TABLE_STUDENTS + "("
                + ID + " INTEGER PRIMARY KEY," + NAME + "TEXT,"
                + DEPARTMENT + "TEXT," + COURSE + "TEXT" + ")";
        db.execSQL(CREATE_TABLE_STUDENTS);
    }

    //upgrading tables
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS);
        //create tables again
        onCreate(db);
    }

    //add new student
    public boolean addStudent(String name, String department, String course){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(NAME , name);
        values.put(DEPARTMENT, department);
        values.put(COURSE, course);

        //insert rows
        db.insert(TABLE_STUDENTS, null, values);
        db.close();
        return true;
    }
    public Integer deleteStudent(String id){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_STUDENTS , "id=?", new String[]{id});
    }

    public boolean updateStudent(String id, String name, String department, String course){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(NAME , name);
        contentValues.put(COURSE, course);
        contentValues.put(DEPARTMENT, department);

        int results = db.update(TABLE_STUDENTS, contentValues, "id=?",new String[]{id});
        db.close();

        //checks if the results are updated
        return results > 0;
    }

    public Cursor readData(){
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + TABLE_STUDENTS, null);
        return  cursor;
    }
}
