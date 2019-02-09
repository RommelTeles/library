package com.rommelteles.library.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IRepository<T> extends JpaRepository<T, Long>{
	
	long countById(Long id);

}
