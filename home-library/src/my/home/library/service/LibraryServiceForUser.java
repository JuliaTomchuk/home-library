package my.home.library.service;

import java.util.List;

import my.home.library.entity.Book;
import my.home.library.service.impl.ServiceException;

public interface LibraryServiceForUser {

	Book getBook(Book book) throws ServiceException;

	List<Book> getALLBooks() throws ServiceException;

}
