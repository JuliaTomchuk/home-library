package my.home.library.service;

import my.home.library.entity.User;
import my.home.library.service.impl.ServiceException;

public interface UserService {

	User logination(String login, String password) throws ServiceException;

	User registration(User user) throws ServiceException;

	User editProfile() throws ServiceException;

}
