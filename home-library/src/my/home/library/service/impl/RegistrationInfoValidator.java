package my.home.library.service.impl;

import java.util.List;

import my.home.library.entity.RegistrationInfo;

import my.home.library.service.Validator;

public class RegistrationInfoValidator implements Validator<RegistrationInfo> {

	@Override
	public boolean isValid(RegistrationInfo info) {

		if (info.getFirstName() == null || info.getFirstName().isBlank())
			return false;
		if (info.getSecondName() == null || info.getFirstName().isBlank())
			return false;
		if (info.getRole() == null || info.getRole().toString().isBlank())
			return false;
		if (info.getLogin() == null || info.getLogin().isBlank())
			return false;
		if (info.getPassword() == null || info.getPassword().isBlank())
			return false;

		return true;
	}

	@Override
	public boolean isValid(List<RegistrationInfo> userRegistrationInfo) {

		for (int i = 0; i < userRegistrationInfo.size(); i++) {
			if (!(isValid(userRegistrationInfo.get(i))))
				return false;
		}
		return true;
	}

}
