package my.home.library.menu.impl;

import my.home.library.menu.Page;

public class GetAllBooksPage implements Page {
	@Override
	public String getRequest() {
		return "GET_ALL_BOOKS/";
		
	}

}
