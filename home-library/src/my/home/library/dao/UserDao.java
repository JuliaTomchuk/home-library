package my.home.library.dao;

import my.home.library.dao.impl.DaoException;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.User;

public interface  UserDao {
	 
	 boolean registration(User user)throws DaoException;
	 boolean logination (User user)throws DaoException;
	 
	

}
