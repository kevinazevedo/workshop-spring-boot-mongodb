package com.kevinazevedo.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kevinazevedo.workshopmongo.domain.User;
import com.kevinazevedo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {		
		userRepository.deleteAll();
		User elon = new User(null, "Elon Musk", "musk@gmail.com");
		User mark = new User(null, "Mark Zuck", "mark@gmail.com");
		User chris = new User(null, "Chris Walker", "chris@gmail.com");	
		userRepository.saveAll(Arrays.asList(elon, mark, chris));
	}
}
