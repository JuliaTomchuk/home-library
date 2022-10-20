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
import my.home.library.entity.Role;
import my.home.library.entity.User;

public class UserDaoImpl implements UserDao {

	private File file = new File("C:\\Users\\Aleksandr\\git\\library\\home-library\\src\\resource\\users.txt");

	@Override
	public User registration(User user) throws DaoException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {

			writer.write(user.getFirstName() + "/" + user.getSecondName() + "/" + user.getLogin() + "/"
					+ user.getPassword() + "/" + user.getRole());
			writer.newLine();

		} catch (IOException e) {
			throw new DaoException();
		}
		return user;
	}

	@Override
	public User logination(String login, String password) throws DaoException {

		List<User> users = getAllUsers();

		User result = findUser(login, password, users);

		return result;
	}

	private List<User> getAllUsers() throws DaoException {
		List<User> users = new ArrayList<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

			String line = reader.readLine();

			while (line != null) {
				String[] arr = line.split("/");
				users.add(new User(arr[0], arr[1], arr[2], arr[3], Role.valueOf(arr[4])));
				line = reader.readLine();
			}
		} catch (IOException e) {
			throw new DaoException();
		}
		return users;
	}

	private User findUser(String login, String password, List<User> users) throws DaoException {

		User result = new User();

		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getPassword().equals(password) && users.get(i).getLogin().equals(login)) {
				result = users.get(i);
			} else {
				throw new DaoException("No such user");
			}
		}
		return result;
	}

	@Override
	public User editProfile(String login, String password, User editUser) throws DaoException {
		List<User> users = getAllUsers();
		User userBeforeEditon = findUser(login, password, users);
		users.remove(userBeforeEditon);
		users.add(editUser);
		updateUsers(users);

		return editUser;
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
