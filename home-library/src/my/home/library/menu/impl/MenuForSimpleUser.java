package my.home.library.menu.impl;

import java.util.Scanner;

import my.home.library.menu.Menu;
import my.home.library.menu.Page;

public class MenuForSimpleUser implements Menu{
	
	private 
	public MenuForSimpleUser() {}
	
	@Override
	public Page chooseOperation() {
		System.out.println(	" 1 - EDIT USER \n 2 - GET ALL BOOKS \n 3 - GET BOOK");
		int result=0;
		Scanner scanner = new Scanner(System.in);
		
		while(result<1||result>3) {
			
			while(!scanner.hasNextInt()) {
				scanner.nextLine();
			}
			result=scanner.nextInt();
		}
		
		switch(result) {
		case 1: 
			new EditUserPage().getRequest();
			break;
		case 2: 
			new GetAllBooksPage().getRequest();
			break;
		case 3:
			new GetBookPage().getRequest();
			break;
		
		}
	}

}
