package my.home.library.dao.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import my.home.library.dao.LibraryForUsersDao;
import my.home.library.entity.Book;
import my.home.library.entity.TypeOfBook;

public class LibraryForUsersDaoImpl implements LibraryForUsersDao{
	private File file = new File("C:\\Users\\Шипотяне\\git\\home-library\\home-library\\src\\resource\\books.txt");

	@Override
	public Book getBook(Book book) throws DaoException {
		List <Book>books = getAllBooks();
		Book result=new Book();
		
		for(int i=0;i<books.size();i++) {
			if(book.equals(books.get(i)))
				result=books.get(i);
		}
		return result;
	}

	@Override
	public List<Book> getAllBooks() throws DaoException {
List<Book> books = new ArrayList<>();
		
		

		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line = reader.readLine();
			while (line != null) {
				String[] names = line.split("/");
				System.out.println(names);
				books.add(new Book(names[0], names[1], TypeOfBook.valueOf(names[2])));
				line = reader.readLine();
			}

		} catch (IOException e) {
			throw new DaoException(e);
		}

		return books;
	}



}
