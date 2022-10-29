package my.home.library.main;

import java.util.Scanner;

import my.home.library.controller.Controller;
import my.home.library.controller.impl.ControllerImpl;
import my.home.library.entity.RegistrationInfo;

public class Main {

	public static void main(String[] args)  {
		
		Controller controller = new ControllerImpl();
		//String request;
				
		
//		System.out.println("Welcome to my library! \n  Press 1 for logination \n Press 2 for registration");
//		
//		@SuppressWarnings("resource")
//		Scanner scanner = new Scanner(System.in);
//		
//		while(!scanner.hasNextInt()) {
//			scanner.nextLine();
//			
//			System.out.println(" \n  Press 1 for logination \n Press 2 for registration");
//		}
//		int result=scanner.nextInt();
//		switch (result) {
//		case 1:
//			request="LOGINATION/";
//			System.out.println("Enter login");
//			while(!scanner.has) {
//				
//			}
//		}
		
		controller.doAction("registration/jan/tom/ADMINISTRATOR/jantom/12345");
	}}	