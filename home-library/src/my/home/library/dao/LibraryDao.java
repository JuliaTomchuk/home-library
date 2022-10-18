package my.home.library.dao;

import java.util.List;

import my.home.library.entity.Book;

public interface LibraryDao {
	
	boolean addBook(Book book);
	
	Book findBook(Book book);
	
	boolean deleteBook(Book book);
	
	List<Book> getAllBooks();
	
	

}
