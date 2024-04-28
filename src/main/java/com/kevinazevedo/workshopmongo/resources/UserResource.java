package com.kevinazevedo.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kevinazevedo.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {	
		User elon = new User("1", "Elon Musk", "musk@gmail.com");
		User mark = new User("2", "Mark Zuck", "mark@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(elon, mark));
		return ResponseEntity.ok().body(list);
	}
}
