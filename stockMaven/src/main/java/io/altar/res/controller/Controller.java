package io.altar.res.controller;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.res.Services.ProductService;
import io.altar.res.Services.ShelfService;
import io.altar.res.models.Product;
import io.altar.res.models.Shelf;

@RequestScoped
@Path("")
public class Controller {

	@Inject
	ProductService PS;
	@Inject
	ShelfService SS;

	@GET
	@Path("oneToMany")
	public void oneToMany() {
		Product p1 = new Product();
		p1 = PS.create(p1);

		Shelf s1 = new Shelf();
		s1.setProduct(p1);
		s1 = SS.create(s1);

		Shelf s2 = new Shelf();
		s2.setProduct(p1);
		s2 = SS.create(s2);
	}

	
	@POST
	@Path("/productToShelf/{shelfId}/{prodId}")
	@Produces(MediaType.APPLICATION_JSON)
	public void setProdToShelf(@PathParam("shelfId") long shelfId, @PathParam("prodId") long prodId) {

		if (PS.getIfProductExists(prodId) == false) {
			System.out.println("No Product");
		} else if (SS.getIfShelfExists(shelfId) == false) {
			System.out.println("No Shelf");
		} else {

			Shelf s = SS.get(shelfId);
			s.setProduct(PS.get(prodId));
			SS.update(s);

		}

	}
	
	@DELETE
	@Path("del/{prodId}")
	public void delete(@PathParam("prodId") long prodId) {
	for( Shelf  s : SS.getShelvesByProduct(prodId)) {
		
		SS.delete(s.getId());
	}
		PS.delete(prodId);
	}

}
