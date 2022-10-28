package my.home.library.view;

import java.util.List;

import my.home.library.entity.Book;

public interface LibraryViewer {
	
	String  writeResponse(boolean result,String responce);
	String  writeResponse(Book book,String responce);
	String  writeResponse(List <Book> library,String responce);
	

}
