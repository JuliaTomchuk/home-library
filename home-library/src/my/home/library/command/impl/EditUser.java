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
import my.home.library.view.impl.UserViewerImpl;

public class EditUser implements Command {
	private ServiceProvider provider = ServiceProvider.getInstance();
	private UserService userService = provider.getUserService();
	private ViewerProvider viewerProvider = ViewerProvider.getInstance();
	private UserViewer viewer = viewerProvider.getUserViewer();

	@Override
	public String execute(String[] params) {
		String response;
		
		RegistrationInfo info = new RegistrationInfo();
		info.setLogin(params[1]);
		info.setPassword(params[2]);
		RegistrationInfo edit = new RegistrationInfo(params[3],params[4],Role.valueOf(params[5]));
		edit.setLogin(params[6]);
		edit.setPassword(params[7]);
		
		User user=new User();
		try {
			user = userService.editProfile(info, edit);
		} catch (ServiceException e) {
			
			e.printStackTrace();
		}
		
		response= viewer.writeResponse(user, "The user has been edited");
		return response;
	}

}
