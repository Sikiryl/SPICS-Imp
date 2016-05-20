package com.example.sikiryl.spics;

import android.view.LayoutInflater;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by saweera on 5/20/2016.
 */
public class ShoppingFragmentTest {

    private ShoppingFragment testShoppingFragment;
    public int firstProduct;    //create variable for test
    @Before
    public void setUp() throws Exception {
        testShoppingFragment = new ShoppingFragment(); //new object class
        firstProduct = testShoppingFragment.productID[0]; //throw value in productID[0] in ShoppingFragment to variable firstProduct
    }

    @Test
    public void testOnCreateView() throws Exception {
        assertEquals("mistake product ID",firstProduct,0); //check value in firstProduct that equals real value in Database. If not equal it will print message 'mistake product ID'
    }
}