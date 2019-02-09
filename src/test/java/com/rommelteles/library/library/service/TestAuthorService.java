package com.rommelteles.library.library.service;

import java.io.IOException;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rommelteles.library.entity.author.Author;
import com.rommelteles.library.service.author.AuthorService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAuthorService {
	
	@Autowired
	private AuthorService service;
	
	@Test
	public void insertOK() throws IOException {
		Author author = new Author();
		author.setName("Machado de Assis");
	    author = this.service.insert(author);
	    Assert.assertNotNull(author.getId());
	}

}
