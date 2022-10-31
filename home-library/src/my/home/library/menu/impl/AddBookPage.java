package my.home.library.menu.impl;

import java.util.Scanner;

import my.home.library.menu.Page;

public class AddBookPage implements Page {

	@Override
	public String getRequest() {
		String request = "ADD_BOOK/";

		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter name of the book");
		request = request + scanner.nextLine() + "/";
		System.out.println("Enter author");
		request = request + scanner.nextLine() + "/";
		System.out.println("Enter type of the book");
		request = request + scanner.nextLine();

		return request;
	}

}
