package my.home.library.controller.impl;

import my.home.library.command.Command;
import my.home.library.command.CommandProvider;
import my.home.library.controller.Controller;

public class ControllerImpl implements Controller {
	
	private CommandProvider commandProvider = new CommandProvider();
	
	

	@Override
	public String doAction(String request) {
		String response="";
		
		String [] param = request.split("/");
		
		
		Command command=commandProvider.getCommand(param[0]);
		response = command.execute(param);
				
		
		return response;
	}
	
	

}
