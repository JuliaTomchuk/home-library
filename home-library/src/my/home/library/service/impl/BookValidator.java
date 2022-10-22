package my.home.library.service.impl;

import java.util.List;

import my.home.library.entity.Book;
import my.home.library.service.BookValidator;

public class BookValidatorImpl implements BookValidator {

	@Override
	public boolean checkBook(Book book) {
			
			return !(book.getName()==null||book.getAuthor()==null||book.getType()==null);
			}

	@Override
	public boolean checkAllBooks(List<Book> books) {
		
		for(int i=0;i<books.size();i++) {
			Book book = books.get(i);
			if(book.getName()==null||book.getAuthor()==null||book.getType()==null) {
				return false;
			}
		}
		
		return true;
}
	
}