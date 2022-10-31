package my.home.library.menu.impl;

import java.util.Scanner;

import my.home.library.menu.Page;

public class EditUserPage implements Page{
	@Override
	public String  getRequest() {
		String request = "EDIT_USER/";
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter login:");
		request= request + scanner.nextLine() +"/";
		System.out.println("Enter password:");
		request= request + scanner.nextLine() +"/";
		System.out.println("Enter new profile:");
		System.out.println("Enter first name:");
		request= request + scanner.nextLine() +"/";
		System.out.println("Enter second name:");
		request= request + scanner.nextLine() +"/";
		System.out.println("Enter role:");
		request= request + scanner.nextLine() +"/";
		System.out.println("Enter login:");
		request= request + scanner.nextLine() +"/";
		System.out.println("Enter password:");
		request= request + scanner.nextLine();
		
				
		return request; 
		}

}
