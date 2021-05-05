package project0;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Customer extends User implements Menuable, CustomerDao{
	
	private Scanner sc = new Scanner(System.in);
    private static Logger l = Logger.getLogger(project0.Customer.class.getName());
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
				logI("Non integer input during customer menu!");
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
						System.out.println("Please select a value between 1 - 5");
						break;
			}			
		}
		
		while(condition < 6);
	}
	
	@Override
	public Integer makeOffer() {
		
		int itemID = 0;
		double offer = 0.0;
		String name = "";
		String getItemName = "";
		try {
			System.out.println("Enter the item ID");
			itemID = sc.nextInt();
		}
	
		catch(Exception e){
			logE("When making an offer: Not a int!");
			String garbageCollect = sc.nextLine();
			Menu();
		}	
		//String gc = sc.nextLine();
		/*System.out.println("Enter the item name");
		name = sc.nextLine();*/			
		try {
			//System.out.println(itemID);
			getItemName = op.getItemName(itemID);
			//System.out.println("+ getItemName);
		}
		catch(Exception ex) {
			logE("Item ID not found!");
		}
			
		try {
			System.out.println("Enter the offer price");
			offer = sc.nextDouble();
		}
		catch(Exception e) {
			logE("When making an offer: Not a double!");
			String garbageCollect = sc.nextLine();			
		}
		OffersPostgres op = new OffersPostgres();
		int rows = op.addOffer((int)(Math.random() * 9999), itemID, getItemName, offer, up.getUserID(), "pending");
		System.out.println("Offer Added!");
		
		return rows;
	}
	
	@Override
	public List<String> viewList() {
		ShopPostgres sp = new ShopPostgres();
		Iterator it = sp.viewItems().iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
		return sp.viewItems();
	}
	
	@Override
	public List<String> viewOwnedItems() {
		return sp.viewOwnedItems(up.getUserID());
	}
	
	@Override
	public List<Offers> viewOtherOffers() {
		Iterator it = op.viewOffersForItem().iterator();
		while(it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}
		return op.viewOffersForItem();
	}

	public void logI(String s) { // outputs string 's' with new line
		l.info(s);
		l.info("                 ");
	}
	
	public void logE(String s) { // outputs string 's' with new line
		l.error(s);
		l.error("                 ");
	}



}
