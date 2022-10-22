package my.home.library.service;

import my.home.library.entity.User;
import my.home.library.service.impl.ServiceException;

public interface UserValidator {
	boolean checkUser(User user);

}
