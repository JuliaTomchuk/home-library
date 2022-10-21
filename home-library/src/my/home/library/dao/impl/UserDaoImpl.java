package my.home.library.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import my.home.library.dao.UserDao;
import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.Role;
import my.home.library.entity.User;

public class UserDaoImpl implements UserDao {

	private File file = new File("C:\\Users\\Aleksandr\\git\\library\\home-library\\src\\resource\\users.txt");

	@Override
	public User registration(RegistrationInfo info) throws DaoException {
		//проверить есть ли пользователь с такими же registrationinfo
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

			writer.write(info.getFirstName() + "/" + info.getSecondName() + "/" + info.getRole() + "/"
					+ info.getLogin() + "/" + info.getPassword() );
			writer.newLine();

		} catch (IOException e) {
			throw new DaoException(e);
		}
		
		return new User(info.getFirstName(),info.getSecondName(),info.getRole());
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
				RegistrationInfo info = new RegistrationInfo(arr[0],arr[1],Role.valueOf(arr[2]));
				info.setLogin(arr[3]);
				info.setPassword(arr[4]);
				usersRegistrationInfo.add(info );
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new DaoException();
		}
		return usersRegistrationInfo;
	}

	private RegistrationInfo findUser(RegistrationInfo info, List<RegistrationInfo> usersRegistrationInfo) throws DaoException {

		RegistrationInfo result = new RegistrationInfo();

		for (int i = 0; i < usersRegistrationInfo.size(); i++) {
			if (usersRegistrationInfo.get(i).getPassword().equals(info.getPassword()) && usersRegistrationInfo.get(i).getLogin().equals(info.getLogin())) {
				result =new RegistrationInfo( usersRegistrationInfo.get(i).getFirstName(),usersRegistrationInfo.get(i).getSecondName(),usersRegistrationInfo.get(i).getRole());
				result.setPassword(usersRegistrationInfo.get(i).getPassword());
				result.setLogin(usersRegistrationInfo.get(i).getLogin());
			} else {
				throw new DaoException("No such user");
			}
		}
		return result;
	}

	@Override
	public RegistrationInfo editProfile(RegistrationInfo info) throws DaoException {
		List<RegistrationInfo> usersRegistrationInfo = getAllUsersRegistrationInfo();
		RegistrationInfo userBeforeEditon = findUser(info, usersRegistrationInfo);
		usersRegistrationInfo.remove(userBeforeEditon);
		usersRegistrationInfo.add(info);
		updateUsers(usersRegistrationInfo);

		return info;
	}

	private void updateUsers(List<User> users) throws DaoException {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, false))) {

			for (int i = 0; i < users.size(); i++) {
				User user = users.get(i);

				writer.write(user.getFirstName() + "/" + user.getSecondName() + "/" + user.getLogin() + "/"
						+ user.getPassword() + "/" + user.getRole());
				writer.newLine();

			}

		} catch (IOException e) {
			throw new DaoException();
		}

	}

}
