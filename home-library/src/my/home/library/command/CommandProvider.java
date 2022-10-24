package my.home.library.command;


import java.util.EnumMap;
import java.util.Map;
import my.home.library.command.impl.AddAllBooks;
import my.home.library.command.impl.AddBook;
import my.home.library.command.impl.CommandName;
import my.home.library.command.impl.DeleteBook;
import my.home.library.command.impl.EditUser;
import my.home.library.command.impl.GetAllBooks;
import my.home.library.command.impl.GetBook;
import my.home.library.command.impl.Logination;
import my.home.library.command.impl.Registration;
import my.home.library.command.impl.UpdateAllBooks;

public class CommandProvider {
	
		
	private Map <CommandName,Command> commands= new EnumMap<>(CommandName.class);
	
	public CommandProvider(){
		
		commands.put(CommandName.ADD_ALL_BOOKS, new AddAllBooks());
		commands.put(CommandName.ADD_BOOK, new AddBook());
		commands.put(CommandName.DELETE_BOOK, new DeleteBook());
		commands.put(CommandName.EDIT_USER, new EditUser());
		commands.put(CommandName.GET_ALL_BOOKS, new GetAllBooks());
		commands.put(CommandName.GET_BOOK, new GetBook());
		commands.put(CommandName.LOGINATION, new Logination());
		commands.put(CommandName.REGISTRATION, new Registration());
		commands.put(CommandName.UPDATE_ALL_BOOKS, new UpdateAllBooks());
		
	}
	
	public Command getCommand(String commandName) {
		
		CommandName name = CommandName.valueOf(commandName.toUpperCase());
		return commands.get(name);
	}
	
	
	

}
