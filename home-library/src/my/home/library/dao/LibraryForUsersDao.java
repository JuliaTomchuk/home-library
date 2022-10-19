package my.home.library.dao;

import java.util.List;

import my.home.library.dao.impl.DaoException;
import my.home.library.entity.Book;

public interface LibraryForUsersDao {
	
	
	Book getBook(Book book)throws DaoException;
		
	List<Book> getAllBooks()throws DaoException;
	
	
	

}
