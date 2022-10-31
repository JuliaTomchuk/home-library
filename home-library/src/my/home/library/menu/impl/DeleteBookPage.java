package my.home.library.menu.impl;

import java.util.Scanner;

import my.home.library.menu.Page;

public class DeleteBookPage implements Page {

	@Override
	public String getRequest() {
		String request = "DELETE_BOOK/";

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
