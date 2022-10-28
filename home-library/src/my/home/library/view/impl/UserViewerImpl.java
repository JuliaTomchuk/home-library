package my.home.library.view.impl;

import my.home.library.entity.User;
import my.home.library.view.UserViewer;

public class UserViewerImpl implements UserViewer {

	public String writeResponse(User user, String response) {
		if (user.getFirstName() != null && user.getSecondName() != null && user.getRole() != null) {

			System.out.println(response);
			System.out.println(user.toString());
			return response;
		} else {
			response = "Something went wrong";
			System.out.println(response);
			return response;
		}

	}

}
