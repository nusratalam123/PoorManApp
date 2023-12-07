package com.example.donationcollectingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class selfPaymentDatabase extends SQLiteOpenHelper {
    public static final String DBNAME = "seldPayment_database.db";
    public selfPaymentDatabase(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table selfPayment(name TEXT ,district TEXT,mobile TEXT primary key, senderName TEXT,senderEmail TEXT, amount TEXT,tranjacId TEXT,date TEXT,method TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists selfPayment");

    }

    public Boolean insertPaymentData(String name, String distric,String mobile,String senderName,String senderEmail,String amount,String tranjacId,String date,String method){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("name", name);
        contentValues.put("district", distric);
        contentValues.put("mobile", mobile);
        contentValues.put("senderName", senderName);
        contentValues.put("senderEmail", senderEmail);
        contentValues.put("amount", amount);
        contentValues.put("tranjacId", tranjacId);
        contentValues.put("date", date);
        contentValues.put("method", method);

        long result = MyDB.insert("selfPayment", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

}
