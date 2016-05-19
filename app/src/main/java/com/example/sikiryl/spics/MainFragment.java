package com.example.sikiryl.spics;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment{

    public MainFragment() {
        // Required empty public constructor
    }

    private DBHelper helper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        helper = new DBHelper(getActivity());
        try{
            Cursor cursor = getProduct();
            StringBuilder builder = listProduct(cursor);
            TextView output = (TextView) rootView.findViewById(R.id.productList);
            output.setText(builder);
        }
        finally{
            helper.close();
        }
        // Inflate the layout for this fragment
        return rootView;

    }
    private Cursor getProduct(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM product ORDER BY productID;",null);
        return cursor;
    }

    private StringBuilder listProduct(Cursor cursor){
        StringBuilder builder = new StringBuilder("Product list \n\n");
        while (cursor.moveToNext()){
            int productID = cursor.getInt(0);
            String productName = cursor.getString(1);
            int productPrice = cursor.getInt(2);
            String productImage = cursor.getString(3);
            builder.append(productID).append(" ").append(productName).append(" ").append(productPrice).append(" ").append(productImage).append("\n");

        }
        return builder;
    }

}
