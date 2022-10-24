package my.home.library.service;

import my.home.library.service.impl.LibraryServiceForAdministratorImpl;
import my.home.library.service.impl.LibraryServiceForUserImpl;
import my.home.library.service.impl.UserServiceImpl;

public class ServiceProvider {

	private static final ServiceProvider instance = new ServiceProvider();

	private LibraryServiceForAdministrator libraryServiceForAdministrator = new LibraryServiceForAdministratorImpl();

	private LibraryServiceForUser libraryServiceForUser = new LibraryServiceForUserImpl();

	private UserService userService = new UserServiceImpl();

	private ServiceProvider() {

	}

	public static ServiceProvider getInstance() {
		return instance;
	}

	public LibraryServiceForAdministrator getLibraryServiceForAdministrator() {
		return libraryServiceForAdministrator;
	}

	public LibraryServiceForUser getLibraryServiceForUser() {
		return libraryServiceForUser;
	}

	public UserService getUserService() {
		return userService;
	}

}
