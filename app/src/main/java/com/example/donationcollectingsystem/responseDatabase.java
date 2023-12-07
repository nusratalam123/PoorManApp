package com.example.donationcollectingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class responseDatabase extends SQLiteOpenHelper {
    public static final String DBNAME = "response.db";
    public responseDatabase(@Nullable Context context) {
        super(context, DBNAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table responseTable(email TEXT primary key,bank TEXT,district TEXT,thana TEXT)");

    }
    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int i, int i1) {
        MyDB.execSQL("drop Table if exists responseTable");
    }

    public Boolean insertresponselist(String email,String bank,String district,String thana){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put("email", email);
        contentValues.put("bank", bank);
        contentValues.put("district", district);
        contentValues.put("thana", thana);
        long result = MyDB.insert("responseTable", null, contentValues);
        if(result==-1) return false;
        else
            return true;
    }

    public Cursor responseListgetdata(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=db.rawQuery("select *from responseTable",null);
        return  cursor;
    }

}
