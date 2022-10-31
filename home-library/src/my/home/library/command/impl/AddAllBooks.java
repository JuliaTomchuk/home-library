package my.home.library.command.impl;

import java.util.ArrayList;
import java.util.List;

import my.home.library.command.Command;
import my.home.library.entity.Book;
import my.home.library.entity.TypeOfBook;
import my.home.library.service.LibraryServiceForAdministrator;
import my.home.library.service.ServiceProvider;
import my.home.library.service.impl.ServiceException;
import my.home.library.view.LibraryViewer;
import my.home.library.view.ViewerProvider;

public class AddAllBooks implements Command {
	
	private ServiceProvider serviceProvider = ServiceProvider.getInstance();
	private LibraryServiceForAdministrator  libraryServiceForAdministrator = serviceProvider.getLibraryServiceForAdministrator();
	private ViewerProvider viewerProvider = ViewerProvider.getInstance();
	private LibraryViewer libraryViewer = viewerProvider.getLibraryViewer();

	@Override
	public String execute(String[] params) {
		String response;
		List <Book> library = new ArrayList<>();
		for(int i =1;i<params.length;i++) {
			library.add(new Book(params[i],params[++i],TypeOfBook.valueOf(params[++i].toUpperCase())));
			
		}
		boolean isAdded = false;
		try {
			isAdded = libraryServiceForAdministrator.addAllBooks(library);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
		response=libraryViewer.writeResponse(isAdded, "All books have been added");
		return response;
	}

}
