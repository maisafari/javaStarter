package io.altar.res.controller;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.altar.res.Services.ProductService;
import io.altar.res.models.Product;
import io.altar.res.models.Shelf;

@RequestScoped
@Path("api/Product")
public class ProductControler {

	@Inject
	ProductService PS;

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Product setShelf(Product entity) {
		return PS.create(entity);
	}

	@POST
	@Path("/prodUpdate")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void updateProdToShelf(Product entity) {

		if (PS.getIfProductExists(entity.getId()) == false) {
			System.out.println("No Product");
		} else {
			PS.update(entity);
		}
	}

	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Product> getAllProducts() {
		return PS.getAll();
	}

	@GET
	@Path("exist/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Product getProductById(@PathParam("id") long id) {
		return PS.getProductByProductID(id);
	}

	@DELETE
	@Path("/{prodId}")
	public void delete(@PathParam("prodId") long prodId) {
		PS.delete(prodId);
	}

	@POST
	@Path("{prodId}/pvp/{pvp}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updatePvp(@PathParam("prodId") long prodId, @PathParam("pvp") float pvp) {
		PS.setPvp(prodId, pvp);
	}

	@POST
	@Path("{prodId}/iva/{iva}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateIva(@PathParam("prodId") long prodId, @PathParam("iva") float iva) {
		PS.setIva(prodId, iva);

	}

	@POST
	@Path("{prodId}/discount/{disc}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateDiscount(@PathParam("prodId") long prodId, @PathParam("disc") float disc) {
		PS.setDiscount(prodId, disc);
	}
}
