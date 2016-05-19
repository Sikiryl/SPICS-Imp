package com.example.sikiryl.spics;

/**
 * Created by User on 19/5/2559.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "spics_newdb.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE product (" +
                "productID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "productName TEXT," +
                "productPrice INTEGER," +
                "productImage TEXT);");
        db.execSQL("CREATE TABLE cart (" +
                "cartID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "productID INTEGER);");
        db.execSQL("INSERT INTO product (productName,productPrice,productImage) VALUES" +
                "('MLG Glasses',420,'android.resource://com.example.sikiryl.spics/drawable/mlgglass')," +
                "('MtnDew',322,'android.resource://com.example.sikiryl.spics/drawable/mtndew')," +
                "('Air Horn',666,'android.resource://com.example.sikiryl.spics/drawable/airhorn')," +
                "('Doritos',69,'android.resource://com.example.sikiryl.spics/drawable/doritos')," +
                "('Salt',24,'android.resource://com.example.sikiryl.spics/drawable/salt');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
