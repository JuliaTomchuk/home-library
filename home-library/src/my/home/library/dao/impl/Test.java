package my.home.library.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import my.home.library.entity.RegistrationInfo;
import my.home.library.entity.Role;

public class Test {
	
	public static void main (String [] args) throws IOException {
		
		RegistrationInfo info = new RegistrationInfo("Ann","Tomchuk",Role.SIMPLE_USER);
		info.setLogin("ANNTomchuk_");
		info.setPassword("12345");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File("C:\\Users\\Aleksandr\\git\\library\\home-library\\src\\resource\\books.txt")));
	writer.newLine();
	
	}

}
