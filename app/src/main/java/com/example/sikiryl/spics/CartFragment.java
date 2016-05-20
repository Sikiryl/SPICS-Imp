package com.example.sikiryl.spics;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CartFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends Fragment {
  /*  // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;*/
    private DBHelper helper;
    private int totalPrice = 0;

    public CartFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CartFragment.
     */
    // TODO: Rename and change types and number of parameters
 /*   public static CartFragment newInstance(String param1, String param2) {
        CartFragment fragment = new CartFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

   /* @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        /* Get Information From DB and Calculate Total Price */
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_cart, container, false);
        helper = new DBHelper(getActivity());
        totalPrice = 0;
        try{
            Cursor cursor = getCart();
            StringBuilder fullList = showCartAndCalculate(cursor);
            TextView outputFullList = (TextView) rootView.findViewById(R.id.txtFullList);
            outputFullList.setText(fullList);
            TextView outputTotalPrice = (TextView) rootView.findViewById(R.id.txtTotalPrice);
            outputTotalPrice.setText("Total Price : "+Integer.toString(totalPrice));
        }
        finally{
            helper.close();
        }
        Button btn = (Button) rootView.findViewById(R.id.flushNow);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getReadableDatabase();
                db.execSQL("DELETE FROM cart;");
                TextView outputTotalPrice = (TextView) rootView.findViewById(R.id.txtTotalPrice);
                Fragment frg = null;
                frg = getFragmentManager().findFragmentById(R.id.fragment_container);
                final FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(frg);
                ft.attach(frg);
                ft.commit();
            }
        });
        return rootView;
    }
    private Cursor getCart(){
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT productID,COUNT(productID) AS quantity FROM cart GROUP BY productID ORDER BY productID;",null);
        return cursor;
    }
    private StringBuilder showCartAndCalculate(Cursor cursor){
        StringBuilder builder = new StringBuilder();
        SQLiteDatabase db = helper.getReadableDatabase();
        while (cursor.moveToNext()) {
            int productID = cursor.getInt(0);
            int quantity = cursor.getInt(1);
            Cursor cursor2 = db.rawQuery("SELECT productName,productPrice FROM product WHERE productID = " + Integer.toString(productID) +";", null);
            cursor2.moveToNext();
            String productName = cursor2.getString(0);
            int productPrice = cursor2.getInt(1);
            totalPrice = totalPrice + (productPrice * quantity);
            builder.append(productName).append(" Quantity : ").append(quantity).append("\n");
        }
        return builder;
    }
    // TODO: Rename method, update argument and hook method into UI event
  /*  public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
*/
    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    /*public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
