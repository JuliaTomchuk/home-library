package my.home.library.dao.impl;

import java.io.BufferedWriter;
import java.io.File;

import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

import my.home.library.dao.DaoProvider;
import my.home.library.dao.LibraryForAdminDao;
import my.home.library.dao.LibraryForUsersDao;
import my.home.library.entity.Book;

public class LibraryForAdminDaoImpl extends LibraryForUsersDaoImpl implements LibraryForAdminDao {
	private File file = new File("C:\\Users\\Шипотяне\\git\\home-library\\home-library\\src\\resource\\books.txt");
	private LibraryForUsersDao libraryForUserDao =new LibraryForUsersDaoImpl();

	@Override
	public boolean addBook(Book book) throws DaoException {

		boolean isAdded = false;
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

			writer.write(book.getName() + "/" + book.getAuthor() + "/" + book.getType());
			writer.newLine();

		} catch (IOException e) {
			throw new DaoException(e);
		}

		Book newBook = libraryForUserDao.getBook(book);
		if (newBook != null)
			isAdded = true;

		return isAdded;

	}

	@Override
	public boolean deleteBook(Book book) throws DaoException {
		List<Book> books = getAllBooks();

		boolean isDeleted = books.remove(book);
		
			updateAllBooks(books);
		

		return isDeleted;
	}

	@Override
	public boolean addAllBooks(List<Book> newBooks) throws DaoException {

		for (int i = 0; i < newBooks.size(); i++) {
			addBook(newBooks.get(i));
		}
		List<Book> library = libraryForUserDao.getAllBooks();

		return library.containsAll(newBooks);
	}

	@Override
	public boolean updateAllBooks(List<Book> newBooks) throws DaoException {
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file,false))){
			if(!newBooks.isEmpty()) {
			writer.write(
					newBooks.get(0).getName() + "/" + newBooks.get(0).getAuthor() + "/" + newBooks.get(0).getType());
			for (int i = 1; i < newBooks.size(); i++) {
				addBook(newBooks.get(i));
			}
			}
		} catch (IOException e) {
			throw new DaoException(e);
		}
		List<Book> library = libraryForUserDao.getAllBooks();

		return library.equals(newBooks);
	}

}
