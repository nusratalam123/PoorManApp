package com.example.donationcollectingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper1 extends SQLiteOpenHelper {
    public static final String DBNAME = "people_database.db";
    public DBHelper1(@Nullable Context context) {
        super(context, DBNAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table people_info(name TEXT ,mobile TEXT primary key,national_id TEXT,bkash_num TEXT,distric_name TEXT,subdistric_name TEXT, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists people_info");

    }
    public Boolean insertData1(String name, String mobile,String national_id,String bkash_num,String distric_name,String subdistric_name,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("mobile", mobile);
        contentValues.put("national_id", national_id);
        contentValues.put("bkash_num", bkash_num);
        contentValues.put("distric_name", distric_name);
        contentValues.put("subdistric_name",subdistric_name);
        contentValues.put("password", password);
        long result = MyDB.insert("people_info", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Boolean checkmobile(String mobile) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from people_info where mobile = ?", new String[]{mobile});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkMobileandPass(String name,String mobile, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from people_info where name=? and mobile = ? and password = ?", new String[] {name,mobile,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select *from people_info",null);
        return  cursor;
    }

}
