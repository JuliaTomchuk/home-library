package my.home.library.service;

import java.util.List;

import my.home.library.entity.Book;
import my.home.library.service.impl.ServiceException;

public interface LibraryServiceForAdministrator {

	boolean addBook(Book book) throws ServiceException;

	boolean addAllBooks(List<Book> books) throws ServiceException;

	boolean deleteBook(Book book) throws ServiceException;

	boolean updateAllBooks(List<Book> books) throws ServiceException;
}
