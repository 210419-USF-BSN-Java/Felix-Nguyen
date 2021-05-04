package com.shop.customer;
import static org.junit.Assert.*;
import org.junit.Test;

import project0.*;

public class CustomerImpTests {

	Customer c = new Customer();
	
	@Test
	public void makeOfferTest() {
		assertTrue(c.makeOffer() == 1);
		//item id: 160
		//item_name: lost soul
		//price: xxx
		//username: cus
		//pw: pw
	}
	
	@Test
	public void viewItemsTest() {
		assertTrue(c.viewList() != null);
	}
	
	@Test
	public void viewListTest() {
		assertTrue(c.viewList() != null);
	}
	
	@Test
	public void viewOwnedItemsTest() {
		assertTrue(c.viewOwnedItems()!= null);
	}
	
	@Test
	public void viewOtherOffersTest() {
		assertTrue(c.viewOtherOffers() != null);
	}
}
