package my.home.library.command.impl;

import my.home.library.command.Command;
import my.home.library.entity.Book;
import my.home.library.entity.TypeOfBook;
import my.home.library.service.LibraryServiceForAdministrator;
import my.home.library.service.ServiceProvider;
import my.home.library.service.impl.ServiceException;
import my.home.library.view.LibraryViewer;
import my.home.library.view.ViewerProvider;

public class DeleteBook implements Command {
	
	private ServiceProvider serviceProvider = ServiceProvider.getInstance();
	private LibraryServiceForAdministrator libraryService=serviceProvider.getLibraryServiceForAdministrator();
	private ViewerProvider viewerProvider =ViewerProvider.getInstance();
	private LibraryViewer libraryViewer= viewerProvider.getLibraryViewer();

	@Override
	public String execute(String[] params) {
		String response;
		Book book=new Book(params[1],params[2],TypeOfBook.valueOf(params[3].toUpperCase()));		
		
		boolean isDeleted=false;
		try {
			isDeleted = libraryService.deleteBook(book);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		response=libraryViewer.writeResponse(isDeleted,"The book has been deleted");
		
		return response;
	}

}
