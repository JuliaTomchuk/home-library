package my.home.library.view.impl;

import java.util.List;

import my.home.library.entity.Book;
import my.home.library.view.LibraryViewer;

public class LibraryViewerImpl implements LibraryViewer{
	@Override
	public String writeResponse(boolean result, String response) {
		if(result) {
			System.out.println(response);
			return response;
		}else {response = "Something went wrong";
		System.out.println(response);
		}
		
		return response;
	}
	@Override
  public String writeResponse(Book book, String response) {
		if(book!=null) {
			System.out.println(response + " " +book.toString());
			return response;
		}else {response = "Something went wrong";
		System.out.println(response);
		}
		
		return response;
	}
	@Override
  public String writeResponse(List<Book> library, String response) {
		if(library!=null) {
			System.out.println(response + " " +library.toString());
			return response;
		}else {response = "Something went wrong";
		System.out.println(response);
		}
		
		return response;
	}

	

	
}
