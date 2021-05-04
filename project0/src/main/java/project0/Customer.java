package project0;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Customer extends User implements Menuable{
	
//	private String userID = "";
//	private String password = "";
//	private boolean menuLoop = true;
	Scanner sc = new Scanner(System.in);
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	LocalDateTime now = LocalDateTime.now(); 
	OffersPostgres op = new OffersPostgres();
	ShopPostgres sp = new ShopPostgres();
	
	public void Menu() {
		
		int condition = 0;
		System.out.println("Customer options:");
		System.out.println("Enter a number to continue:");
		System.out.println("1 : Make an offer");
		System.out.println("2 : View items");
		System.out.println("3 : View owned items");
		System.out.println("4 : View remaining payments for an item");
		System.out.println("5 : Exit");
		System.out.println("");
		
		do {
			
			try {
				condition = sc.nextInt();
			}
			catch(Exception e) {
				@SuppressWarnings("unused")
				String garbageCollect = sc.nextLine();			
			}
			
			switch(condition) {				
				case 1: 
					makeOffer();
					break;
				case 2: 		
					viewList();
					break;
				case 3: 
					viewOwnedItems();
					break;
				case 4:
					viewOtherOffers();
					break;
				case 5:
					System.out.println("Bye!");
					System.exit(0);
					default:
						break;
			}			
		}
		
		while(condition != 5);
	}
	
	/*public String Login() {
			
		System.out.println("Enter your userID:");
		this.userID = sc.next() + sc.nextLine();
		
		System.out.println("Enter your password:");
		this.password = sc.next()+ sc.nextLine();

		menuLoop = false;
		
		return this.userID;
	}*/
		
//	public void createAcc() {
//		
//		System.out.println("Enter your userID");
//		this.userID = sc.nextLine();
//		System.out.println("Enter your password");
//		this.password = sc.nextLine();
//		menuLoop = false;
//			
//	}
	
	public List<String> viewList() {
		ShopPostgres sp = new ShopPostgres();
		
		Iterator it = sp.viewItems().iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
		return sp.viewItems();
	}
	public Integer makeOffer() {
	
		System.out.println("Enter the item ID");
		int itemID = sc.nextInt();
		
		System.out.println("Enter the item name");
		String name = sc.next() + sc.nextLine();
		
		System.out.println("Enter the offer price");
		double offer = sc.nextDouble();
		
		OffersPostgres op = new OffersPostgres();
		int rows = op.addOffer((int)(Math.random() * 9999), itemID, name, offer, up.getUserID(), "pending");
		System.out.println("Offer Added!");
		
		return rows;
	}
	
	public List<String> viewOwnedItems() {
		return sp.viewOwnedItems(up.getUserID());
	}
	
	public List<Offers> viewOtherOffers() {
		Iterator it = op.viewOffersForItem().iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
		return op.viewOffersForItem();
	}

}
