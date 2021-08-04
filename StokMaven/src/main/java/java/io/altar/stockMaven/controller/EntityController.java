package io.altar.stockMaven.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.stockMaven.models.Entity_;
import io.altar.stockMaven.repositories.EntityRepository;
import io.altar.stockMaven.services.EntityService;


//R repository
//S service
//E entity
public abstract class EntityController<S extends EntityService<R, E>, R extends EntityRepository<E>, E extends Entity_ > {

	@Inject
	protected S service;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Long addEntity(E entity) {
		return service.addEntity(entity);
	}
	
	@GET
	public E getEntity(long id) {
		return service.getEntity(id);
	}
	
	@PUT
	public E editEntity(E entity) {
		return service.editEntity(entity);
	}
	
	
	@DELETE
	public void removeEntity(long id) {
	    service.removeEntity(id);
	}
	
}
