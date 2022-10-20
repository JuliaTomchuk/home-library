package my.home.library.service.impl;

import java.util.ArrayList;
import java.util.List;

import my.home.library.dao.DaoProvider;
import my.home.library.dao.impl.DaoException;
import my.home.library.entity.Book;
import my.home.library.service.BookValidator;
import my.home.library.service.LibraryServiceForUser;

public class LibraryServiceForUserImpl implements LibraryServiceForUser {
	private DaoProvider dao = DaoProvider.getInstance();
	private BookValidator validator = new BookValidatorImpl();
	
	@Override
	public Book getBook(Book book) throws ServiceException {
		if(!(validator.checkBook(book))) {
			throw new ServiceException();
		}
		
		Book result=new Book();
		try {
			result = dao.getLibraryForUsersDao().getBook(book);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
				
		return result;
	}

	@Override
	public List<Book> getALLBooks() throws ServiceException {
		List <Book> books = new ArrayList<>();
		try {
			books = dao.getLibraryForUsersDao().getAllBooks();
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return books;
	}

}
