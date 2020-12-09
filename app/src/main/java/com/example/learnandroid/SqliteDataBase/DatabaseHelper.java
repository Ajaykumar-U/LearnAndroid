package com.example.learnandroid.SqliteDataBase;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    /*
     *Creating variables(database name, table name, col1,col2,col3,col4)
     */
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";
    public static final String COL_5 = "PASSION";

    /*
     *Creating constructor
     * When ever the constructor is called database is created
     */
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    /*
     *Oncreate method
     * create table whenever oncreate method is called
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, SURNAME TEXT, MARKS INTEGER)");
    }

    /*
     *onUpgrade method
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     *<p>To add the data in data base</p>
     */
    public boolean insertData(String Name, String Surname, String Marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, Name);
        contentValues.put(COL_3, Surname);
        contentValues.put(COL_4, Marks);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    /**
     * <p>To get the existing data in a Table</p>
     * @return
     */
    public Cursor getAllData() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }

    /**
     * <p>Used to modify the existing data in the table</p>
     * @param Id: gives id of the item data
     * @param Name: gives Name of the item data
     * @param Surname: gives SurName of the item data
     * @param Marks: gives Marks of the item data
     * @return true if data is modified successfully
     */
    public boolean updataData(String Id, String Name, String Surname, String Marks) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, Id);
        contentValues.put(COL_2, Name);
        contentValues.put(COL_3, Surname);
        contentValues.put(COL_4, Marks);
        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{Id});
        return true;
    }

    /**
     * <p>Deleting the data by knowing its position</p>
     * @param Id: gives the id of the data
     * @return true(1) if the data is deleted
     */
    public Integer deleteData(String Id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID=?", new String[]{Id});
    }
}

