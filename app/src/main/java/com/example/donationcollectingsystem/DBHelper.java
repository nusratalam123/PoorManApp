package com.example.donationcollectingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "donar_database.db";

    public DBHelper(@Nullable Context context) {
        super(context, DBNAME, null, 4);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table donar_table(name TEXT ,email TEXT primary key,mobile TEXT, password TEXT)");
      //  MyDB.execSQL("create Table DonarsenderInfo(name TEXT ,email TEXT primary key,mobile TEXT,bank TEXT,ammount TEXT, date TEXT,district TEXT,thana TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists donar_table");
       // MyDB.execSQL("drop Table if exists DonarsenderInfo");

    }
    public Boolean insertData(String name, String email,String number,String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("mobile", number);
        contentValues.put("password", password);
        long result = MyDB.insert("donar_table", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }


    public Boolean checkmail(String email) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from donar_table where email = ?", new String[]{email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }
//    public Boolean sendercheckmail(String email) {
//        SQLiteDatabase MyDB = this.getWritableDatabase();
//        Cursor cursor = MyDB.rawQuery("Select * from donar_table where email = ?", new String[]{email});
//        if (cursor.getCount() > 0)
//            return true;
//        else
//            return false;
//    }

    public Boolean checkMailandPass(String email, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from donar_table where email = ?and password = ?", new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }

    public Cursor getdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select * from donar_table",null);
        return  cursor;
    }
}
