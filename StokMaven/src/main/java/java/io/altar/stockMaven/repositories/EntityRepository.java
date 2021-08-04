package io.altar.stockMaven.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import io.altar.stockMaven.models.Entity_;

public abstract class EntityRepository<E extends Entity_> {
	
	@PersistenceContext(unitName = "database")
	protected EntityManager eManager;
		
	abstract Class<E> getEntityClass();
	
	public E getEntity(long id) {
		return eManager.find(getEntityClass(), id);
	}
	
	public Long addEntity(E entity) {
		return eManager.merge(entity).getId();
	}
	
	public E editEntity(E entity) {
		return eManager.merge(entity);
	}
	
	public void removeEntity(long id) {
		E entity = getEntity(id);
		if(entity != null) {
			eManager.remove(entity);
		}
	}	
}
