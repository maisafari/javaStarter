package io.altar.stockMaven.services;

import javax.inject.Inject;
import javax.transaction.Transactional;

import io.altar.stockMaven.models.Entity_;
import io.altar.stockMaven.repositories.EntityRepository;

@Transactional
public abstract class EntityService<R extends EntityRepository<E>, E extends Entity_> {
	
	@Inject
	protected R repository;
	
	public Long addEntity(E entity) {
		return repository.addEntity(entity);
	}
	
	public E getEntity(long id) {
		return repository.getEntity(id);
	}
	
	public E editEntity(E entity) {
		return repository.editEntity(entity);
	}
	
	public void removeEntity(long id) {
	    repository.removeEntity(id);
	}
}
