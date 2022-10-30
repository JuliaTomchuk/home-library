package my.home.library.menu.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import my.home.library.menu.Menu;
import my.home.library.menu.Page;

public class MenuForAdministrator implements Menu {
	
	private Map<Integer,Page> pages = new HashMap<>();
	
	public MenuForAdministrator() {
		pages.put(1,new AddAllBooksPage() );
		pages.put(2,new AddBookPage() );
		pages.put(3,new DeleteBookPage() );
		pages.put(4,new EditUserPage() );
		pages.put(5,new GetAllBooksPage() );
		pages.put(6,new GetBookPage() );
		pages.put(7,new UpdateAllBooksPage() );
		
		
	}
	
	@Override
	public Page chooseOperation() {
		
  System.out.println(" 1 - ADD ALL books \n 2 - ADD BOOK \n 3 - DELETE BOOK \n 4 - EDIT USER \n 5 - GET ALL BOOKS \n"
    		+ " 6 - GET BOOK \n 7 - UPDATE ALL BOOKS");
	
	
	int result=0;
	
	@SuppressWarnings("resource")
	Scanner scanner = new Scanner(System.in);
	
	while(result<1||result>7) {
		while(!scanner.hasNextInt()) {
			scanner.nextLine();
		}
		
	}
	
	result=scanner.nextInt();
	
	  return pages.get(result);
	
	
	
	}

}
