package project0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class User implements Menuable, Serializable {

	User(int id, String type, String username, String pw){
		this.userID = id;
		this.usertype = type;
		this.username = username;
		this.password =  pw;
	};
	
	User(){};
	
	private static int userID;
	private String usertype;
	private String username;
	private String password;
	
	private boolean menuLoop = true;
	Scanner sc = new Scanner(System.in);
	ArrayList<User> _user = new ArrayList<>();
	
	
	public void Menu() {
		
		int condition = 0;
		UserPostgres u = new UserPostgres();
		
		System.out.println("User options:");
		System.out.println("Enter a number to continue:");
		System.out.println("1 : Login");
		System.out.println("2 : Create a customer account");
		System.out.println("3 : Exit");
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
				case 1: System.out.println("You selected to login");
						Login();
					break;
				case 2: System.out.println("You selected to create a new customer account");
						enterInfo();
						Menu();
					break;
				case 3: System.out.println("Bye!");
					System.exit(0);
					default:
						System.out.println("Invalid input");
						System.out.println("Please enter a value between 1 - 3!");
						break;
			}			
		}
		
		while(menuLoop);
		
	}

	public void Login() {
		Customer c = new Customer();
		Employee e = new Employee();
		System.out.println("Enter your username:");
		this.username = sc.next() + sc.nextLine();
		
		System.out.println("Enter your password:");
		this.password = sc.next() + sc.nextLine();

		menuLoop = false;
		
		UserPostgres u = new UserPostgres();
		String us = u.checkLogin(username, password).toString();
		//System.out.println(us);
			
		switch(us) {
		case "customer":
				c.Menu();
				break;
		case "employee": 
				e.Menu();
				break;
			default:
				System.out.println("Invalid login info");
				Login();
				break;
		}
	}
//		if(us.equals("customer")) {
//			System.out.println("customer");
//			//Customer.Menu();
//		}
//		
//		if(us.equals("employee")) {
//				System.out.println("EMP");
//				//Employee.Menu();
//		}
//		else System.out.println("Username/Password is invalid");
//			Login();
//	}
	
	public void enterInfo() {
		
		System.out.println("Enter your userID");
		
		this.username = sc.nextLine() + sc.next();
			while(this.username.isBlank())
			{
				System.out.println("CANNOT BE EMPTY! Please try again...");
				this.username = sc.nextLine();
			}
		
		System.out.println("Enter your password");
		this.password = sc.nextLine() + sc.next();
			while(this.password.isBlank())
			{
				System.out.println("CANNOT BE EMPTY! Please try again...");
				this.password = sc.nextLine();
			}
		createAcc((int)(Math.random()* 9999), "customer", this.username, this.password);
		menuLoop = false;	
	}
	
	public void createAcc(int id, String usertype, String username, String pw) {
		
		UserPostgres up = new UserPostgres();
		up.add(new User(id, usertype, username, pw));
		
	}
	
	public void printUsers() {

		System.out.println(_user.get(0).userID);
		System.out.println(_user.get(0).password);
		
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	
	
	
}




