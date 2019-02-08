package com.rommelteles.library.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TB_USER")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false, of = { "id" })
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3450976227781689300L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_USER")
	private Long id;
	
	@NotNull
	@Column(name = "CODE")
	private Long code;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "TELEPHONE_NUMBER")
	private String telephoneNumber;

}
