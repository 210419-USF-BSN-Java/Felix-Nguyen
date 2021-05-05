package project0;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class Employee extends User implements Menuable{
	
	private static Logger l = Logger.getLogger(Employee.class.getName());
	private static Scanner sc = new Scanner(System.in);
	private OffersPostgres op = new OffersPostgres();
	
	public void Menu() { 
		int s = op.calcWeeklyPayment("2021/05/05", "2021/05/12");
		l.info("Total payment during the two specified dates: " + s);
		System.out.println("Employee options:");
		System.out.println("Enter a number to continue");
		System.out.println("1 : Add item to shop");
		System.out.println("2 : Remove item from shop");
		System.out.println("3 : Accept/Reject Offer");
		System.out.println("4 : View all payments");
		System.out.println("5 : Exit");
		System.out.println("");
		
	int condition = 0;
	
	
	do {
		try {
			condition = sc.nextInt();
		}
		catch(Exception e) {
			@SuppressWarnings("unused")
			String garbageCollect = sc.nextLine();	
			logE("Enter an appropriate integer");
			garbageCollect = sc.nextLine();
		}
		
		switch(condition) {				
			case 1: 
				addItem();			
				Menu();
				break;
			case 2: 	
				deleteItem();				
				Menu();
				break;
			case 3: 
				acceptReject();		
				Menu();
				break;
			case 4:
				viewOffers();
				break;
			case 5:
				System.out.println("Bye!");
				System.exit(0);
				default:
					break;
		}		
		condition = 0;
	}
	
	while(condition != 5);	

	}
	
	public void addItem() {
		
		ShopPostgres sp = new ShopPostgres();
		System.out.println("Enter the name of your item for sale");
		String item = sc.next() + sc.nextLine();
		sp.add(new Shop((int)(Math.random()*9999), item, "selling", false, 0));
		System.out.println(item + " has been added!");
		System.out.println("");
		
	}
	
	public Integer deleteItem() {
		String name = null;
		int id = 0;
		try {
			System.out.println("Enter the id of the item you want to delete");	
			id = sc.nextInt(); 
		}
		catch(InputMismatchException e) {
			logE("Wrong type of input");
		}
		try {
			System.out.println("Confirm the item by entering the item's name");
			name = sc.next() + sc.nextLine();
		}
		catch(InputMismatchException e) {
			logE("Wrong type of input");
		}

		ShopPostgres sp = new ShopPostgres();
		sp.delete(id, name);
		System.out.println(name + " has been deleted!");
		System.out.println("");
		return sp.delete(id, name);
	}
	
	public Integer acceptReject() {
		int offerNumber = -1;
			OffersPostgres op = new OffersPostgres();
			ShopPostgres sp = new ShopPostgres();
			int rows = -1;
			System.out.println("Enter an offer # to accept/reject");	
			try {
				offerNumber = sc.nextInt();
			}
			
			catch(InputMismatchException e) {
				logE("Please enter an appropriate integer");
			}
			System.out.println("Enter A to Accept or R to Reject");
			String in = sc.next();
	
			do {
				switch(in) {
					case "A": 
						int acceptedRows = op.acceptOffer(op.viewOffers().get(offerNumber).getOfferID());
						op.updateOffers(op.viewOffers().get(offerNumber).getItemID());						
						sp.updateOwnedItems(op.viewOffers().get(offerNumber).getUserID(),
								op.viewOffers().get(offerNumber).getItemID());										
				
						rows = acceptedRows;
						Menu();
						break;
					case "a":	
						acceptedRows = op.acceptOffer(op.viewOffers().get(offerNumber).getOfferID());
						op.updateOffers(op.viewOffers().get(offerNumber).getItemID());
						
							sp.updateOwnedItems(op.viewOffers().get(offerNumber).getUserID(),
									op.viewOffers().get(offerNumber).getItemID());	
							
		
						rows = acceptedRows;
						Menu();
						break;
					case "R": 
						int rejectedRows = op.rejectOffer(op.viewOffers().get(offerNumber).getOfferID());					
						rows = rejectedRows;
						Menu();
						break;
					case "r": 
						rejectedRows = op.rejectOffer(op.viewOffers().get(offerNumber).getOfferID());					
						rows = rejectedRows;
						Menu();
							default: System.out.println("Invalid character entered! ");
									 Menu();
								break;	
				}
			}
			while(false);
		return rows;
	}	
	
	public List<Offers> viewOffers() {
		
		OffersPostgres op = new OffersPostgres();
		
		Iterator it = op.viewOffers().iterator();
		int i = 0;
		while(it.hasNext()) {
			
			Object o = it.next();
			System.out.print(i + ": ");
			System.out.println(o);
			i++;
		}
		return op.viewOffers();
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
