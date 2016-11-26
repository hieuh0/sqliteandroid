package com.example.hoduchieu.sqlite_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by hoduchieu on 11/25/16.
 */

public class Mydatabase extends SQLiteOpenHelper {
    private static String Database_Name = "demo.sqlite";

    private static String Table_Name = "sinhvien";
    private static String COL_ID = "ID";
    private static String COL_TEN = "TEN";
    private static String COL_EMAIL = "EMAIL";


    public Mydatabase(Context context) {
        super(context, Database_Name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String student = "CREATE TABLE " + Table_Name +" ( "+COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT ,"
                    +COL_TEN+" TEXT , "+
                    COL_EMAIL +" TEXT "+")";
            sqLiteDatabase.execSQL(student);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + Table_Name);
    }

    public void InsertStudent(String Ten,String Email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TEN,Ten);
        contentValues.put(COL_EMAIL,Email);

       db.insert(Table_Name,null,contentValues);
        db.close();
    }


    public ArrayList<SinhVien> getAllStudent(){
        ArrayList<SinhVien> list = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM "+Table_Name,null);
        if(c.moveToFirst()){
            do {
                int id = c.getInt(0);
                String ten = c.getString(1);
                String email = c.getString(2);
                list.add(new SinhVien(id,ten,email));
            }while (c.moveToNext());
        }
        db.close();
        return list;
    }

    public void DeleteStudent(int ID){
        SQLiteDatabase db = this.getWritableDatabase();
        long i = db.delete(Table_Name,COL_ID + "=?",new String[]{ID+""});
        db.close();
        Log.d("Da Xoa",i+"");
    }

    public void UpdateData(int ID,String Ten,String Email){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_TEN,Ten);
        values.put(COL_EMAIL,Email);
        long i = db.update(Table_Name,values,COL_ID + "=?",new String[] {ID +""});
        Log.d("Update",i+"");

    }

}

