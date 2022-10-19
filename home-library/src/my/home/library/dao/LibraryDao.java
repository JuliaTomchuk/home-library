package my.home.library.dao;

import java.util.List;

import my.home.library.dao.impl.DaoException;
import my.home.library.entity.Book;

public interface LibraryDao {
	
	boolean addBook  (Book book) throws DaoException;
	
	Book findBook(Book book)throws DaoException;
	
	boolean deleteBook(Book book)throws DaoException;
	
	List<Book> getAllBooks()throws DaoException;
	boolean addAllBooks(List<Book> books) throws DaoException;
	
	

}
