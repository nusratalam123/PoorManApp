package com.example.donationcollectingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class senderListDatabase extends SQLiteOpenHelper {
    public static final String DBNAME = "sender_database.db";

    public senderListDatabase(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

//    public senderListDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
//        super(context, name, factory, version);
//    }
//
//    public senderListDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
//        super(context, name, factory, version, errorHandler);
//    }
//
//    public senderListDatabase(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
//        super(context, name, version, openParams);
//    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table DonarsenderInfo(name TEXT ,email TEXT primary key,mobile TEXT,bank TEXT,ammount TEXT, date TEXT,district TEXT,thana TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists DonarsenderInfo");

    }

    public Boolean insertDatalist(String name, String email,String number,String bank,String ammount,String date,String district,String thana){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("mobile", number);
        contentValues.put("bank", bank);
        contentValues.put("ammount", ammount);
        contentValues.put("date", date);
        contentValues.put("district", district);
        contentValues.put("thana", thana);
        long result = MyDB.insert("DonarsenderInfo", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Cursor sendergetdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select *from DonarsenderInfo",null);
        return  cursor;
    }


}
