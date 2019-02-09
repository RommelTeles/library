package com.rommelteles.library.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rommelteles.library.entity.user.User;
import com.rommelteles.library.infrastructure.AbstractService;
import com.rommelteles.library.infrastructure.IRepository;
import com.rommelteles.library.repository.user.UserRepository;

@Service
public class UserService extends AbstractService<User>{
	
	@Autowired
	private UserRepository repository;

	@Override
	protected IRepository<User> getRepository() {
		return repository;
	}

}
