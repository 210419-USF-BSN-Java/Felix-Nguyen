package project0;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {
		
//		User user = new User(1234, "employee", "username", "password");
//		UserPostgres up = new UserPostgres();
//		System.out.println(up.checkLogin("asdf", "alrighty"));
//		up.add(user);
		
		
//		User user = new User();
//		user.Menu();
		
		Employee e = new Employee();
		e.acceptReject();
//		e.viewOffers();
		
//		e.acceptReject();
//		e.deleteItem();
		
//		ShopPostgres shop = new ShopPostgres();
//		shop.makeOffer(1, 1234, 4453715, "diamond pickaxe");
//		shop.viewItems();
//		shop.add(new Shop((int)(Math.random()*100000000), "diamond pickaxe", "pending", true, 0));
//		shop.delete(0, "kevin's soul");
		
//		Customer c = new Customer();
//		c.makeOffer();
//		c.viewList();
//		
//		OffersPostgres op = new OffersPostgres();
//		op.acceptOffer(83, "African polecat");
		//op.rejectOffer(10, "Flightless cormorant");
//		op.rejectOffer(46, "Puku");
//		op.acceptOffer(10, "Flightless cormorant");
		
//		SystemManagerPostgres sp = new SystemManagerPostgres();
//		sp.update();
		
	}

}
