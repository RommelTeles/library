package com.rommelteles.library.service.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rommelteles.library.entity.author.Author;
import com.rommelteles.library.infrastructure.AbstractService;
import com.rommelteles.library.infrastructure.IRepository;
import com.rommelteles.library.repository.author.AuthorRepository;

@Service
public class AuthorService extends AbstractService<Author> {
	
	@Autowired
	private AuthorRepository repository;

	@Override
	protected IRepository<Author> getRepository() {
		return repository;
	}

}
