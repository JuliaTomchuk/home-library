package my.home.library.service.impl;

import my.home.library.dao.DaoProvider;
import my.home.library.dao.UserDao;
import my.home.library.dao.impl.DaoException;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.User;
import my.home.library.service.UserService;
import my.home.library.service.Validator;

public class UserServiceImpl implements UserService {

	private DaoProvider daoProvider = DaoProvider.getInstance();
	private UserDao userDao = daoProvider.getUserDao();
	private Validator<RegistrationInfo> validator = new RegistrationInfoValidator();

	@Override
	public User logination(RegistrationInfo info) throws ServiceException {
		if (info.getPassword()==null ||info.getLogin()==null) {
			throw new ServiceException("Regestration info isn't correct");
		}
		User user = new User();
		try {
			user =userDao.logination(info);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
		return user;
	}

	@Override
	public User registration(RegistrationInfo info) throws ServiceException {
		if (!(validator.isValid(info))) {
			throw new ServiceException("Regestration info isn't correct");
		}

		User user;
		try {
			user = userDao.registration(info);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return user;
	}

	@Override
	public User editProfile(RegistrationInfo info, RegistrationInfo edit) throws ServiceException {
		if (info.getPassword()==null ||info.getLogin()==null ||!(validator.isValid(edit))) {
			throw new ServiceException("Regestration info isn't correct");
		}
		User user = new User();
		try {
			user = userDao.editProfile(info, edit);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}

		return user;
	}

}
