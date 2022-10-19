package my.home.library.dao;

import java.util.List;

import my.home.library.dao.impl.DaoException;
import my.home.library.entity.Book;

public interface LibraryForAdminDao {
	
	boolean addBook(Book book) throws DaoException;
	boolean deleteBook(Book book)throws DaoException;
	boolean addAllBooks(List<Book> newBooks)throws DaoException;
	boolean updateAllBooks(List<Book> newBooks)throws DaoException;

}
