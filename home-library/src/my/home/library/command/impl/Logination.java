package my.home.library.command.impl;

import my.home.library.command.Command;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.User;
import my.home.library.service.ServiceProvider;
import my.home.library.service.UserService;
import my.home.library.service.impl.ServiceException;
import my.home.library.view.UserViewer;
import my.home.library.view.ViewerProvider;


public class Logination implements Command {
	
	private ServiceProvider serviceProvider = ServiceProvider.getInstance();
	private UserService userService = serviceProvider.getUserService();
	private ViewerProvider viewerProvider = ViewerProvider.getInstance();
	private UserViewer userViewer = viewerProvider.getUserViewer();

	@Override
	public String execute(String[] params) {
		String response;
		RegistrationInfo info = new RegistrationInfo();
		info.setLogin(params[1]);
		info.setPassword(params[2]);
		User user=new User();
		try {
			user = userService.logination(info);
					} catch (ServiceException e) {
			e.printStackTrace();
		}
		response =userViewer.writeResponse(user, "Hello");
		return response;
	}

}
