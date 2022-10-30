package my.home.library.menu;

import java.util.Scanner;

public class LoginationPage {
	
	public String getRequest() {
		String request="logination/";
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter login");
		
		request= request +scanner.nextLine() + "/";
				
		System.out.println("Enter pasword");
		
		request= request +scanner.nextLine();
		
		return request;
	}

}
