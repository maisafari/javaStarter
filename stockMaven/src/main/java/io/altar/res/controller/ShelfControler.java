package io.altar.res.controller;

import java.util.List;

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
import javax.ws.rs.core.Response;

import io.altar.res.Services.ShelfService;
import io.altar.res.models.Shelf;

@RequestScoped
@Path("api/Shelf")
public class ShelfControler {

	@Inject
	ShelfService SS;

	@POST
	@Path("/new")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void setShelf(Shelf entity) {
		SS.create(entity);
	}

	@GET
	@Path("product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shelf> getShelvesByProductID(@PathParam("id") long prodId) {
		if (prodId == 0) {
			return SS.getEmptyShelves();
		} else {
			return SS.getShelvesByProduct(prodId);
		}

	}

	@GET
	@Path("")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shelf> getAllShelves() {
		return SS.getAllShelves();
	}

	@GET
	@Path("empty")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Shelf> getEmptyShelf() {
		return SS.getEmptyShelves();
	}

	@POST
	@Path("{shelfId}/capacity/{cap}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateCapacity(@PathParam("shelfId") long shelfId, @PathParam("cap") float cap) {
		SS.setCapacity(shelfId, cap);
	}

	@POST
	@Path("{shelfId}/dailyPrice/{dP}")
	@Produces(MediaType.APPLICATION_JSON)
	public void updateDailyPrice(@PathParam("shelfId") long shelfId, @PathParam("dP") float dP) {
		SS.setDailyPrice(shelfId, dP);
	}

	@DELETE
	@Path("/{shelfId}")
	public void delete_1(@PathParam("shelfId") long shelfId) {
		SS.delete(shelfId);
	}

	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) {
		try {
			SS.delete(id);
			return Response.ok().build();
		} catch (UnsupportedOperationException e) {
			return Response.status(403).entity(e.getMessage()).build();
		} catch (IllegalArgumentException e) {
			return Response.status(400).entity(e.getMessage()).build();
		}
	}
}
