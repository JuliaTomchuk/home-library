package my.home.library.command.impl;

import my.home.library.command.Command;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.Role;
import my.home.library.entity.User;
import my.home.library.service.ServiceProvider;
import my.home.library.service.UserService;
import my.home.library.service.impl.ServiceException;
import my.home.library.view.UserViewer;
import my.home.library.view.ViewerProvider;



public class Registration implements Command {
	
	private ViewerProvider viewerProvider = ViewerProvider.getInstance();	
	private UserViewer viewer = viewerProvider.getUserViewer();	
	private ServiceProvider serviceProvider = ServiceProvider.getInstance();
	private UserService userService = serviceProvider.getUserService();
	
	@Override
	public String execute(String[] params) {
		
		RegistrationInfo newUser = new RegistrationInfo();
		String response;
		
		newUser.setFirstName(params[1]);
		newUser.setSecondName(params[2]);
		newUser.setRole(Role.valueOf(params[3].toUpperCase()));
		newUser.setLogin(params[4]);
		newUser.setPassword(params[5]);		
		User user= new User();
		try {
			 user = userService.registration(newUser);
			
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		response= viewer.writeResponse(user, "Hello");
		return response;
		
		
	}

}
