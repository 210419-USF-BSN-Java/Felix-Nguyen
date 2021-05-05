package project0;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;

import project0.Customer;

public class User implements Menuable, Serializable {

	public User(int id, String type, String username, String pw){
		this.userID = id;
		this.usertype = type;
		this.username = username;
		this.password =  pw;
	};
	
	public User(){};
	
	private static int userID;
	private String usertype;
	private String username;
	private String password;
	
	private boolean menuLoop = true;
	Scanner sc = new Scanner(System.in);
	ArrayList<User> _user = new ArrayList<>();
	UserPostgres up = new UserPostgres();
	private static Logger l = Logger.getLogger(User.class.getName());
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
				logE("Invalid input during user menu");
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
						System.out.println("Please enter a value between 1 - 3!");
						break;
			}			
		}
		
		while(condition != 3);
		
	}

	public String Login() {
		Customer c = new Customer();
		Employee e = new Employee();
		int user_id = 0;
		
		System.out.println("Enter your username:");
		this.username = sc.next() + sc.nextLine();
				
		System.out.println("Enter your password:");
		this.password = sc.next() + sc.nextLine();

		menuLoop = false;
		
		UserPostgres u = new UserPostgres();
		String us = u.checkLogin(username, password).toString();
			
		switch(us) {
		case "customer":
				c.Menu();
				break;
		case "employee": 
				e.Menu();
				break;
			default:
				logE("Invalid login input");
				Menu();
				break;
		}		
		return us;
	}

	
	public void enterInfo() {
		
		System.out.println("Enter your username");		
		this.username = sc.next() + sc.nextLine(); //+ sc.next();
		
		System.out.println("Enter your password");
		this.password = sc.next() + sc.nextLine();
		
		while(this.username.equals(checkExistingUsername(this.username))) {
			System.out.println("Username already exists! Select another one");
			this.username = sc.next() + sc.nextLine();
		}
		try {
			createAcc((int)(Math.random()* 9999), "customer", this.username, this.password);
		}
		catch(Exception e) {
			logE("UserID has already been taken.  Rough RNJ...Please do it again");
		}
		menuLoop = false;	
	}
	
	public void createAcc(int id, String usertype, String username, String pw) {
		
		UserPostgres up = new UserPostgres();
		up.add(new User(id, usertype, username, pw));
		 
	}
	
	public String checkExistingUsername(String string) {
		return up.checkExistingUser(string);
	}
	
	/*public void printUsers() {

		System.out.println(_user.get(0).userID);
		System.out.println(_user.get(0).password);	
	}*/

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
	

	public void logI(String s) { // outputs string 's' with new line
		l.info(s);
		l.info("                 ");
	}
	
	public void logE(String s) { // outputs string 's' with new line
		l.error(s);
		l.error("                 ");
	}
	
	
}




