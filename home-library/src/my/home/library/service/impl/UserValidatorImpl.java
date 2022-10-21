package my.home.library.service.impl;


import my.home.library.entity.User;
import my.home.library.service.UserValidator;

public class UserValidatorImpl implements UserValidator{

	@Override
	public boolean checkUser(User user) {
	if(user.getFirstName()==null||user.getFirstName().isBlank())
		return false;
	if(user.getSecondName()==null||user.getFirstName().isBlank())
		return false;
	if(user.getRole()==null||user.getRole().toString().isBlank())
		return false;
	return true;
	}
	
	

}
