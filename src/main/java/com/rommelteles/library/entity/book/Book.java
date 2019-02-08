package com.rommelteles.library.entity.book;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.rommelteles.library.entity.author.Author;
import com.rommelteles.library.entity.company.Company;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_BOOK")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = {"id"})
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8935587443390313693L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_BOOK")
	private Long id;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "FK_AUTHOR", nullable = false)
	private Author author;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "FK_COMPANY", nullable = false)
	private Company company;

}
