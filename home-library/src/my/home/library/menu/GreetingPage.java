package my.home.library.menu;

import java.util.Scanner;



public class GreetingPage{

	
	public void print() {
		System.out.println("Welcome to my library! \n  Press 1 for logination \n Press 2 for registration");	
		
	}

	public String getRequest() {
		int result=0;
  @SuppressWarnings("resource")
  Scanner scanner = new Scanner(System.in);
  
			while((result!=1)&&(result!=2)) {
				
				
		while(!scanner.hasNextInt()) {
			scanner.nextLine();	
			System.out.println(" \n  Press 1 for logination \n Press 2 for registration");
		}
		
		result=scanner.nextInt();
		
			}
		
		return Integer.toString(result);
	}

}
