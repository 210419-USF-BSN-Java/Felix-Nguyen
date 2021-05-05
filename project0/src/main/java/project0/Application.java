package project0;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Application {

	public static void main(String[] args) {
		BasicConfigurator.configure();
		Logger l = Logger.getLogger(Application.class);
		

//		User user = new User(1234, "employee", "username", "password");
//		UserPostgres up = new UserPostgres();
//		System.out.println(up.checkLogin("asdf", "alrighty"));
//		up.add(user);
		
		
		User user = new User();
		l.info("Begin Application");
		l.info("                 ");
		user.Menu();

		
//		Employee e = new Employee();
//		e.acceptReject();
//		e.viewOffers();
		
//		e.acceptReject();
//		e.deleteItem();
		
//		ShopPostgres shop = new ShopPostgres();
//		shop.updateOwnedItems(937975592);
//		shop.makeOffer(1, 1234, 4453715, "diamond pickaxe");
//		shop.viewItems();
//		shop.add(new Shop((int)(Math.random()*100000000), "diamond pickaxe", "pending", true, 0));
//		shop.delete(0, "kevin's soul");
		
//		Customer c = new Customer();
//		c.makeOffer();
		//c.viewList();
//		
//		OffersPostgres op = new OffersPostgres();
	
//		op.acceptOffer(83, "African polecat");
		//op.rejectOffer(10, "Flightless cormorant");
//		op.rejectOffer(46, "Puku");
//		op.acceptOffer(10, "Flightless cormorant");
		
//		SystemManagerPostgres sp = new SystemManagerPostgres();
//		sp.update();
		
//		op.acceptOffer(op.viewOffers().get(9).getOfferID());
//		op.updateOffers(op.viewOffers().get(9).getItemID());
//		shop.updateOwnedItems(op.viewOffers().get(9).getItemID());
		
	}

}
