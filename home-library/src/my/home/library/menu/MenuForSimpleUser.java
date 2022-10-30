package my.home.library.menu;

import java.util.Scanner;

public class MenuForSimpleUser {
	
	public void getRequest() {
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
		case 1: new EditUserPage().get
		}
	}

}
