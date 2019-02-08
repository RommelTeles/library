package com.rommelteles.library.entity.author;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rommelteles.library.entity.book.Book;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_AUTHOR")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = {"id"})
public class Author implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5035030867951670200L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_AUTHOR")
	private Long id;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
	private Collection<Book> books;

}
