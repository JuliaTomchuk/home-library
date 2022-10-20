package my.home.library.service;

import java.util.List;

import my.home.library.entity.Book;

public interface BookValidator {
	
	boolean checkBook(Book book);
	boolean checkAllBooks(List<Book> books);

}
