package io.altar.stockMaven.repositories;

import javax.enterprise.context.ApplicationScoped;

import io.altar.stockMaven.models.Shelf;
import io.altar.stockMaven.repositories.EntityRepository;

@ApplicationScoped
public class ShelfRepository extends EntityRepository<Shelf> {
	
	@Override
	protected Class<Shelf> getEntityClass() {
		return Shelf.class;
	}
}
