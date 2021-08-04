package io.altar.stockMaven.controller;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Path;

import io.altar.stockMaven.models.Shelf;
import io.altar.stockMaven.repositories.ShelfRepository;
import io.altar.stockMaven.services.ShelfService;

@RequestScoped
@Path("shelf")
public class ShelfController extends EntityController<ShelfService, ShelfRepository, Shelf>{


}