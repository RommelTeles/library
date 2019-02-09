package com.rommelteles.library.infrastructure;

import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

public abstract class AbstractService<T> {

	@Autowired
	protected abstract IRepository<T> getRepository();

	@Transactional(rollbackFor = Throwable.class)
	public T insert(final T entity) throws IOException {
		return this.getRepository().save(entity);
	}

	@Transactional(rollbackFor = Throwable.class)
	public T update(final T entity) throws IOException {
		return this.getRepository().save(entity);
	}

	@Transactional(rollbackFor = Throwable.class)
	public void delete(final Long entityId) throws IOException {
		this.getRepository().deleteById(entityId);
	}

	@Transactional(readOnly = true)
	public T findById(final Long entityId) {
		T result;
		try {
			Optional<T> optional = this.getRepository().findById(entityId);
			result = optional.orElse(null);
		} catch (final NoSuchElementException e) {
			result = null;
		}
		return result;
	}

	@Transactional(readOnly = true)
	public boolean exists(final Long entityId) {
		return this.getRepository().countById(entityId) != 0;
	}

	
    @Transactional(readOnly = true)
    public List<T> findAll() {
        return this.getRepository().findAll();
    }

   
    @Transactional(readOnly = true)
    public List<T> findAll(Sort sort) {
        return this.getRepository().findAll(sort);
    }
	
}
