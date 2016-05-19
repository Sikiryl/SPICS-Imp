package com.example.sikiryl.spics;


import android.database.Cursor;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingFragment extends Fragment {


    public ShoppingFragment() {
        // Required empty public constructor
    }
    private DBHelper helper;
    int[] productID = new int[5];
    int[] productPrice = new int[5];
    String[] productName = new String[5];
    String[] productImage = new String[5];

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_shopping, container, false);
        helper = new DBHelper(getActivity());
        try{
            Cursor cursor = getProduct();
            listProduct(cursor);

            TextView outProductName1 = (TextView) rootView.findViewById(R.id.txtName);
            outProductName1.setText(productName[0]);
            TextView outProductPrice1 = (TextView) rootView.findViewById(R.id.txtPrice);
            outProductPrice1.setText("Price : " + Integer.toString(productPrice[0]));
            ImageView outProductImage1 = (ImageView) rootView.findViewById(R.id.img_shopping);
            outProductImage1.setImageURI(Uri.parse(productImage[0]));

            TextView outProductName2 = (TextView) rootView.findViewById(R.id.txtName2);
            outProductName2.setText(productName[1]);
            TextView outProductPrice2 = (TextView) rootView.findViewById(R.id.txtPrice2);
            outProductPrice2.setText("Price : " + Integer.toString(productPrice[1]));
            ImageView outProductImage2 = (ImageView) rootView.findViewById(R.id.img_shopping2);
            outProductImage2.setImageURI(Uri.parse(productImage[1]));

            TextView outProductName3 = (TextView) rootView.findViewById(R.id.txtName3);
            outProductName3.setText(productName[2]);
            TextView outProductPrice3 = (TextView) rootView.findViewById(R.id.txtPrice3);
            outProductPrice3.setText("Price : " + Integer.toString(productPrice[2]));
            ImageView outProductImage3 = (ImageView) rootView.findViewById(R.id.img_shopping3);
            outProductImage3.setImageURI(Uri.parse(productImage[2]));

            TextView outProductName4 = (TextView) rootView.findViewById(R.id.txtName4);
            outProductName4.setText(productName[3]);
            TextView outProductPrice4 = (TextView) rootView.findViewById(R.id.txtPrice4);
            outProductPrice4.setText("Price : " + Integer.toString(productPrice[3]));
            ImageView outProductImage4 = (ImageView) rootView.findViewById(R.id.img_shopping4);
            outProductImage4.setImageURI(Uri.parse(productImage[3]));

            TextView outProductName5 = (TextView) rootView.findViewById(R.id.txtName5);
            outProductName5.setText(productName[4]);
            TextView outProductPrice5 = (TextView) rootView.findViewById(R.id.txtPrice5);
            outProductPrice5.setText("Price : " + Integer.toString(productPrice[4]));
            ImageView outProductImage5 = (ImageView) rootView.findViewById(R.id.img_shopping5);
            outProductImage5.setImageURI(Uri.parse(productImage[4]));
        }
        finally{
            helper.close();
        }
        Button addProduct1 = (Button) rootView.findViewById(R.id.btn_add);
        addProduct1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    addToCart(productID[0]);
                    Snackbar.make(v, "Cart added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                finally{
                    helper.close();
                }
            }
        });
        Button addProduct2 = (Button) rootView.findViewById(R.id.btn_add2);
        addProduct2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    addToCart(productID[1]);
                    Snackbar.make(v, "Cart added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                finally{
                    helper.close();
                }
            }
        });
        Button addProduct3 = (Button) rootView.findViewById(R.id.btn_add3);
        addProduct3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    addToCart(productID[2]);
                    Snackbar.make(v, "Cart added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                finally{
                    helper.close();
                }
            }
        });
        Button addProduct4 = (Button) rootView.findViewById(R.id.btn_add4);
        addProduct4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    addToCart(productID[3]);
                    Snackbar.make(v, "Cart added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                finally{
                    helper.close();
                }
            }
        });
        Button addProduct5 = (Button) rootView.findViewById(R.id.btn_add5);
        addProduct5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    addToCart(productID[4]);
                    Snackbar.make(v, "Cart added", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                finally{
                    helper.close();
                }
            }
        });
        return rootView;
    }
    private void addToCart(int pID) {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("productID",Integer.toString(pID));
        db.insertOrThrow("cart",null,values);
    }
    private Cursor getProduct(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM product ORDER BY productID;",null);
        return cursor;
    }
    private void listProduct(Cursor cursor){
        int i=0;
        while (cursor.moveToNext()){
            productID[i] = cursor.getInt(0);
            productName[i] = cursor.getString(1);
            productPrice[i] = cursor.getInt(2);
            productImage[i] = cursor.getString(3);
            i++;
        }
    }
}