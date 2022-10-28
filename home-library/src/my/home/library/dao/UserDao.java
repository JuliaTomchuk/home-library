package my.home.library.dao;

import my.home.library.dao.impl.DaoException;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.User;

public interface UserDao {

	User registration(RegistrationInfo info) throws DaoException;

	User logination(RegistrationInfo info) throws DaoException;

	User editProfile(RegistrationInfo info, RegistrationInfo edit) throws DaoException;

}
