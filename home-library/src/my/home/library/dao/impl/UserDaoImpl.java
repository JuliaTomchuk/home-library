package my.home.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import my.home.library.dao.UserDao;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.Role;
import my.home.library.entity.User;

public class UserDaoImpl implements UserDao {

	private File file = new File("C:\\Users\\Шипотяне\\git\\home-library\\home-library\\src\\resource\\users.txt");

	@Override
	public User registration(RegistrationInfo info) throws DaoException {

		if (isDuplicate(info)) {
			throw new DaoException("The user with such password or login already exists!");
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

			writer.write(info.getFirstName() + "/" + info.getSecondName() + "/" + info.getRole() + "/" + info.getLogin()
					+ "/" + encrypt(info.getPassword()));
			writer.newLine();

		} catch (IOException e) {
			throw new DaoException(e);
		}

		return info;
	}

	@Override
	public User logination(RegistrationInfo info) throws DaoException {

		List<RegistrationInfo> usersRegistrationInfo = getAllUsersRegistrationInfo();

		User result = findUser(info, usersRegistrationInfo);

		return result;
	}

	private List<RegistrationInfo> getAllUsersRegistrationInfo() throws DaoException {
		List<RegistrationInfo> usersRegistrationInfo = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line = reader.readLine();
			
			

			while (line != null) {
				String[] arr = line.split("/");
				
				RegistrationInfo info = new RegistrationInfo(arr[0], arr[1], Role.valueOf(arr[2]));
				info.setLogin(arr[3]);
				info.setPassword(decrypt(arr[4]));
				
				usersRegistrationInfo.add(info);
				line = reader.readLine();
				
			}
		} catch (IOException e) {
			throw new DaoException(e);
		}
		return usersRegistrationInfo;
	}

	private RegistrationInfo findUser(RegistrationInfo info, List<RegistrationInfo> usersRegistrationInfo)
			throws DaoException {

		RegistrationInfo result = null;

		for (int i = 0; i < usersRegistrationInfo.size(); i++) {
			if (usersRegistrationInfo.get(i).getPassword().equals(info.getPassword())
					&& usersRegistrationInfo.get(i).getLogin().equals(info.getLogin())) {
				result = new RegistrationInfo(usersRegistrationInfo.get(i).getFirstName(),
						usersRegistrationInfo.get(i).getSecondName(), usersRegistrationInfo.get(i).getRole());
				result.setPassword(usersRegistrationInfo.get(i).getPassword());
				result.setLogin(usersRegistrationInfo.get(i).getLogin());
				return result;
			}
		}
		if (result == null) {
			throw new DaoException("No such user");
		}

		return result;
	}

	@Override
	public User editProfile(RegistrationInfo info, RegistrationInfo edit) throws DaoException {

		List<RegistrationInfo> usersRegistrationInfo = getAllUsersRegistrationInfo();

		RegistrationInfo userBeforeEditon = findUser(info, usersRegistrationInfo);

		usersRegistrationInfo.remove(userBeforeEditon);

		updateUsers(usersRegistrationInfo);

		if (isDuplicate(edit)) {
			usersRegistrationInfo.add(info);
			updateUsers(usersRegistrationInfo);
			throw new DaoException("The user with such password or login already exists!");
		}

		usersRegistrationInfo.add(edit);

		updateUsers(usersRegistrationInfo);

		return new User(edit.getFirstName(), edit.getSecondName(), edit.getRole());
	}

	private void updateUsers(List<RegistrationInfo> usersRegistrationInfo) throws DaoException {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {

			for (int i = 0; i < usersRegistrationInfo.size(); i++) {
				RegistrationInfo info = usersRegistrationInfo.get(i);

				writer.write(info.getFirstName() + "/" + info.getSecondName() + "/" + info.getRole() + "/"
						+ info.getLogin() + "/" + encrypt(info.getPassword()));
				writer.newLine();

			}

		} catch (IOException e) {
			throw new DaoException();
		}

	}

	private boolean isDuplicate(RegistrationInfo info) throws DaoException {

		String newLogin = info.getLogin();
		String newPassword = info.getPassword();

		List<RegistrationInfo> usersRegistrationInfo = getAllUsersRegistrationInfo();

		for (int i = 0; i < usersRegistrationInfo.size(); i++) {
			String login = usersRegistrationInfo.get(i).getLogin();
			String password = usersRegistrationInfo.get(i).getPassword();
			if (newLogin.equals(login) || newPassword.equals(password))
				return true;

		}

		return false;

	}
	
	private String encrypt(String password) {
		return Base64.getEncoder().encodeToString(password.getBytes());
	}
	
	private String decrypt(String password) {
		return new String(Base64.getDecoder().decode(password));
	}

}
