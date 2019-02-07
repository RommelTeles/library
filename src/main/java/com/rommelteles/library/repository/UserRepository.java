package com.rommelteles.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rommelteles.library.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
