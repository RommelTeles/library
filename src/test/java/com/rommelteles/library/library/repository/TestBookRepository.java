package com.rommelteles.library.library.repository;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rommelteles.library.entity.author.Author;
import com.rommelteles.library.entity.book.Book;
import com.rommelteles.library.entity.company.Company;
import com.rommelteles.library.repository.author.AuthorRepository;
import com.rommelteles.library.repository.book.BookRepository;
import com.rommelteles.library.repository.company.CompanyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestBookRepository {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private AuthorRepository authorRepository;

	@Test
	public void persistenceFalls() {
		Book book = new Book();
		try {
			bookRepository.save(book);
			Assert.fail("Erro, não deve ser possível salvar uma entidade com todos os atributos null");
		} catch (Exception e) {
			Assert.assertNotNull(e.getMessage());
		}

	}

	@Test
	public void persistenceOK() {
		Book book = this.bookRepository.save(createBook("Rocco", "Eckart Tolle", "Poder do Agora"));
		Assert.assertThat(book.getId(), CoreMatchers.notNullValue());
	}

	@Test
	public void getOK() {
		Book book = this.bookRepository.save(createBook("Continental", "Machado de Asis", "Comeco"));
		Book bookFromDB = this.bookRepository.findById(book.getId()).get();
		Assert.assertThat(bookFromDB.getId(), CoreMatchers.notNullValue());
		Assert.assertThat(book.getName(), CoreMatchers.equalTo(bookFromDB.getName()));
		Assert.assertThat(book.getCompany().getName(), CoreMatchers.equalTo(bookFromDB.getCompany().getName()));
		Assert.assertThat(book.getAuthor().getName(), CoreMatchers.equalTo(bookFromDB.getAuthor().getName()));
	}

	private Book createBook(String companyName, String authorName, String bookName) {
		Company company = new Company();
		company.setName("Rocco");

		this.companyRepository.save(company);

		Author author = new Author();
		author.setName("Ekckart Tolle");

		this.authorRepository.save(author);

		Book book = new Book();
		book.setName("Poder do Agora");
		book.setAuthor(author);
		book.setCompany(company);
		return book;
	}

}
