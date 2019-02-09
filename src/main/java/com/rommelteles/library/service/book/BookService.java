package com.rommelteles.library.service.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rommelteles.library.entity.book.Book;
import com.rommelteles.library.infrastructure.AbstractService;
import com.rommelteles.library.infrastructure.IRepository;
import com.rommelteles.library.repository.book.BookRepository;

@Service
public class BookService extends AbstractService<Book>{
	
	@Autowired
	private BookRepository repository;

	@Override
	protected IRepository<Book> getRepository() {
		return repository;
	}

}
