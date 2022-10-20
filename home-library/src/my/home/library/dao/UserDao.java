package my.home.library.dao;

import my.home.library.dao.impl.DaoException;
import my.home.library.entity.User;

public interface  UserDao {
	 
	 User registration(User user)throws DaoException;
	 User logination(String login, String password) throws DaoException;
	 User editProfile(String login, String password, User editUser) throws DaoException;
	 
	

}
