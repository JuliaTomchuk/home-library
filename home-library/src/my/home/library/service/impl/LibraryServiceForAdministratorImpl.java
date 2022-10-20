package my.home.library.service.impl;

import java.util.List;

import my.home.library.dao.DaoProvider;
import my.home.library.dao.impl.DaoException;
import my.home.library.entity.Book;
import my.home.library.service.BookValidator;
import my.home.library.service.LibraryServiceForAdministrator;

public class LibraryServiceForAdministratorImpl extends LibraryServiceForUserImpl  implements LibraryServiceForAdministrator {

	private DaoProvider dao = DaoProvider.getInstance();
	private BookValidator validator = new BookValidatorImpl();
	
	@Override
	public boolean addBook(Book book) throws ServiceException {
		if(!(validator.checkBook(book))) {
			throw new ServiceException();
		}
		boolean isAdd=false;
		try {
		   isAdd = dao.getLibraryForAdminDao().addBook(book);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		
		return isAdd;
	}

	@Override
	public boolean addAllBooks(List<Book> books) throws ServiceException {
		if(!(validator.checkAllBooks(books))) {
			throw new ServiceException();
		}
		boolean isAdd=false;
		
			try {
				isAdd =dao.getLibraryForAdminDao().addAllBooks(books);
			} catch (DaoException e) {
				throw new ServiceException(e);
			}
			
			return isAdd;
		
	}

	@Override
	public boolean deleteBook(Book book) throws ServiceException {
		if(!(validator.checkBook(book))) {
			throw new ServiceException();
		}
		 boolean isDeleted=false;
		try {
			isDeleted = dao.getLibraryForAdminDao().deleteBook(book);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		 
		 return isDeleted;
	}

	@Override
	public boolean updateAllBooks(List<Book> books) throws ServiceException  {
		if(!(validator.checkAllBooks(books))) {
			throw new ServiceException();
		}
		boolean isUpdated=false;
		
		try {
			isUpdated=dao.getLibraryForAdminDao().updateAllBooks(books);
		} catch (DaoException e) {
			throw new ServiceException();
		}
		
		return isUpdated;
	}
	
	

}
