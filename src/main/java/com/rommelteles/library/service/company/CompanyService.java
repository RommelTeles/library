package com.rommelteles.library.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rommelteles.library.entity.company.Company;
import com.rommelteles.library.infrastructure.AbstractService;
import com.rommelteles.library.infrastructure.IRepository;
import com.rommelteles.library.repository.company.CompanyRepository;

@Service
public class CompanyService extends AbstractService<Company> {
	
	@Autowired
	private CompanyRepository repository;

	@Override
	protected IRepository<Company> getRepository() {
		return repository;
	}

}
