package my.home.library.dao;

import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.User;

public interface  UserDao {
	 
	 boolean registration(RegistrationInfo info);
	 boolean logination (User user);
	

}
