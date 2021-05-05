

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import project0.*;


public class ServiceTests {

	Customer c = new Customer();
	Employee e = new Employee();
	User u  = new User();
	ShopPostgres sp = new ShopPostgres();
	UserPostgres up = new UserPostgres();
	OffersPostgres op = new OffersPostgres();
	
	
	@Test
	public void makeOfferTest() {
		assertTrue(c.makeOffer() == 1);
		//item id: 1046
		//item_name: soy milk
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
	public void loginTest() {
		assertTrue(u.Login().equals("customer"));
		
	}
	
	@Test
	public void createAccTest() {
		User u = new User(46, "customer", "felix", "pw");
		assertTrue(up.add(u).getUsername().equals("felix"));
	}
	
	@Test
	public void checkExistingUserTest() {
		assertTrue(u.checkExistingUsername("username")!=null);
	}
	
	@Test
	public void checkExistingUsernameTest() {
		assertTrue(u.checkExistingUsername("username").equals("username"));
	}
	
	
	@Test
	public void addItemtest() {
		Shop shop = new Shop(1, "goat milk", "selling", false, 0);
		assertTrue(sp.add(shop).getItem().equals("goat milk"));
		
	}
	
	@Test
	public void removeItemtest() {
		Shop shop = new Shop(1, "goat milk", "selling", false, 0);
		sp.add(shop);
		shop = new Shop(1, "goat milk", "selling", false, 0);
		assertTrue(sp.delete(1, "goat milk") == 1);
		
	}
	
	@Test
	public void acceptRejectTest() {
		assertTrue(e.acceptReject() == 1);
	}
	
	@Test
	public void viewAllPaymentsTest() {
		assertTrue(op.viewOffers().get(0).getItemName().equals("cow milk"));
	}
	
	@Test
	public void calcWeeklyTest() {
		int s = 96 + 96;
		assertTrue(op.calcWeeklyPayment("2021/06/03", "2021/06/10") == 96);
	}
	
	@Test
	public void updateOwnedItemsTest() {
		
		assertFalse(sp.updateOwnedItems(7427, 927) == 1);
		assertTrue(sp.updateOwnedItems(7427, 926) == 1);
		
	}
	@Test
	public void updateOfferes() {		
		op.addOffer(53, 53, "goat milk", 10, 230, "pending");
		assertFalse(op.updateOffers(53)== 1);
	}
}
