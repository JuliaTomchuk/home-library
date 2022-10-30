package my.home.library.menu.impl;

import java.util.Scanner;

import my.home.library.menu.Page;



public class RegistrationPage  implements Page{

	@Override
	public String getRequest() {
		
		@SuppressWarnings("resource")
		Scanner scanner =new Scanner(System.in);
		
		String request="REGISTRATION/";
				
		System.out.println("Enter first name");
		
		request=request+ scanner.nextLine()+"/";
		
		System.out.println("Enter second name");
		
		request =request + scanner.nextLine()+"/";
		
		System.out.println("Enter role administrator or simple_user");
		
		request=request+scanner.nextLine()+"/";
		
		System.out.println("Enter login");
		
		request=request+scanner.nextLine()+"/";
		
		System.out.println("Enter password");
		
		request=request+scanner.nextLine();
		
		return request;
	}

	

}
