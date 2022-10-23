package my.home.library.service;

import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.User;
import my.home.library.service.impl.ServiceException;

public interface UserService {

	User logination(RegistrationInfo info) throws ServiceException;

	User registration(RegistrationInfo info) throws ServiceException;

	User editProfile(RegistrationInfo info, RegistrationInfo edit) throws ServiceException;

}
