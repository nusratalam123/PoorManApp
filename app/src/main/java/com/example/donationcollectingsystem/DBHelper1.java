package com.example.donationcollectingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper1 extends SQLiteOpenHelper {
    public static final String DBNAME = "people_login.db";
    public DBHelper1(@Nullable Context context) {
        super(context, DBNAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table people_table(name TEXT ,mobile TEXT primary key,national_id TEXT,bkash_num TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists people_table");

    }
    public Boolean insertData1(String name, String mobile,String national_id,String bkash_num,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mobile", mobile);
        contentValues.put("national_id", national_id);
        contentValues.put("bkash_num", bkash_num);
        contentValues.put("password", password);
        long result = MyDB.insert("people_table", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkmobile(String mobile) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from people_table where mobile = ?", new String[]{mobile});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkMobileandPass(String mobile, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from people_table where mobile = ? and password = ?", new String[] {mobile,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

}
