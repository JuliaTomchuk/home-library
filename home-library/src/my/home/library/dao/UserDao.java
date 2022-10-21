package my.home.library.dao;

import my.home.library.dao.impl.DaoException;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.User;

public interface  UserDao {
	 
	RegistrationInfo registration(RegistrationInfo info)throws DaoException;
	 RegistrationInfo logination(RegistrationInfo info) throws DaoException;
	 RegistrationInfo editProfile(RegistrationInfo info) throws DaoException;
	 
	

}
