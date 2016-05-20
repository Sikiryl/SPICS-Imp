package method;

import static org.junit.Assert.*;
import org.junit.Test;

public class CartTest {
private Cart myCart = new Cart();
	
	@Test 
	public void test() {
		assertEquals("Fail - wrong total price", myCart.TotalPrice(),0,0);
	}
	
	// Test2 : Add 1 Product in Cart
	@Test 
	public void test2() {
		myCart.addToCart("MLG Glasses", 420.00, 1);
		assertEquals("Fail - wrong total price", myCart.TotalPrice(),420.00,0);
	}
	
	//Test3 : Add more one Product in Cart
	@Test 
	public void test3() {
		myCart.addToCart("MLG Glasses", 420.00, 1);
		myCart.addToCart("MtnDew", 322.00, 1);
		myCart.addToCart("MLG Glasses", 420.00, 1);
		assertEquals("Fail - wrong total price", myCart.TotalPrice(),1162.00,0);
	}
}
