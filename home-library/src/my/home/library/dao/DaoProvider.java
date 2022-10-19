package my.home.library.dao;

import my.home.library.dao.impl.LibraryForAdminDaoImpl;
import my.home.library.dao.impl.LibraryForUsersDaoImpl;
import my.home.library.dao.impl.UserDaoImpl;

public class DaoProvider {

	private static final DaoProvider instance = new DaoProvider();
	private LibraryForUsersDao libraryForUserDao = new LibraryForUsersDaoImpl();
	private LibraryForAdminDao libraryForAdminDao = new LibraryForAdminDaoImpl();
	private UserDao userDao = new UserDaoImpl();

	private DaoProvider() {
	}

	public static DaoProvider getInstance() {
		return instance;
	}

	public LibraryForUsersDao getLibraryForUsersDao() {
		return libraryForUserDao;
	}
	
	public LibraryForAdminDao getLibraryForAdminDao() {
		return libraryForAdminDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

}
