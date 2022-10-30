package my.home.library.menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import my.home.library.entity.Role;

public class AccessControl {
	
	public Role determineRole(String user) {
				
		String regex="ADMINISTRATOR|SIMPLE_USER";
		Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher(user);
	    Role role=Role.SIMPLE_USER;
	    while (matcher.find()) {
	      role=Role.valueOf(matcher.group());
	    }
		return role;
		
	}
	
   

}
