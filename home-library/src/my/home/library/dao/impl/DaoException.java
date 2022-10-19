package my.home.library.dao.impl;

public class DaoException  extends Exception{

	
	private static final long serialVersionUID = 2940782846952207880L;
	
	public DaoException() {
		super();
	}
	public DaoException(Exception e) {
		super(e);
	}
	public DaoException(String message) {
		super(message);
	}
	public DaoException(Exception e, String message) {
		super( message, e);
	}
	

}
