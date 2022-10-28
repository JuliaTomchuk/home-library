package my.home.library.command.impl;

import my.home.library.command.Command;
import my.home.library.entity.Book;
import my.home.library.entity.TypeOfBook;
import my.home.library.service.LibraryServiceForUser;
import my.home.library.service.ServiceProvider;
import my.home.library.service.impl.ServiceException;
import my.home.library.view.LibraryViewer;
import my.home.library.view.ViewerProvider;


public class GetBook implements Command {
	private ServiceProvider serviceProvider = ServiceProvider.getInstance();
	private LibraryServiceForUser libraryServiceForUser = serviceProvider.getLibraryServiceForUser();
	private ViewerProvider viewerProvider = ViewerProvider.getInstance();
	private LibraryViewer viewer = viewerProvider.getLibraryViewer();

	@Override
	public String execute(String[] params) {
		String response;
		Book book= new Book(params[1],params[2],TypeOfBook.valueOf(params[3].toUpperCase()));
		Book result=new Book();
		try {
			result = libraryServiceForUser.getBook(book);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
		response =viewer.writeResponse(result, "The Book:");
		
		return response;
	}

}
