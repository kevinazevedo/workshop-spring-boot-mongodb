package com.kevinazevedo.workshopmongo.config;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.kevinazevedo.workshopmongo.domain.Post;
import com.kevinazevedo.workshopmongo.domain.User;
import com.kevinazevedo.workshopmongo.repository.PostRepository;
import com.kevinazevedo.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User elon = new User(null, "Elon Musk", "musk@gmail.com");
		User mark = new User(null, "Mark Zuck", "mark@gmail.com");
		User chris = new User(null, "Chris Walker", "chris@gmail.com");	
		
		Post post1 = new Post(null, LocalDate.parse("02/05/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", elon);
		Post post2 = new Post(null, LocalDate.parse("03/05/2024", DateTimeFormatter.ofPattern("dd/MM/yyyy")), "Bom dia", "Acordei feliz hoje!", elon);
		
		userRepository.saveAll(Arrays.asList(elon, mark, chris));
		postRepository.saveAll(Arrays.asList(post1, post2));
	}
}
