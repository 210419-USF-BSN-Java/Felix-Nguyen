package project0;

import java.util.Iterator;
import java.util.Scanner;

public class Customer extends User implements Menuable{
	
	private String userID = "";
	private String password = "";
	private boolean menuLoop = true;
	Scanner sc = new Scanner(System.in);

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
					break;
				case 4:
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
	
	public void Login() {
			
		System.out.println("Enter your userID:");
		this.userID = sc.next() + sc.nextLine();
		
		System.out.println("Enter your password:");
		this.password = sc.next()+ sc.nextLine();

		menuLoop = false;
	}
		
	public void createAcc() {
		
		System.out.println("Enter your userID");
		this.userID = sc.nextLine();
		System.out.println("Enter your password");
		this.password = sc.nextLine();
		menuLoop = false;
			
	}
	
	public void viewList() {
		ShopPostgres sp = new ShopPostgres();
		
		Iterator it = sp.viewItems().iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
	}
	public void makeOffer() {
		//input item id to buy need to add to view list
		System.out.println("Enter the item ID");
		int itemID = sc.nextInt();
		
		System.out.println("Confirm with the item name");
		String name = sc.next() + sc.nextLine();
		
		System.out.println("Enter the offer price");
		int offer = sc.nextInt();
		
		OffersPostgres op = new OffersPostgres();
		op.addOffer((int)(Math.random() * 999999999), itemID, name, offer, getUserID(), "pending");
		System.out.println("Offer Added!");
	}

}
