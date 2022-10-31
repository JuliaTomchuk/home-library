package my.home.library.menu.impl;

import java.util.Scanner;

import my.home.library.menu.Page;

public class UpdateAllBooksPage implements Page {

	@Override
	public String getRequest() {
		String request = "UPDATE_ALL_BOOKS/";
		System.out.println("How much books in your list?");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while (!scanner.hasNextInt()) {
			scanner.nextLine();

		}
		int result = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < result; i++) {
			if (i != result) {
				System.out.println("Enter name of the book");
				request = request + scanner.nextLine() + "/";
				
				System.out.println("Enter author");
				request = request + scanner.nextLine() + "/";
				System.out.println("Enter type of the book");
				request = request + scanner.nextLine() + "/";
			} else {
				System.out.println("Enter name of the book");
				request = request + scanner.nextLine() + "/";
				System.out.println("Enter author");
				request = request + scanner.nextLine() + "/";
				System.out.println("Enter type of the book");
				request = request + scanner.nextLine();
			}

		}
		return request;
	}

}
