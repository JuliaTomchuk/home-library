package my.home.library.service.impl;

import java.util.List;

import my.home.library.entity.Book;
import my.home.library.service.Validator;

public class BookValidator implements Validator <Book>{

	@Override
	public boolean isValid(Book book) {
			
			return !(book.getName()==null||book.getAuthor()==null||book.getType()==null);
			}

	@Override
	public boolean isValid(List<Book> books) {
		
		for(int i=0;i<books.size();i++) {
			Book book = books.get(i);
			if(!isValid(book)) {
				return false;
			}
		}
		
		return true;
}
	
}