package com.example.sikiryl.spics;

/**
 * Created by User on 19/5/2559.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "spics_database.db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS product (" +
                "productID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "productName TEXT," +
                "productPrice REAL," +
                "productImage TEXT);");
        db.execSQL("CREATE TABLE IF NOT EXISTS cart (" +
                "cartID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "productID INTEGER);");
        db.execSQL("INSERT INTO product (productName,productPrice,productImage) VALUES" +
                "('MLG Glasses',420,'@drawable/profile.png')," +
                "('MtnDew',322,'@drawable/background_material_red.png');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){

    }
}
