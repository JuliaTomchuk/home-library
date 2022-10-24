package my.home.library.command.impl;

import my.home.library.command.Command;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.Role;
import my.home.library.service.ServiceProvider;



public class Registration implements Command {

	
	private ServiceProvider serviceProvider = ServiceProvider.getInstance();
	@Override
	public String execute(String[] params) {
		
		RegistrationInfo newUser = new RegistrationInfo();
		String response="";
		
		newUser.setFirstName(params[0]);
		newUser.setSecondName(params[1]);
		newUser.setRole(Role.valueOf(params[2]));
		newUser.setLogin(params[3]);
		newUser.setPassword(params[4]);		
		serviceProvider.getUserService().registration(newUser);
		
		
	}

}
