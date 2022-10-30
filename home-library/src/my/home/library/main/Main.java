package my.home.library.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.home.library.controller.Controller;
import my.home.library.controller.impl.ControllerImpl;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.Role;
import my.home.library.menu.GreetingPage;
import my.home.library.menu.LoginationPage;
import my.home.library.menu.Menu;
import my.home.library.menu.MenuProvider;
import my.home.library.menu.RegistrationPage;

public class Main {

	public static void main(String[] args)  {
		
		Controller controller = new ControllerImpl();
		String request="";
				
		
		
		GreetingPage greeting = new GreetingPage();
		
		greeting.print();
		String result = greeting.getRequest();
		
		
		switch (result) {
		case "1":
			request = new LoginationPage().getRequest();
			break;
		case "2":
			request =  new RegistrationPage().getRequest();
			
			}
		
		String registrationInfo = controller.doAction(request);
		
//		String regex="ADMINISTRATOR|SIMPLE_USER";
//		Pattern pattern = Pattern.compile(regex);
//	    Matcher matcher = pattern.matcher(registrationInfo);
//	    Role role=Role.SIMPLE_USER;
//	    while (matcher.find()) {
//	      role=Role.valueOf(matcher.group());
//	    }
//	    
//	    switch(role) {
//	    case ADMINISTRATOR:
//	    	System.out.println(
//	    		" 1 - ADD ALL books \n 2 - ADD BOOK \n 3 - DELETE BOOK \n 4 - EDIT USER \n 5 - GET ALL BOOKS \n"
//	    		+ " 6 - GET BOOK \n 7 - UPDATE ALL BOOKS");
//	    	
//	    	break;
//	    case SIMPLE_USER:
//	    	System.out.println(
//		    		" 1 - EDIT USER \n 2 - GET ALL BOOKS \n 3 - GET BOOK");
//	    	break;
//	    }
//     
}
		
		
	}	