package my.home.library.command.impl;

import java.util.ArrayList;
import java.util.List;

import my.home.library.command.Command;
import my.home.library.entity.Book;
import my.home.library.service.LibraryServiceForUser;
import my.home.library.service.ServiceProvider;
import my.home.library.service.impl.ServiceException;
import my.home.library.view.LibraryViewer;
import my.home.library.view.ViewerProvider;


public class GetAllBooks implements Command{
	
	private ServiceProvider provider=ServiceProvider.getInstance();
	private LibraryServiceForUser libraryService=provider.getLibraryServiceForUser();
	private ViewerProvider viewerProvider = ViewerProvider.getInstance();
	private LibraryViewer viewer = viewerProvider.getLibraryViewer();
	

	@Override
	public String execute(String[] params) {
		String response;
		List<Book> allBooks = new ArrayList<>();
		
		try {
			allBooks = libraryService.getALLBooks();
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		response=viewer.writeResponse(allBooks, "Library:");
		return response;
	}

}
