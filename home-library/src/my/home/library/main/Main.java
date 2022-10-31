package my.home.library.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.home.library.controller.Controller;
import my.home.library.controller.impl.ControllerImpl;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.Role;
import my.home.library.menu.Menu;
import my.home.library.menu.Page;
import my.home.library.menu.impl.AccessControl;
import my.home.library.menu.impl.GreetingPage;
import my.home.library.menu.impl.LoginationPage;
import my.home.library.menu.impl.MenuForAdministrator;
import my.home.library.menu.impl.MenuForSimpleUser;
import my.home.library.menu.impl.RegistrationPage;

public class Main {

	public static void main(String[] args)  {
		
		Controller controller = new ControllerImpl();
		String request="";
				
		
		
		GreetingPage greeting = new GreetingPage();
		
		
		String result = greeting.getRequest();
		
		
		switch (result) {
		case "1":
			request = new LoginationPage().getRequest();
			break;
		case "2":
			request =  new RegistrationPage().getRequest();
			
			}
		
		String registrationInfo = controller.doAction(request);
		AccessControl accessControl= new AccessControl();
		
		Role role= accessControl.determineRole(registrationInfo);
		Page page=null;
		
		switch(role) {
		case SIMPLE_USER:
			page=new MenuForSimpleUser().chooseOperation();
			break;
			
		case ADMINISTRATOR:
			page=new MenuForAdministrator().chooseOperation();
			
			break;
		}
		
	controller.doAction(page.getRequest());
		
		
  
}
		
		
	}	