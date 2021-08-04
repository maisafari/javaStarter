package io.altar.stockMaven.services;

import javax.enterprise.context.RequestScoped;

import io.altar.stockMaven.models.Shelf;
import io.altar.stockMaven.repositories.ShelfRepository;

@RequestScoped
public class ShelfService extends EntityService<ShelfRepository, Shelf> {
	
}
