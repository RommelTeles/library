package com.rommelteles.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rommelteles.library.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{

}
