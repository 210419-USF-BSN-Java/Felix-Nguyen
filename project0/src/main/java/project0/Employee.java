package project0;

import java.util.Iterator;
import java.util.Scanner;

public class Employee extends User implements Menuable{
	
	Scanner sc = new Scanner(System.in);
	
	public void Menu() { 
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
		sp.add(new Shop((int)(Math.random()*999999999), item, "selling", false, 0));
		System.out.println(item + " has been added!");
		System.out.println("");
		
	}
	
	public void deleteItem() {
		
		System.out.println("Enter the id of the item you want to delete");
		int id = sc.nextInt();
		
		System.out.println("Confirm the item by entering the item's name");
		String name = sc.next() + sc.nextLine();
		
		ShopPostgres sp = new ShopPostgres();
		sp.delete(id, name);
		System.out.println(name + " has been deleted!");
		System.out.println("");
	}
	
	public void acceptReject() {
		int offerNumber = -1;
			OffersPostgres op = new OffersPostgres();
			
			System.out.println("Enter an offer # to accept/reject");	
			offerNumber = sc.nextInt();
			
			System.out.println("Enter A to Accept or R to Reject");
			String in = sc.next();
			in.toUpperCase();
			switch(in) {
				case "A": 
					op.acceptOffer(op.viewOffers().get(offerNumber).getOfferID());
					op.updateOffers(op.viewOffers().get(offerNumber).getItemID());
						/*try {
							op.updateOffers(op.viewOffers().get(offerNumber).getItemID());
						}
				
				catch(Exception e) {
					System.out.println("Could not find any other pending offers to delete!");
				}*/
					break;
				case "R": op.rejectOffer(op.viewOffers().get(offerNumber).getOfferID());
					System.out.println("Invalid character entered! ");
					break;
						default:
							break;
			
			}
		
	}
	
	
	
	public void viewOffers() {
		
		OffersPostgres op = new OffersPostgres();
		
		Iterator it = op.viewOffers().iterator();
		int i = 0;
		while(it.hasNext()) {
			
			Object o = it.next();
			System.out.print(i + ": ");
			System.out.println(o);
			i++;
		}
	}
	

		
	
}
