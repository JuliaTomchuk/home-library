package my.home.library.menu.impl;

import java.util.Scanner;

import my.home.library.menu.Page;

public class LoginationPage implements Page {
	
	public String getRequest() {
		String request="logination/";
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		
		
		System.out.println("Enter login");
		
		request= request +scanner.nextLine() + "/";
				
		System.out.println("Enter pasword");
		
		request= request +scanner.nextLine();
		
		return request;
	}

}
