package my.home.library.dao;

import my.home.library.dao.impl.LibraryDaoImpl;
import my.home.library.dao.impl.UserDaoImpl;

public class DaoProvider {
	
	private static final DaoProvider instance = new DaoProvider();
	private LibraryDao libraryDao= new LibraryDaoImpl();
	private UserDao userDao= new UserDaoImpl();
	
	private DaoProvider() {}
	
	public static DaoProvider getInstance() {
		return instance;
	}
	
	public LibraryDao getLibraryDao() {
		return libraryDao;
	}
	
	public UserDao getUserDao() {
		return userDao;
	}

}
