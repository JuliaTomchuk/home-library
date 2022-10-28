package my.home.library.view;

import my.home.library.view.impl.LibraryViewerImpl;
import my.home.library.view.impl.UserViewerImpl;

public class ViewerProvider {

	private static final ViewerProvider instance = new ViewerProvider();
	private UserViewer userViewer = new UserViewerImpl();
	private LibraryViewer libraryViewer = new LibraryViewerImpl();

	private ViewerProvider() {
	}

	public static ViewerProvider getInstance() {
		return instance;
	}

	public UserViewer getUserViewer() {
		return userViewer;
	}

	public LibraryViewer getLibraryViewer() {
		return libraryViewer;
	}

}
