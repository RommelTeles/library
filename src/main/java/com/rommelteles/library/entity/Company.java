package com.rommelteles.library.entity;

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

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TB_COMPANY")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = {"id"})
public class Company implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8534002805846207644L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="ID_COMPANY")
	private Long id;
	
	@NotNull
	@Column(name="NAME")
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "company", orphanRemoval = true)
	private Collection<Book> books;
	
}
