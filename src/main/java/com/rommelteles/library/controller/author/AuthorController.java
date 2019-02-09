package com.rommelteles.library.controller.author;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rommelteles.library.entity.author.Author;
import com.rommelteles.library.service.author.AuthorService;

@RestController
@RequestMapping(value = "/author")
@CrossOrigin(origins = "*")
public class AuthorController {

	@Autowired
	private AuthorService service;

	@GetMapping("/authors")
	public List<Author> getAll() {
		List<Author> list = new ArrayList<>();
		Author author = new Author();
		author.setName("Teste");
		author.setId(1L);
		list.add(author);
		return list;
	}

	@PostMapping
	public ResponseEntity<Author> newAuthor(@RequestBody Author author) throws IOException {
		this.service.insert(author);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Author> delete(@PathVariable("id") final Long id)
			throws IOException {
		this.service.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
